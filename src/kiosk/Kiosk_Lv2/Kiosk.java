package kiosk.Kiosk_Lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    public static void main(String[] args) {
        int menuNum; // 메뉴 번호를 담는 변수

        List<MenuItem> menuItems = new ArrayList<>(); // 메뉴(객체)를 담을 리스트 선언

        Scanner sc = new Scanner(System.in); // 스캐너 선언

        // 객체(메뉴)를 생성하고 List에 추가
        menuItems.add(new MenuItem("ShackBurger", 6.9f, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9f, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9f, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4f, "비프패티를 기반으로 야채가 들어간 기본버거"));

        while(true){

             System.out.println("[ SHAKESHACK MENU ]");

            /**
             * 메뉴판 출력
             * i번째 인덱스에 있는 내용을 Menuitem타입으로 복사해 출력한다.
             */

            for(int i=0; i<menuItems.size(); i++) {
                 MenuItem menuItem = menuItems.get(i); // i번째 인덱스에 있는 내용을 Menuitem타입으로 복사한다
                 System.out.printf("%-2d. %-12s | W %3.1f | %s%n",
                         i+1, // 왼쪽 정렬하고 번호 출력
                         menuItem.getName(), // 왼쪽 정렬하고 메뉴명 출력
                         menuItem.getPrice(), // 오른쪽 정렬하고 가격 출력
                         menuItem.getDescription()); // 설명 출력
             }

             System.out.println("0. 종료");
             menuNum = sc.nextInt();  // 메뉴를 선택한다.
             sc.nextLine();

             MenuItem menuSelect;

            /**
             * munuNum이 0이 아니면 해당하는 메뉴 출력
             * 0이라면 반복문을 빠져나와 프로그램 종료
             */
            if (menuNum != 0) {
                 menuSelect = menuItems.get(menuNum-1);
                 System.out.printf("선택한 메뉴:  %-12s | W %3.1f | %s%n",
                         menuSelect.getName(), // 왼쪽 정렬하고 메뉴명 출력
                         menuSelect.getPrice(), // 오른쪽 정렬하고 가격 출력
                         menuSelect.getDescription()); // 설명 출력
                 System.out.println("");
             } else if(menuNum == 0) break;

        }

    }
}
