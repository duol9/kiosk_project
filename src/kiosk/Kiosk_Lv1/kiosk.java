package kiosk.Kiosk_Lv1;

import java.util.Scanner;

// Lv.1 의 요구사항
// Scanner, 조건문, 반복문을 활용해서 데이터를 처리해봐라!
public class kiosk {
    public static void main(String[] args) {

        int menuNum;  // 메뉴번호를 담는 변수
        // Scanner 생성
        Scanner sc = new Scanner(System.in);

        //  do - while문으로 반복문 활용
        do {
            System.out.println("[ SHAKESHACK MENU }");
            System.out.println("1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
            System.out.println("2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거 ");
            System.out.println("3. CheeseBurger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
            System.out.println("4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
            System.out.println("0. 종료          | 종료");
            menuNum = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

        }  while (menuNum != 0);

    }
}
