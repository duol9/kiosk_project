package kiosk.Kiosk_Lv7;

public enum DiscountType {
    // enum 상수
    NATIONAL_HERO("국가유공자", 0.10f),
    SOLDIER("군인", 0.05f),
    STUDENT("학생", 0.03f),
    GENERAL("일반", 0.00f);

    // enum 속성
    private final String guestType;
    private final float discountRate;

    // enum 상수 호출 시 자동으로 초기화됨
    DiscountType(String guestType, float discountRate) {
        this.guestType = guestType;
        this.discountRate = discountRate;
    }

    public String getGuestType() {
        return this.guestType;
    }

    public float getDiscountRate() {
        return this.discountRate;
    }

    /**
     * 할인 정보 출력하는 메서드
     * Enum 상수를 하나씩 가져와 사용자에게 손님 유형과 할인율을 정보를 제공
     * enum.values() : enum상수를 리스트 형태로 접근 가능하게 함
     */
    public static void displayDiscountInfo () {
        int i = 1;
        for (DiscountType type : DiscountType.values()) {
            System.out.printf("%d. %-5s : %.0f%%%n",
                    i++,
                    type.getGuestType(),
                    type.getDiscountRate() * 100);
        }
    }

    /**
     * 할인 적용된 금액 반환하는 메서드
     * @param originalPrice (원래가격)
     * @return 할인된 가격
     */
    public float calculateDiscountPrice(float originalPrice) {
        return originalPrice * (1 - discountRate);
    }
}
