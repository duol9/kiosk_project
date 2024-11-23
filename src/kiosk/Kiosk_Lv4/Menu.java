package kiosk.Kiosk_Lv4;

import java.util.List;

// MenuItem 클레스를 관리
public class Menu {
    //속성
    private List<String> categoryNames; //카테고리 이름을 관리하는 리스트
    private List<MenuItem> menuItems; //메뉴를 관리하는 리스트

    //생성자
    public Menu (List<String> categoryName, List<MenuItem> menuItems) {
        this.categoryNames = categoryName;
        this.menuItems = menuItems;
    }
    //기능
    /**
     * List에 들어있는 Category를 순차적으로 보여주는 메서드
     */
    public void displayMenuCategory() {
    }

    /**
     * List에 들어있는 MenuItem을 순차적으로 보여주는 메서드
     */
    public void displayMenuItems() {
    }

    /**
     * 메뉴 카테고리 이름을 외부로 반환
     */
    public List<String> getCategoryName() {
        return this.categoryNames;
    }
}
