# Vue.js
- 사용자 인터페이스를 만들기 위한 progressive framework
- 현대적 도구 및 지원하는 라이브러리와 함께 사용하면 정교한 SPA(Single Page Application)을 지원
- Approachable
- Versatile
- Performant

## MVVM Pattern
- Model + View + ViewModel
- 애플리케이션 로직을 UI로 부터 분리하기 위해 설계한 디자인 패턴
- Model : 순수 자바스크립트 객체(데이터를 담기 위해 사용)
- View : 웹페이지의 DOM(HTML)
- ViewModel : Vue의 역할, View와 Model 사이에서 Data와 DOM에 관련된 일 처리

## Vue Instance 생성
- 모든 Vue 앱은 Vue 함수로 새 인스턴스를 만들며 시작.
```HTML
<script>
  const app = new Vue({
      //옵션
  })
</script>
```
- Vue 인스턴스를 생성할 때는 Options객체를 전달해야 함.
## Vue Instance - Options : el
- Vue 인스턴스에 마운트할 기존 DOM엘리먼트 지정
- CSS selector or HTML Element 작성
- new를 이용한 인스턴스 생성때만 사용한다.
```HTML
<div id = "app"></div>

<script>
  const app = new Vue({
      //옵션
  })
</script>

<script>
  const div = document.querySelector("#app");
  const app = new Vue({
    el : div
  })
</script>
```

# Vue Template Syntax
## Directive
- v- 접두사가 있는 특수 속성
- 속성값은 단일 JavaScript 표현식이 됨.
- 역할은 표현식의 값이 변경될 때 사이드 이펙트를 반응적으로 DOM에 적용

### v-text
- 엘리먼트의 textContent를 업데이트
- 일부를 갱신해야 한다면 {{}}를 사용해야함.
```html
<span v-text = "msg"></span>
<!-- equal -->
<span>{{msg}}</span>
```

### v-bind
- HTML 요소의 속성에 Vue 상태 데이터를 값으로 할당
- Object형태로 사용하면 value가 true인 key가 class 바인딩 값으로 할당
```html
<a v-bind:href = "url">... </a>
```

### v-model
- HTML form 요소의 input 엘리먼트 또는 컴포넌트에 양방향 바인딩 처리
- Object형태로 사용하면 value가 true인 key가 class 바인딩 값으로 할당
```html
<a v-bind:href = "url">... </a>
```
