package kiosk.Kiosk_Lv4;

import java.util.List;

// MenuItem 클레스를 관리
public class Menu {
    //속성
    private String categoryName; //카테고리 이름
    private List<MenuItem> menuItems; //메뉴를 관리하는 리스트

    //생성자
    public Menu (String categoryName, List<MenuItem> menuItems) {
        this.categoryName = categoryName;
        this.menuItems = menuItems;
    }
    //기능
    /**
     * List에 들어있는 MenuItem을 순차적으로 보여주는 메서드
     * for문에서 menuItems.get(i)으로 하나씩 메뉴를 읽은 후 출력
     */
    public void displayMenuItems() {
        int menuCount; // 메뉴의 개수
        menuCount = menuItems.size(); // meuuItems에 담긴 메뉴 개수 저장

        for(int i=0; i<menuCount; i++) {
            MenuItem menuItem = menuItems.get(i);
            System.out.printf("%-2d. %-12s | W %3.1f | %s%n",
                    i+1, // 왼쪽 정렬하고 번호 출력
                    menuItem.getName(), // 왼쪽 정렬하고 메뉴명 출력
                    menuItem.getPrice(), // 오른쪽 정렬하고 가격 출력
                    menuItem.getDescription()); // 설명 출력
        }
        System.out.println("0. 종료");
    }

    /**
     * 메뉴 카테고리 이름을 외부로 반환
     */
    public String getCategoryName() {
        return this.categoryName;
    }
}
