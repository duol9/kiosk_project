package kiosk.Kiosk_Lv2;

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
    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
