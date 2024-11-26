package kiosk.Kiosk_Lv7;

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
     * 카테고리(List<MenuItem>)에 들어있는 MenuItem을 순차적으로 보여주는 메서드
     * stream()을 사용해 List<MenuItem> menuItems에 들어있는 menuItem 객체들을 스트림으로 생성
     * 중간연산으로 map()을 사용해 menuItem의 원하는 요소들(순서, 메뉴명, 가격, 설명)을 뽑아 원하는 형식의 문자열로 바꿈
     * 최종연산으로 형식화된 문자열을 출력
     * this.menuItems.indexOf(menuItem) + 1 : menuItem이 menuItems의 몇 번째 인덱스인지 반환, 인덱스는 0부터 시작해 사용자가 보는 번호에 맞춰 +1 함
     * System.out.println("0. 종료"); 까지 한 세트
     */
    public void displayMenuItems() {

        System.out.println("[ " + getCategoryName().toUpperCase() + " MENU ] ");

        this.menuItems.stream().map(menuItem -> String.format("%d. %-18s | W %3.1f | %s",
                this.menuItems.indexOf(menuItem) + 1,
                menuItem.getName(),
                menuItem.getPrice(),
                menuItem.getDescription()))
                .forEach(System.out::println);
        System.out.println("0. 뒤로가기");
    }


    // 메뉴 카테고리 이름을 외부로 반환
    public String getCategoryName() {
        return this.categoryName;
    }

    // 메뉴 목록 외부로 반환
    public List<MenuItem> getMenuItems() {
        return this.menuItems;
    }
}
