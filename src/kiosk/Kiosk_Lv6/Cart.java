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
     * @param menuItem (선택된 메뉴)
     */
    public void addToCart(MenuItem menuItem) {

    }

    /**
     * 장바구니 목록 출력
     * 장바구니에 담겨있는 (menuItems) 메뉴들 전부 사용자에게 보여줌
     */
    public void displayCart() {

    }

    /**
     * 총 합 계산
     * 장바구니에 담긴 메뉴 가격들을 전부 계산 후 반환
     * @return totalPrice (장바구니 총 합)
     */
    public float menuTotalPrice() {
        float totalPrice;

        return totalPrice;
    }
}
