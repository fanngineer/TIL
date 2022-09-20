## Http Protocal 특징
- 비연결(connectionless) 지향형 통신 프로토콜
- 응답 후 연결을 종료(stateless)
  - 서버가 응답 후, 클라이언트 정보를 기억하지 못한다.
    - 페이지가 바뀌면 정보가 없어지는 등의 문제를 해결하기 위해서 Cookie와 HttpSession을 활용한다.
  - 지속적인 연결 유지로 자원낭비 방지를 위해 연결해제
## Cookie & HttpSession
### Cookie : javax.servlet.http.Cookie
- 서버가 생성하는 클라이언트 정보를 가지고 있는 파일
- 클라이언트 컴퓨터에 저장되며, 필요에 따라 요청 시 서버로 같이 전송
- key-value 형태로 구성되며 문자열 데이터
- 브라우저(클라이언트) 별로 별도의 쿠키가 생성 ( 브라우저가 다르면 다른 사용자로 처리)
- 세션관리(사용자 아이디, 접속시간, 장바구니 등)를 위해 사용
- 사용자마다 다른 페이지를 보여줄 수 있다.
- 사용자의 행동과 패턴을 분석하고 기록하는데 사용된다. (알고리즘 광고 배너 등)

### Cookie 동작순서
- Client가 요청 생성
- WAS는 Cookie를 생성하고 Http Header에 Cookie를 넣어 응답
- Client(Browser)는 Cookie를 저장, 해당 서버에 요청할 때 요청과 함께 Cookie를 전송
- Cookie는 브라우저가 종료되더라도 계속 저장되기 때문에(만료 기간 전까지) 동일 사이트에 재 방문하여 요청 시 필요에 따라 Cookie가 재전송

### Cookie 특징
- 이름(key),값(value), 만료일(Expire date,저장기간) , 경로정보 로 구성된다.
- 클라이언트에 최대 300개의 쿠키를 저장할 수 있다.
- 하나의 도메인당 20개의 쿠키를 저장할 수 있다.
- 쿠키 하나는 4KB(=4096byte) 까지 저장가능

### Cookie 생성 및 추가
- 쿠키 생성 : javax.servlet.http.Cookie(java.lang.String name, java.lang.String value)
```Java
Cookie cookie = new Cookie("userid","ssafy");
```
- 추가 : void javax.servlet.http.HttpServletResponse.addCookie(Cookie cookie)
```Java
response.addCookie(cookie);
```
- 주요 메서드
void setComment (String) : 쿠키에대한 설명 설정
void setDomain (String) : 쿠키의 유효한 도메인 설정
void setMaxAge (int expiry) : 쿠키 유효기간 설정
void setPath (String) : 쿠키 유효 디렉토리 설정
void setValue (String) : 쿠키 값 설정
String getComment() : 쿠키 설명 반환
String getDomain() : 쿠키 유효 도메인 반환
int getMaxAge() : 쿠키 유효기간 반환
String getPath() : 쿠키 유효 디렉토리 반환
String getValue() : 쿠키 값 반환

### Session : javax.servlet.http.HttpSession
- 사용자가 웹 서버에 접속해 있는 상태를 하나의 단위보고 세션이라함.
- 각 세션은 session id 를 이용해 구분
- WAS의 메모리에 객체 형태로 저장
- 메모리가 허용하는 용량 까지 제한없이 저장가능
- 쿠키는 클라이언트에 저장되기 때문에 공유 PC의 경우 보안에 취약할 수 있다. 하지만 세션은 서버에 저장되기 때문에 쿠키에 비해 보안이 좋다.
- 사용자(로그인)정보 및 장바구니 등에 사용

### Session 동작순서
- Client가 페이지 요청
- 서버는 쿠키에 session id가 있는지 확인
- session id가 존재하지 않으면 session id를 생성해 쿠키에 쓴 다음 클라이언트로 반환
- 생성된 session id를 이용하여 서버 내 메모리를 생성
- 클라이언트가 다음 요청 시 쿠키에 session id(JSESSIONID)를 포함에 전달하면 서버내에 저장된 session id와 비교하여 데이터를 조회

### Session 설정
- 브라우저 당 하나의 JSESSIONID 를 할당
- 아이디 또는 닉네임과 같이 로그인했을 경우 자주 사용되는 정보를 session에 저장하면 db에 접근할 필요가 없으므로 효율적이다.

### Session 사용하기
- 요청 객체로부터 session 객체를 얻어온다.
- session에 데이터를 설정하여 저장한다.
```Java
HttpSession session = request.getSession();
session.setAttribute("userid","ssafy");
```
- session에서 값을 반환하는 getAttribute에 메서드는 반환형이 Object
```Java
String userid = '(String)session.getAttribute("userid");
```
- 주요 메서드
void setAttribute (String name,Object value) : session에 지정한 name 에 해당하는 객체를 추가
void setMaxInactiveInterval (int interval) : 사용자가 다음 요청을 보낼 때 까지 세션을 유지하는 최대시간 (초단위)를 설정
void invalidate() : 현재 세션을 없애고, 속성도 삭제한다.
String getId() : 현재 세션의 고유 id를 반환
long getLastAccessTime() : 현재 세션에 클라이언트가 마지막으로 요청을 보낸 시간을 반환 (long)
Object getAttribute (String name) : name에 해당하는 속성값 반환 , 반환형이 Object 임에 유의
long getCreationTime() : 세션이 만들어진 시간 반환
void removeAttribute(String name) : 세션에서 지정한 이름의 객체를 제거
Enumeration getAttributeNames() : 세션에서 모든 객체의 이름을 Enumeration 형으로 반환
