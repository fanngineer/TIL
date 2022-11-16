## Priority A : Essential
- 이 규칙은 오류를 예방하는데 도움을 주기 때문에 반드시 학습하고 준수
- 예외상황은 존재하지만 매우 드물며 JS와 Vue에 대한 전문지식이 있어야 해결가능

### 컴포넌트 이름에 합성어 사용
- root 컴포넌트인 App과 \<transition\>, \<component\> 등 Vue에서 제공되는 빌트인 컴포넌트를 제외하고 컴포넌트의 이름은 항상 합성어를 사용해야 한다.
- 모든 HTML 요소의 이름은 한 단어이기 때문에 합성어를 사용하는 것은 기존 그리고 향후 HTML 요소와의 충돌을 방지해준다.

### 컴포넌트 데이터
- 컴포넌트의 data는 반드시 함수여야 한다.
- 컴포넌트의 data 프로퍼티의 값은 반드시 객체를 반환하는 함수여야함.

### Props 정의
- Prop은 가능한 상세하게 정의되어야 한다.
- 적어도 타입은 명시되도록 가능한 상세하게 정의 : 협업을 위해서

### v-for에 key 지정
- 서브트리의 내부 컴포넌트 상태를 유지하기 위해 v-for는 항상 key와 함께 요구된다.

### v-if와 v-for 동시 사용하지 않기
- 리스트 목록을 필터링 하기 위해서 사용하는 경우, users를 새로운 cmputed속성으로 필터링 된 목록으로 대체할 것
- 숨기기 위해 리스트의 랜더링을 피할 때 사용하는 경우, v-if를 컨테이너 엘리먼트로 옮기기

### 컴포넌트 스타일 스코프
- SPA 특성 때문에 scoped 속성을 적용하기

### Private 속성 이름
- 플러그인, mixin 등에서 커스텀 사용자 private 프로퍼티에는 항상 접두사 $_사용
- 다른 사람의 코드와 충돌을 피하려면 named scope를 포함시키기

## Priority B : Strongly Recommeneded
- 이 규칙은 대부분의 프로젝트에서 가독성 그리고 개발자 경험을 향상 시키는 것으로 발견
- 해당 규칙을 위반해도 코드는 실행되지만, 위반은 드물어야 하는게 좋음.

### 컴포넌트 파일
- Bad Case
```JavaScript
Vue.component('TodoList',{
  //...
})
```
- Good Case
```JavaScript
components/
|- TodoList.js
|- TodoItem.js
```

### 싱글 파일 컴포넌트 이름 규칙 지정
- Bad Case
```JavaScript
components/
|- mycomponent.vue
```
- Good Case
```JavaScript
components/
|- MyComponent.vue
```
### 기본 컴포넌트 이름
- 같은 기능에 해당되는 컴포넌트들은 해당 단어를 이름 제일 앞에 공통 포함 시킨다.

### 단일 인스턴스 컴포넌트 이름
- 활성 인스턴스가 하나만 있어야 하는 구성 요소는 The 접두사로 시작

## Priority C : Recommended
- 동일하게 좋은 여러가지 옵션이 존재하는 경우, 일관성을 보장하기 위해 임의의 선택 가능
- 이 규칙은 각각의 수용가능한 옵션을 설명하고 기본 선택을 제안함
- 좋은 이유가 있다면 자유롭게 선택이 가능

## Priority D : Use with Caution (주의 요함)
- 잠재적 위험요소를 인식시켜주고 언제 그리고 왜 피해야되는지 설명해줌.


