<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 주소 추가</title>
</head>
<body>

 <h1>새 주소 추가</h1>
 <br>

 <h2>주소록   Servlet</h2>
 
 <h3>새 주소 등록</h3>
<div border="1">
<form action="<%= request.getContextPath() %>"
		method="POST">
	<!-- hidden은 사용자 입력은 아니지만 전송해야 할 데이터 -->
	
	<div class="box" style="border: 2px solid gray; padding : 10px; width: 250px; height: 180px; border-radius : 5%;">
	
 
		<input type="hidden" value="add" name="a" />
		<input type="hidden" value="add" name="a" />
		<label for="last_name">이름</label>
		<br>
		<input type="text" name="last_name" id="last_name" /><br />
		<label for="first_name">휴대전화</label>
		<br>
		<input type="text" name="first_name" id="first_name" /><br />
		<label for="email">집전화</label>
		<br>
		<input type="text" name="email" id="email" /><br />

		<!-- 전송 버튼 -->
		<div style="text-align: right; padding : 10px 96px 0px;">
		<input type="submit" value="주소등록" /></div>

 </div>
	</form>

</div>


</body>
</html>