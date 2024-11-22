package kiosk.Kiosk_Lv3;

import java.util.ArrayList;
import java.util.List;

//사용자 입력 처리, 키오스크 메뉴 관리
public class Kiosk {
    //속성
    private List<MenuItem> menuItems = new ArrayList<>(); // MenuItem울 관리하는 리스트
    //생성자
    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    //메서드
    //메뉴 입력,
    public void start() {

    }

}
