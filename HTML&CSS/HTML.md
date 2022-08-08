# HTML
Hyper Text Markup Language
- Hyper Text : 참조를 통해 한 문서에서 다른 문서로 즉시 접근할 수 있는 텍스트
- 태그는 대소문자 구분이 없음
- 엔터, 스페이스바, 탭이 적용되지 않음.

## HTML 구성요소
### 태그
- HTML의 요소는 태그와 내용으로 구성
- 시작태그/ 종료태그 혹은 시작태그만 존재하는 경우도 존재
- 각각의 시작태그는 속성과 속성값을 가질 수 있음

### 주석
<!--주석 내용-->

### 기본구조
- html : 최상위 요소, 문서의 root
- head : 문서제목 문자코드 등 문서에 대한 정보를 가지고 있으며, 브라우저 화면에 출력x
- meta : 문서의 작성자, 날짜 등 본문에 나타나지 않는 일반 정보들
- body : 브라우저 화면에 나타나는 정보, id속성이나 class 속성을 이용

### 특수문자
- &nbsp; : Non-breaking space(공백)
- &lt; : Less than <
- &gt; : Greater than >
- &amp; : Ampersand &
- &quot; : Quotation mark "
- &copy;, &reg;

### Semantic tag
코드의 가독성을 높이고 유지보수를 쉽게 한다.
- \<header\> : 문서 전체나 섹션이 헤더
- \<nav\> : 네비게이션
- \<aside\> : 사이드에 위치한 공간
- \<section\> : 문서의 일반적인 구분
- \<article\> : 문서, 페이지, 사이트 안에서 독립적으로 구분되는 영역
- \<footer\> : 문서 전체나 섹션
- \<h1\> \~ \<h6\> 6단계 구획 제목
  
### Text content
- \<blockquote\> : 긴 인용문, 주로 들여쓰기를 한 것으로 그려짐
- \<hr\> : 구분선
- \<pre\> : 공백, 줄바꿈 등 입력된 그대로 화면에 표시
- \<p\> : 하나의 문단 (문단 상하에 여백과 첫줄 띄워쓰기)
- \<ul\> : unordered list
- \<ol\> : ordered list
- \<div\> : 구문 컨텐츠를 위한 컨테이너

### Inline text semantics
- \<a\> : href 를 통해서 url이나 파일 등 연결가능한 하이퍼링크 생성
- \<b\>,  \<strong\> : 굵은 글씨, 중대하거나 긴급한 콘텐츠(strong)(screen reader 등에서 차이를 보임)
- \<br\> : 텍스트 안에 줄바꿈 생성
- \<i\>, \<em\> : 기울게 표시, 특정 문자열 강조
- \<q\> : 짧은 인라인 인용문
- \<s\> : 취소선
- \<u\> : 밑줄
- \<sup\>, \<sub\> : 위 첨자, 아래 첨자
- \<span\> : 구문 컨텐츠를 위한 인라인 컨테이너

### Image & Multimedia
- \<audio\> : 소리 콘텐츠
- \<img\> : 문서에 이미지 삽입
- \<video\> : 미디어 플레이어를 문서에 삽입
  
### Table content
- \<table\>
- \<thead\>, \<tbody\>, \<tfoot\>
- \<tr\>, \<col\>
- \<th\>, \<td\>
- \<colgroup\>, \<caption\>

### Forms
- 사용자로부터 데이터를 입력 받아 서버에 처리하기 위한 용도로 사용
- 사용자가 작성한 데이터를 서버로 전송


