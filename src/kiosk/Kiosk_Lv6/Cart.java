package kiosk.Kiosk_Lv6;

import java.util.ArrayList;
import java.util.List;

// 장바구니 관리
public class Cart {
    //속성
    private List<MenuItem> menuItems; //선택된 메뉴 리스트

    //생성자
    public Cart(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    // 메서드

    /**
     * 장바구니 추가
     * 선택한 메뉴를 받아오면 menuItems에 추가
     * 추가되었다는 안내 메세지 출력
     * @param menuItem (선택된 메뉴)
     */
    public void addToCart(MenuItem menuItem) {
        this.menuItems.add(menuItem);
        System.out.println(menuItem.getName() + " 이 장바구니에 추가되었습니다. ");
        System.out.println(""); //화면 구분을 위한 공백 출력
    }

    /**
     * 장바구니 목록 출력
     * 장바구니에 담겨있는 (menuItems) 메뉴 리스트 인덱스 처음부터 순회해서 메뉴명, 가격, 설명 출력
     */
    public void displayCart() {
        for (int i = 0; i<this.menuItems.size(); i++) {
            System.out.printf("%-20s | W %3.1f | %s%n ",
                    this.menuItems.get(i).getName(),
                    this.menuItems.get(i).getPrice(),
                    this.menuItems.get(i).getDescription());
        }
        System.out.println(""); // 화면 구분
    }

    /**
     * 총 합 계산
     * 장바구니에 담긴 메뉴 가격들을 전부 계산 후 반환
     * @return totalPrice (장바구니 총 합)
     */
    public float menuTotalPrice() {
        float totalPrice = 0;

        for (int i = 0; i<this.menuItems.size(); i++) {
            totalPrice += this.menuItems.get(i).getPrice();
        }
        return totalPrice;
    }

    /**
     * 장바구니 초기화
     * 메뉴 리스트 비움(clear)
     */
    public void cartClear() {
        this.menuItems.clear();
    }
}
