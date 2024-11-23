package kiosk.Kiosk_Lv4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int selectNum;
        List<MenuItem> menuItems = new ArrayList<>(); // 메뉴(객체)를 담을 리스트 선언

        Scanner sc = new Scanner(System.in);

        // 객체(메뉴)를 생성하고 List에 추가
        menuItems.add(new MenuItem("ShackBurger", 6.9f, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9f, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9f, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4f, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Kiosk kiosk = new Kiosk(menuItems); // kiosk 객체를 생성하고 메뉴 목록 리스트 넘김

        /**
         * 메뉴 카테고리를 무한으로 고를 수 있는 반복문
         * 1번을 누르면 햄버거 키오스크 실행
         * 0번을 누르면 반복문 벗어난 후 프로그램 종료
         */
        while (true){
            System.out.println("[ MAIN MENU ] ");
            System.out.println("1. Burgers");
            System.out.println("0. 종료 ");

            selectNum = sc.nextInt();
            sc.nextLine();
            System.out.println(""); // 다음 화면과 분리하기 위해 한 줄 띄움

            if (selectNum == 1) {
                kiosk.start();
            } else if (selectNum == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}
