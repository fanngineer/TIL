<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "./../include/header.jsp" %>
<div class="col-lg-4 mx-auto py-5">
	<form action="${pageContext.request.contextPath}/UserServlet" method="post">
		<input type = "hidden" name = "action" value = "signup">
		<div class="mb-3">
			<label for="userId" class=form-label>아이디</label> <input type="text"
				class="form-control" id="userId" name="userId">
		</div>
		<div class="mb-3">
			<label for="password" class=form-label>비밀번호</label> <input type="password"
				class="form-control" id="password" name="password">
		</div>
		<div class="mb-3">
			<label for="passwordCheck" class=form-label>비밀번호 확인</label> <input type="password"
				class="form-control" id="passwordCheck" name="passwordCheck">
		</div>
		<div class="mb-3">
			<label for="userName" class=form-label>이름</label> <input type="text"
				class="form-control" id="userName" name="userName">
		</div>
		<div class="mb-3">
			<label for="nickName" class=form-label>닉네임</label> <input type="text"
				class="form-control" id="nickName" name="nickName">
		</div>
		<div class="mb-3">
			<label for="email" class=form-label>이메일</label> <input type="text"
				class="form-control" id="email" name="email">
		</div>
		<input type = "submit" class = "btn btn-primary" value = "제출">
	</form>
	
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>