package kiosk.Kiosk_Lv4;

import java.util.List;
import java.util.Scanner;

//사용자 입력 처리, 키오스크 메뉴 관리
public class Kiosk {
    //속성
    private List<MenuItem> menuItems; // MenuItem울 관리하는 리스트, 객체가 새로 생겨도 정보는 고정되어야 하니까 static

    //생성자
    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    //메서드

    /**
     * 메뉴를 보고 사용자가 직접 선택할 수 있는 키오스크를 실행시키는 메서드
     */
    public void start() {
        while(true) {

            int selectNum;   // 사용자가 선택한 메뉴 번호
            int menuCount; // 메뉴의 개수
            MenuItem selectMenuItem;  //선택한 메뉴 정보 저장

            Scanner sc = new Scanner(System.in);

            menuCount = menuItems.size(); // meuuItems에 담긴 메뉴 개수 저장

            /**
             * 전체 메뉴 출력
             * 메뉴가 전부 출력되기 위해 menuCount 만큼 반복할 수 있도록 설정
             * i번째 인덱스에 있는 메뉴 정보들을 출력
             * 글자수에 구애받지 않고 동일한 포맷으로 출력할 수 있도록 정렬 수행
             * System.out.println("0. 종료"); 까지 한 세트
             */
            System.out.println("[ BURGERS MENU ]");
            for(int i=0; i<menuCount; i++) {
                MenuItem menuItem = menuItems.get(i);
                System.out.printf("%-2d. %-12s | W %3.1f | %s%n",
                        i+1, // 왼쪽 정렬하고 번호 출력
                        menuItem.getName(), // 왼쪽 정렬하고 메뉴명 출력
                        menuItem.getPrice(), // 오른쪽 정렬하고 가격 출력
                        menuItem.getDescription()); // 설명 출력
            }
            System.out.println("0. 종료");

            selectNum = sc.nextInt();  // 메뉴를 선택
            sc.nextLine();

            /**
             * 조건에 맞는(선택한) 메뉴 출력
             * 선택한 번호(selectNum)가 0이 아니고 메뉴 갯수(menuCount) 범위 안에 해당하면 선택한 메뉴 출력
             * 0이라면 반복문을 빠져나와 start 메서드 종료 후 MAIN MENU 화면으로 돌아감
             * 유효 범위( menuCount보다 큰 숫자 )를 벗어난 번호를 선택하면 예외처리
             */
            if ((selectNum != 0) && (selectNum <= menuCount)) {
                selectMenuItem = menuItems.get(selectNum-1);    // 리스트 인덱스가 0부터 시작하는 규칙에 맞춤
                System.out.printf("선택한 메뉴:  %-12s | W %3.1f | %s%n",
                        selectMenuItem.getName(), // 왼쪽 정렬하고 메뉴명 출력
                        selectMenuItem.getPrice(), // 오른쪽 정렬하고 가격 출력
                        selectMenuItem.getDescription()); // 설명 출력
                System.out.println("");
            } else if(selectNum == 0) {
                break;
            } else if (selectNum > menuCount){
                throw new IllegalArgumentException("잘못된 접근입니다. 키오스크를 다시 실행해주세요");
            }
        }
    }
}
