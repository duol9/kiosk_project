# Java 키오스크 프로젝트 (Lv.7)
Java로 구현된 객체지향설계가 적용된 키오스크 프로그램입니다.<br>
사용자가 카테고리와 메뉴를 선택하면 해당 메뉴의 `이름`,`가격`,`설명`이 출력됩니다.<br>
장바구니에 메뉴를 담으면 주문이 가능합니다.

## 요구사항
**1. Enum을 활용한 사용자 유형별 할인율 관리하기**
- [x]  사용자 유형의 `Enum` 정의 및 각 사용자 유형에 따른 할인율 적용
  - 예시 : 군인, 학생, 일반인
- [x]  주문 시, 사용자 유형에 맞는 할인율 적용해 총 금액 계산

**2. 람다 & 스트림을 활용한 장바구니 조회 기능**
- [x]  기존에 생성한 `Menu`의 `MenuItem`을 조회 할 때 스트림을 사용하여 출력하도록 수정
- [x]  기존 장바구니에서 특정 메뉴 빼기 기능을 통한 스트림 활용
  - 예시 : 장바구니에 `SmokeShack` 가 들어 있다면, `stream.filter`를 활용하여 특정 메뉴 이름을 가진 메뉴 장바구니에서 제거
 
## 개발환경
- Java 17
- intellij IDEA

## 주요기능
- 카테고리 목록 출력
- 메뉴 목록 출력
- 사용자 입력을 통한 메뉴 선택 기능
- 선택한 메뉴 정보 출력
- 장바구니에 메뉴 추가
- 총 금액 출력
- 주문하기
- 프로그램 종료

## 사용 방법
1. 프로그램 실행
2. 화면에 출력된 `카테고리` 중 원하는 번호를 입력
3. 화면에 출력된 `메뉴` 중 원하는 번호를 입력
4. 입력한 메뉴의 정보(`이름`, `가격`, `설명`) 확인
5. 장바구니에 추가할 지 결정
6. (장바구니 추가 시) 주문 또는 삭제 결정
7. 할인 타입 선택
8. '0'을 입력하기 전까지 반복 실행<br>
![image](https://github.com/user-attachments/assets/89fc6544-861d-4dc2-9ef5-1c21b802d809)
![image](https://github.com/user-attachments/assets/dc2b0977-6057-45a0-8e96-63c0a9a28e65)


## 프로젝트 구조
### Main 클래스
- `MenuItem` 객체 생성 (메뉴 추가)
- `MenuItem` 리스트 생성 (메뉴 항목 관리)
- `Menu`객체 생성 (카테고리 추가)
- `Menu` 리스트 생성 (카테고리 항목 관리)
- `Kiosk` 객체 생성 및 start() 메서드 호출
### Kiosk 클래스
키오스크 실행 핵심 클래스
- 속성
  - `menus`: `Menu` 객체들을 저장하는 `List<Menu>`
  - `cart`: 장바구니 객체
- 생성자
- 메서드(기능)
  - `start()`:
      - 키오스크 실행
      - 카테고리,메뉴 출력 및 선택
      - 장바구니 기능
      - 주문 카테고리 활성화 (장바구니 사용 시)
      - 최종 주문 결정
      - 할인 타입 선택 
      - 프로그램 종료
### Cart 클래스
장바구니 기능을 관리하는 클래스
- 속성
  - `menuItems`: 선택된 메뉴 항목들을 저장하는 `List<MenuItem>`
- 메서드(기능)
  - `addToCart(MenuItem menuItem)`: 장바구니에 메뉴(`menuItem`) 추가
  - `displayCart()`: 장바구니 내용 출력
  - `menuTotalPrice()`: 장바구니 내 메뉴 총 가격 계산
  - `cartClear()`: 장바구니 초기화
  - `getMenuItems()`: 장바구니 내 메뉴 항목 리스트 반환
### Menu 클래스
메뉴 카테고리를 관리하는 클래스
- 속성
  - `categoryName`: 카테고리 이름
  - `menuItems`: `MenuItem` 객체들을 저장하는 `List<MenuItem>`
- 메서드(기능)
  - `displayMenuItems()`: 카테고리 내 메뉴 항목 출력
  - `getCategoryName()`: 카테고리 이름 반환
  - `getMenuItems()`: 메뉴 항목 리스트 반환
  - `removeCartMenuItem (List<String> removeMenuItems)`: `List<String>`에 존재하는 메뉴 삭제
### MenuItem 클래스 ###
메뉴 정보를 관리하는 클래스
- 속성
  - `name`: 메뉴 이름
  - `price`: 메뉴 가격
  - `description`: 메뉴 설명
- 생성자
- 메서드(기능)
  - getter
    - `getName()`: 메뉴 이름 반환
    - `getPrice()`: 메뉴 가격 반환
    - `getDescripton()`: 메뉴 설명 반환
### DiscountType Enum 
사용자 유형별 할인율 관리
- Enum 상수
  - `NATIONAL_HERO`: 국가유공자 (10% 할인)
  - `SOLDIER`: 군인 (5% 할인)
  - `STUDENT`: 학생 (3% 할인)
  - `GENERAL`: 일반 (할인 없음)
- 속성
  - `guestType`: 고객 유형 이름
  - `discountRate`: 할인율
- 메서드(기능)
  - `getGuestType()`: 사용자 유형 반환
  - `getDiscountRate()`: 할인율 반환
  - `displayDiscountInfo()`: 모든 할인 유형과 할인율 정보 출력
  - `calculateDiscountPrice(float originalPrice)`: 할인이 적용된 가격 계산 및 반환
<br>

## Lv.6과의 차이점
- 반복문을 사용한 `메뉴 목록 출력`,`카테고리 목록 출력`, `장바구니 메뉴 삭제`, `총 금액 계산`을 `람다&스트림`을 사용해 동작하도록 변경
- `Enum`을 활용해 사용자 유형별 할인율 관리
