package kiosk.Kiosk_Lv4;

import java.util.List;
import java.util.Scanner;

//사용자 입력 처리, 키오스크 메뉴 관리
public class Kiosk {
    //속성
    private List<Menu> menus; // MenuItem울 관리하는 리스트, 객체가 새로 생겨도 정보는 고정되어야 하니까 static

    //생성자
    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    //메서드

    /**
     * 메뉴를 보고 사용자가 직접 선택할 수 있는 키오스크를 실행시키는 메서드
     */
    public void start() {
        while(true) {
            List<MenuItem> menuItemsByCategory; // 카테고리에 맞는 메뉴 목록
            MenuItem selectMenuItem;  //선택한 메뉴 정보 저장

            int selectMenuNum; // 사용자가 선택한 메뉴 번호
            int menuCount; // 메뉴의 개수

            int selectCategoryNum; // 카테고리 선택
            int categoryCount = menus.size(); // 카테고리 개수

            Scanner sc = new Scanner(System.in);


            /**
             * 카테고리 출력
             * Menu 클래스 객체들을 저장한 리스트 menus에서 인덱스를 활용해 각 menu객체에 들어있는 카테고리명을 가져와 출력
             */
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i<categoryCount; i++) {
                System.out.printf("%d. %s%n",
                        i+1,
                        menus.get(i).getCategoryName());
            }
            System.out.println("0. 종료");

            selectCategoryNum = sc.nextInt();  // 카테고리를 선택
            sc.nextLine();
            System.out.println(""); // 화면 구분을 위해 줄바꿈 수행

            /**
             * 카테고리 선택에 맞는 메뉴 목록 출력 및 메뉴 선택
             * 1. 선택한 카테고리가 0이 아니고 유효범위 내에 있을 때
             *    1-1. 카테고리에 맞는 메뉴 목록 출력
             *    1-2. 메뉴 선택
             *    1-3. 선택한 메뉴 출력
             *         1) 유효범위 내 번호 선택 시 해당하는 메뉴 출력
             *         2) 0 선택 시 카테고리 선택으로 이동 (continue 동작으로 반복문 처음 코드로 돌아감 )
             *         3) 유효범위 밖 선택 시 메세지 출력하고 예외 처리
             * 2. 선택한 카테고리가 0일 때
             *    2-1. 반복문 빠져나가고 start 메서드 종료 후 프로그램 종료
             * 3. 선택한 카테고리가 유효범위 밖일 때
             *    3-1. 메시지 출력하고 예외 처리
             */
            if ((selectCategoryNum != 0) && (selectCategoryNum <= categoryCount)) {

                // 선택한 카테고리의 메뉴 목록 출력
                menus.get(selectCategoryNum-1).displayMenuItems();

                selectMenuNum = sc.nextInt();  // 메뉴를 선택
                sc.nextLine();

                // 선택한 카테고리에 맞는 메뉴 리스트 저장
                menuItemsByCategory =  menus.get(selectCategoryNum-1).getMenuItems();
                // 리스트 menus에 저장된 카테고리에 맞는 메뉴의 개수 저장
                menuCount = menuItemsByCategory.size();

                /**
                 * 선택한 메뉴 출력
                 * 선택한 번호(selctMenu)가 0이 아니고 메뉴 갯수(menuCount) 범위 안에 해당하면 선택한 메뉴 출력
                 * 0이라면 반복문을 다시 실행해 카테고리 선택 돌아감
                 * 유효 범위( menuCount보다 큰 숫자 )를 벗어난 번호를 선택하면 예외처리
                 */
                if ((selectMenuNum != 0) && (selectMenuNum <= menuCount)) {
                    selectMenuItem = menuItemsByCategory.get(selectMenuNum -1);    // 리스트 인덱스가 0부터 시작하는 규칙에 맞춤
                    System.out.printf("선택한 메뉴:  %-12s | W %3.1f | %s%n",
                            selectMenuItem.getName(), // 왼쪽 정렬하고 메뉴명 출력
                            selectMenuItem.getPrice(), // 오른쪽 정렬하고 가격 출력
                            selectMenuItem.getDescription()); // 설명 출력
                    System.out.println(""); // 화면 구분을 위해 줄바꿈 수행
                } else if(selectMenuNum == 0) {
                    System.out.println(""); // 화면 구분을 위해 줄바꿈 수행
                    continue;
                } else if (selectMenuNum > menuCount){
                    throw new IllegalArgumentException("잘못된 접근입니다. 키오스크를 다시 실행해주세요");
                }

            } else if (selectCategoryNum == 0) {
                break;
            } else if (selectCategoryNum > categoryCount){
                throw new IllegalArgumentException("잘못된 접근입니다. 키오스크를 다시 실행해주세요");
            }
        }
    }
}
