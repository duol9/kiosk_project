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
     * for문에서 categoryNames.get(i)으로 하나씩 카테고리명을 읽은 후 출력
     */
    public void displayMenuCategory() {

        int categoryCount;
        categoryCount = categoryNames.size();

        for (int i = 0; i<categoryCount; i++){
            String categoryName = categoryNames.get(i);
            System.out.printf("%-2d. %s%n",
                    i+1, //번호 출력
                    categoryName); //카테고리명 출력
        }
        System.out.println("0. 종료");
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
