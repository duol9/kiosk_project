package kiosk.Kiosk_Lv5;

import java.util.ArrayList;
import java.util.List;

// 메뉴 관리 및 키오스크 실행
public class Main {
    public static void main(String[] args) {

        List<Menu> menus =new ArrayList<>(); //카테고리 리스트

        List<MenuItem> burgerMenuItems = new ArrayList<>(); // 햄버거 메뉴 리스트
        Menu burgerMenu;  // 햄버거 메뉴

        List<MenuItem> drinkMenuItems = new ArrayList<>(); // 음료 메뉴 리스트
        Menu drinkMenu;   // 음료 메뉴

        List<MenuItem> dessertMenuItems = new ArrayList<>(); // 디저트 메뉴 리스트
        Menu dessertMenu; // 디저트 메뉴

        /**
         * 1. 헴버거
         * 햄버거 리스트에 햄버거 메뉴 정보 추가
         * 햄버거 카테고리에 햄버거 메뉴 저장
         * 카테고리 리스트에 햄버거 추가
         */
        burgerMenuItems.add(new MenuItem("ShackBurger", 6.9f, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenuItems.add(new MenuItem("SmokeShack", 8.9f, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerMenuItems.add(new MenuItem("Cheeseburger", 6.9f, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerMenuItems.add(new MenuItem("Hamburger", 5.4f, "비프패티를 기반으로 야채가 들어간 기본버거"));

        burgerMenu = new Menu("Burgers", burgerMenuItems);
        menus.add(burgerMenu);

        /**
         * 2. 음료
         * 음료 리스트에 음료 메뉴 정보 추가
         * 음료 카테고리에 음료 메뉴 저장
         * 카테고리 리스트에 음료 추가
         */
        drinkMenuItems.add(new MenuItem("Coke", 3.0f, "코카 콜라"));
        drinkMenuItems.add(new MenuItem("CokeZero", 3.5f, "코카 콜라 제로"));
        drinkMenuItems.add(new MenuItem("Sprite", 3.0f, "스프라이트"));
        drinkMenuItems.add(new MenuItem("fanta (Orange)", 3.0f, "오렌지맛 환타"));
        drinkMenuItems.add(new MenuItem("fanta (Grape)", 3.0f, "포도맛 환타"));

        drinkMenu = new Menu("Drinks", drinkMenuItems);
        menus.add(drinkMenu);

        /**
         * 3. 디저트
         * 디저트 리스트에 디저트 메뉴 정보 추가
         * 디저트 카테고리에 디저트 메뉴 저장
         * 카테고리 리스트에 디저트 추가
         */
        dessertMenuItems.add(new MenuItem("French Fries", 4.0f, "짭짤한 감자 튀김"));
        dessertMenuItems.add(new MenuItem("Sweet Potato Fries", 4.0f, "달달한 고구마 튀김"));
        dessertMenuItems.add(new MenuItem("Fried Calamari", 4.0f, "오징어 튀김"));

        dessertMenu = new Menu("Desserts", dessertMenuItems);
        menus.add(dessertMenu);


        // 카테고리 목록들과 메뉴 정보가 담긴 리스트를 저장한 Kiosk 객체 생성
        Kiosk kiosk = new Kiosk(menus); // kiosk 객체를 생성하고 메뉴 목록 리스트 넘김

        // 키오스크 실행
        kiosk.start();
    }
}
