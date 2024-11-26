package kiosk.Kiosk_Lv6;

// 음식 항목 관리
public class MenuItem {
    // 속성
    private String name;         //이름
    private float price;        // 기격
    private String description;  // 설명

    // 생성자
    public MenuItem(String name, float price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // 기능

    /**
     * @return
     * this키워드로 반환하는 것이 무엇인지 명확하게 가리킴
     */
    public String getName() {

        return this.name;
    }

    public float getPrice() {

        return this.price;
    }

    public String getDescription() {

        return this.description;
    }
}
