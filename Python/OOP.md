#  OOP
## 객체 지향 프로그래밍이란?
Object-Oriented Programming <-> 절차지향 프로그래밍
코드의 재사용이 가능하고 프로그램의 유지보수가 쉽다.
## OOP 기초
- 클래스 : 객체들의 분류
- 인스턴스 : 하나하나의 실체
- 객체는 특정 타입의 인스턴스
  - type : 어떤 연산자와 조작이 가능한가?
  - 속성 : 어떤 데이터를 가지는가?
  - method : 어떤 함수를 할 수 있는가?
- 기본 문법
  - 클래스 정의 :  `class MyClass:` 클래스의 이름은 일반적으로 대문자
    - naming : snake_case, PascalCase, camelCase
  - 인스턴스 생성 : `my_instance = MyClass()`
  - 메서드 호출 : `my_instance.my_method()`
  - 속성 : `my_instance.my_attribute`
 - 객체 비교하기
  - == : 값을 비교
  - is : 같은 메모리인가를 비교
 ## OOP 속성
 ### 속성
 - 특정 데이터 클래스의 객체들이 가지게 될 상태/데이터
 - 클래스 변수/ 인스턴스 변수 가 존재
    - 인스턴스 변수 : `__init__`에서 self.\<name\>으로 정의, 인스턴스가 생성된 후 \<instance\>.\<name\>
    - 클래스 변수 : 한 클래스의 모든 인스턴스가 공유하는 값을 의미, 같은 클래스의 인스턴스들은 같은 값을 갖는다.
      - 클래스 선언 내부에서 정의
      - \<Class.name\>.\<name\>으로 접근 및 할당
## OOP 메서드
특정 클래스의 객체에 공통적으로 적용 가능한 함
### 인스턴스 메서드
- self parameter 필수
### 클래스 메서드
- cls를 parameter로 필요
- decorator @ 필요 (함수를 꾸며주는 기능을 하는 함수, parameter로 함수를 가진다.)
### 정적 메서드
- self or cls parameter 불필요
- decorator 필요
- 속성을 다루지 않고, 단지 기능만을 하는 메서드를 정의할 때 사용
### __init__ : 생성자 메서드
### 매직 메서드
- __str__(self) : 출력시 클래스를 문자열처럼 취급하고 싶을때 사용, return값이 출력
- __len__(self), __gt__(self) 등
### __del__ : 소멸자 메서드
  
## 객체지향의 핵심 개념
### 추상화
### 상속
### 다형성
- 메서드 오버라이딩
- 같은 기능도 클래스마다 다르게 사용이 가능
### 캡슐화
- 객체의 일부 구현 내용에 대해 외부로부터의 직접적인 액세스를 차단
- 접근 제어자

