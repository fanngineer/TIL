# 객체(Object)
- 객체는 문자열로 이름을 붙인 값들의 집합체 (Key : Value)
- Key는 문자열, Value는 아무값
- 객체에 저장하는 값을 프로퍼티(Property)
- 객체는 prototype 이라는 특별한 프로퍼티를 가지고 있다.

## 객체 생성
- 객체 리터럴 : {}
- Object 생성자 : new Object{}
- 생성자 함수

## 객체 프로퍼티
- .또는 []를 이용하여 프로퍼티의 조회 및 변경 처리
- delete object.id 를 통해서 삭제 가능
- 객체 변수에는 주소가 저장된다 >> 참조형 자료
- 함수안에서의 this는 함수를 호출한 객체
- JSON(JavaScript Object Notation)
  - 자바스크립트를 토대로 개발
  - 여러 프로그래밍 언어에서 사용할 수 있는 독립형 언어
  - 웹 클라이언트와 서버 간 데이터 교환에 사용
  - 언어와 플랫폼에 독립적이므로, 서로 다른 시스템간에 데이터 교환에 좋다.
  - JSON은 Key, Value쌍으로 표현 : key는 ""로 묶어서 표현
- JSON 내장 메서드
  - JSON.parse() : JSON 문자열 >> 자바스크립트 객체
  - JSON.stringify() : 자바스크립트 객체 >> JSON 문자열
