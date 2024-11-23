package kiosk.Kiosk_Lv3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<MenuItem> menuItems = new ArrayList<>(); // 메뉴(객체)를 담을 리스트 선언

        // 객체(메뉴)를 생성하고 List에 추가
        menuItems.add(new MenuItem("ShackBurger", 6.9f, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9f, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9f, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4f, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Kiosk kiosk = new Kiosk(menuItems); // kiosk 객체를 생성하고 메뉴 목록 리스트 넘김
        kiosk.start();

    }
}
