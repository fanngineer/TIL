# 파이썬 기초
## 기본 개념
### 예약어
특정 기능을 수행하도록 미리 예약되어 있는 단어.  
변수나 메소드 이름 등 다른 식별자로 사용할 수 없다.
- as : 모듈 이름 다음 as 가 오면, as 다음의 이름을 임포트한 모듈에 직접 연결한다.
- assert : 프로그램에 디버깅 어서션을 삽입
- continue : 조건이 참이면 반복문을 계속
- del : 인덱스를 사용하여 항목을 삭제
- except, finally : 오류에 대한 예외 처리 관련 예약어
- is : 두 값의 참조(레퍼런스, 포인터)를 비교하는 연산자
- lambda : 익명 함수 만드는 연산자
- pass : 조건문을 실행하지 않고 다음 명령을 실행

### 부동 소수점
사람은 10진수를 사용하고, 컴퓨터는 2진수를 통해서 근사하게 나타내기때문에 오차가 발생한다  
`decimal.Decimal`, `math.fsum()`, `round()`, `float.as_integer_ratio()`, `math.is_close()` 등으로 해결

### Boolean형
- 논리 자료형으로 참과 거짓을 표현하는 자료형
- True or False 값을 가짐
- 비교/논리 연산에 활용
- Falsy : 0, 0.0, (), [], {}, None, ""
- 논리 연산자 우선 순위 : not> and> or
- 단축 평가

## 실습 기능
### 기능
- '''으로 감싸면 주석여러줄 입력이 가능
- x, y = x, y를 통해서 변수 값을 바꾸는것이 가능
- 진수 표현:
2진수 : 0b
8진수 : 0o
16진수 : 0x
- '''을 사용하면 '과 "와 enter까지 입력 가능
- string interpolation
print('Hello, %s' %name) # name = 'Kim'
print('Hello, {}! 성적은 {}'.format(name,score))
**print(f'Hello, {name}! 성적은 {Score}')**

### 기초 함수 정리
- append()  
list.append()로 사용, 리스트 형태의 Data 마지막에 하나를 추가하는 함수
- extend()  
list.append()로 사용, 리스트 마지막에 iterable의 모든 항목을 추가  
추가되는 요소가 자료형일때 사용 
ex) [1,2,3]에 [4,5]를 추가해서 [1,2,3,4,5]
- insert()  
list.append(위치, 값)으로 사용, 리스트 Data의 원하는 위치에 원하는 값을 추가하는 함수  
**위치를 index값으로 입력**
