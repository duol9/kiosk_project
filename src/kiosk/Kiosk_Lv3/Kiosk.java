package kiosk.Kiosk_Lv3;

import java.util.ArrayList;
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

            int menuNum;   // 사용자가 선택한 메뉴 번호
            MenuItem menuSelect;  //선택한 메뉴 정보를 받을 MenuItem 객체

            Scanner sc = new Scanner(System.in);

            /**
             * 전체 메뉴 출력
             * 메뉴가 전부 출력되기 위해 menuItem.size()만큼 반복할 수 있도록 설정
             * i번째 인덱스에 있는 메뉴 정보들을 출력
             * 글자수에 구애받지 않고 동일한 포맷으로 출력할 수 있도록 정렬 수행
             * System.out.println("0. 종료"); 까지 한 세트
             */
            for(int i=0; i<menuItems.size(); i++) {
                MenuItem menuItem = menuItems.get(i);
                System.out.printf("%-2d. %-12s | W %3.1f | %s%n",
                        i+1, // 왼쪽 정렬하고 번호 출력
                        menuItem.getName(), // 왼쪽 정렬하고 메뉴명 출력
                        menuItem.getPrice(), // 오른쪽 정렬하고 가격 출력
                        menuItem.getDescription()); // 설명 출력
            }
            System.out.println("0. 종료");
        }
    }
}
