package kiosk.Kiosk_Lv7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//사용자 입력 처리, 키오스크 메뉴 관리
public class Kiosk {
    //속성
    private List<Menu> menus; // MenuItem울 관리하는 리스트
    Cart cart;  //장바구니
    //생성자
    public Kiosk(List<Menu> menus) {
        this.menus = menus;
        this.cart = new Cart(new ArrayList<>()); //키오스크가 실행 되자마자 장바구니에 들어있는게 없으므로 빈 리스트 생성
    }

    //메서드

    /**
     * 메뉴를 보고 사용자가 직접 선택할 수 있는 키오스크를 실행시키는 메서드
     */
    public void start() {
        List<MenuItem> menuItemsByCategory; // 카테고리에 맞는 메뉴 목록
        MenuItem selectMenuItem;  //선택한 메뉴 정보 저장

        int selectMenuItemNum; // 사용자가 선택한 메뉴 번호
        int menuItemCount; // 메뉴의 개수

        int selectCategoryNum; // 카테고리 선택
        int categoryCount = menus.size(); // 카테고리 개수

        int addToCartChoice; //장바구니 추가 선택
        int orderChoice;     //주문 선택
        boolean hasMenuItemInCart = false; //Order Menu 활성화 (장바구니에 물건이 존재하면)

        int discountTypeChoice;  //할인 유형 선택

        float totalPrice; //총 금액(할인 전)

        String removeMenuItem; //제거할 메뉴
        List<String> removeMenusItemList; //제거할 메뉴들 리스트화


        Scanner sc = new Scanner(System.in);

        while(true) {
            /**
             * 카테고리 출력
             * Menu 클래스 객체들을 저장한 리스트 menus에서 인덱스를 활용해 각 menu객체에 들어있는 카테고리명을 가져와 출력
             */
            System.out.println("[ MAIN MENU ]");
            this.menus.stream()
                    .map(menu -> String.format("%d. %s",
                            menus.indexOf(menu) + 1,
                            menu.getCategoryName()))
                    .forEach(System.out::println);

            /*for (int i = 0; i<categoryCount; i++) {
                System.out.printf("%d. %s%n",
                        i+1,
                        menus.get(i).getCategoryName());
            }*/
            System.out.println("0. 종료");

            /**
             * 주문 ( [ORDER MENU] ) 기능 활성화
             * 장바구니에 메뉴가 존재할 때만 사용 가능; hasMenuItemsInCart = true
             * 메뉴 카테고리 다음 번호부터 시작; categoryCount+1
             */
            if (hasMenuItemInCart) {
                System.out.println(""); //화면 구분을 위해 줄바꿈 수행
                System.out.println("[ ORDER MENU ]");
                System.out.printf("%d. Orders        | 장바구니를 확인 후 주문합니다.%n", (categoryCount+1));
                System.out.printf("%d. Cancel        | 진행중인 주문을 취소합니다.%n", (categoryCount+2));
            }

            selectCategoryNum = sc.nextInt();  // 카테고리를 선택
            sc.nextLine();
            System.out.println(""); // 화면 구분을 위해 줄바꿈 수행

            /**
             * 카테고리 선택에 맞는 동작 실행 (메뉴 선택, 주문 선택)
             * 1. 선택한 카테고리가 0이 아니고 유효범위 내에 있을 때
             *    1-1. 카테고리에 맞는 메뉴 목록 출력
             *    1-2. 메뉴 선택
             *          1) 메뉴 선택(유효범위 내) 시 해당하는 메뉴 출력 후 장바구니에 추가 할 지 선택
             *          2) 0 선택 시 카테고리 선택으로 이동 (continue 동작으로 반복문 처음 코드로 돌아감 )
             *          3) 유효범위 밖 선택 시 메세지 출력하고 예외 처리
             * 2. (Order 선택 & 장바구니에 메뉴가 있을 때) 장바구니에 들어있는 메뉴와 총 금액 확인
             *    2-1. 주문; 선택 시 할인 선택 후 최종주문
             *    2-2. 메뉴 삭제; 삭제할 메뉴명 입력하면 장바구니에 반영 됨
             *    2-3. 메뉴판; 메뉴판으로 돌아감
             * 3. (Cancle 선택 & 장바구니에 메뉴가 있을 때) 장바구니 초기화 후 카테고리 선택으로 돌아감
             * 4. 선택한 카테고리가 0일 때
             *    4-1. 반복문 빠져나가고 start 메서드 종료 후 프로그램 종료
             * 5. 그 외
             *    5-1. 예외처리 후 원인 안내
             */
            if ((selectCategoryNum != 0) && (selectCategoryNum <= categoryCount)) { // 카테고리 선택

                // 선택한 카테고리의 메뉴 목록 출력
                menus.get(selectCategoryNum-1).displayMenuItems();

                selectMenuItemNum = sc.nextInt();  // 메뉴 선택
                sc.nextLine();

                // 선택한 카테고리에 맞는 메뉴 리스트 저장
                menuItemsByCategory =  menus.get(selectCategoryNum-1).getMenuItems();
                // 리스트 menus에 저장된 카테고리에 맞는 메뉴의 개수 저장
                menuItemCount = menuItemsByCategory.size();

                /**
                 * 선택한 메뉴 출력
                 * 1. 메뉴 선택 시(유효범위 안)
                 *      1-1. 선택한 메뉴(이름, 가격, 설명) 안내
                 *      1-2. 장바구니에 추가 할 지 결정
                 *          switch문
                 *          case1 (장바구니 추가): hasMenuItemsInCart = true가 할당되면서 주문 기능 활성화
                 *          case2 (장바구니 추가 취소): 카테고리 선택 화면으로 돌아감
                 * 2. '0. 뒤로가기' 선택
                 *      2-1. 카테고리부터 다시 선택
                 * 3. 그 외 (유효범위 밖)
                 *      3-1. 예외처리 후 원인 안내
                 */
                if ((selectMenuItemNum != 0) && (selectMenuItemNum <= menuItemCount)) {  // 메뉴 선택
                    selectMenuItem = menuItemsByCategory.get(selectMenuItemNum -1);    // 리스트 인덱스가 0부터 시작하는 규칙에 맞춤

                    System.out.printf("선택한 메뉴:  %-18s | W %3.1f | %s%n",
                            selectMenuItem.getName(),
                            selectMenuItem.getPrice(),
                            selectMenuItem.getDescription());
                    System.out.println(""); // 화면 구분을 위해 줄바꿈 수행

                    System.out.printf("\"%-18s | W %3.1f | %s\"%n",
                            selectMenuItem.getName(),
                            selectMenuItem.getPrice(),
                            selectMenuItem.getDescription());
                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인          2. 취소");
                    addToCartChoice = sc.nextInt();
                    sc.nextLine();
                    System.out.println(""); // 화면 구분을 위해 줄바꿈 수행

                    /**
                     * 장바구니 추가 선택
                     * case1 : 장바구니 추가
                     * case2 : 장바구니 추가 취소
                     */
                    switch (addToCartChoice){
                        case 1:
                            cart.addToCart(selectMenuItem);
                            hasMenuItemInCart = true;
                            break;
                        case 2:
                            break;
                        default:
                            throw new IllegalArgumentException("유효하지 않는 번호입니다. 키오스크를 다시 실행해주세요");
                    }
                } else if(selectMenuItemNum == 0) {  // '0. 뒤로가기'
                    System.out.println(""); // 화면 구분을 위해 줄바꿈 수행
                    continue;
                } else {
                    throw new IllegalArgumentException("잘못된 접근입니다. 키오스크를 다시 실행해주세요");
                }
            } else if (hasMenuItemInCart && (selectCategoryNum == (categoryCount+1))){  // (Order 메뉴 활성화) 'Order (주문하기)'
                System.out.println("아래와 같이 주문하시겠습니까?");
                System.out.println("");

                System.out.println("[ Orders ]");
                cart.displayCart(); //장바구니 목록 출력 메서드

                totalPrice = cart.cartTotalPrice();

                System.out.println("[ Total ]");
                System.out.printf("W %.1f%n", totalPrice);  //장바구니 총 금액 반환 메서드
                System.out.println("");

                System.out.println("1. 주문         2. 메뉴 삭제         3. 메뉴판");
                orderChoice = sc.nextInt();
                sc.nextLine();
                System.out.println("");

                if (orderChoice == 1) { // '1. 주문'
                    System.out.println("할인 정보를 입력해주세요.");
                    DiscountType.displayDiscountInfo(); // 할인 정보 출력

                    discountTypeChoice = sc.nextInt();
                    sc.nextLine();
                    System.out.println("");

                    // 선택한 할인 유형 번호를 인덱스 취급해 해당 enum상수를 가져옴
                    DiscountType discountType = (DiscountType.values())[discountTypeChoice-1];
                    System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.%n", discountType.calculateDiscountPrice(totalPrice));
                    cart.cartClear();
                    break;
                } else if (orderChoice == 2) { // 2. 메뉴 삭제
                    System.out.println("삭제할 메뉴의 이름을 쉼표(,)로 구분하여 입력해주세요.");
                    removeMenuItem = sc.nextLine();
                    removeMenusItemList = new ArrayList<>(Arrays.asList(removeMenuItem.split(",\\s*")));  //정규표현식을 사용해 쉼표 뒤에 0개 이상의 공백이 오면 구분, clear()메서드를 사용하기 위해 가변크기 ArrayList 형태로 생성
                    cart.removeCartMenuItem(removeMenusItemList); // 장바구니 메뉴 삭제 메소드 호출

                    removeMenusItemList.clear(); // 리스트 요소 초기화

                    System.out.println(""); // 화면 구분을 위한 줄바꿈 수행

                    System.out.println("[ Cart ]");
                    /**
                     * 장바구니 비어있는지 확인
                     * 비어있으면 Order Menu 비활성화; hasMenuItemInCart = false
                     * 안 비어있으면 현재 장바구니에 들어있는 메뉴 보여줌
                     */
                    if (cart.getMenuItems().isEmpty()){
                        hasMenuItemInCart = false;
                        System.out.println("장바구니가 비었습니다.");
                    } else {
                        cart.displayCart();
                    }
                    System.out.println("메뉴가 삭제됐습니다. 메뉴판으로 돌아갑니다.");
                    System.out.println("");
                    continue;
                } else if (orderChoice == 3) { // '3. 메뉴판'
                    continue;
                } else {
                    throw new IllegalArgumentException("잘못된 접근입니다. 키오스크를 다시 실행해주세요");
                }
            } else if (hasMenuItemInCart && (selectCategoryNum == (categoryCount+2))) {  //(order메뉴 활성화) 'Cancle(주문취소)'
                cart.cartClear();
                hasMenuItemInCart = false;
                continue;
            } else if (selectCategoryNum == 0) {  // '0. 종료'
                break;
            } else {
                throw new IllegalArgumentException("잘못된 접근입니다. 키오스크를 다시 실행해주세요");
            }
        }
    }
}
