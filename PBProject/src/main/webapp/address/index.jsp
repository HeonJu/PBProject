<%@page import="com.example.PBVO"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
//요청 객체에서 list 속성 받아오기
List<PBVO> list = (List<PBVO>)request.getAttribute("list");
%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">

<title>전화번호 관리 웹 서비스</title>
</head>


<body>

 <h1>시작화면</h1>
 <br>

 <h2>주소록   Servlet</h2>
 
 <h3>목록</h3>
 

<form action="<%= request.getContextPath() %>"
		method="POST">
	<!-- hidden은 사용자 입력은 아니지만 전송해야 할 데이터 -->
		<input type="hidden" value="add" name="a" />
		<input type="hidden" value="add" name="a" />
		<label for="last_name">검색어</label>
		<input type="text" name="last_name" id="last_name" />
	

		<!-- 전송 버튼 -->
		<input type="submit" value="검색" />
	</form>
	
	
	
<table border="1">

      <!-- 행 -->
      <thead>
         <tr style="background-color=lightgray;">
            <th>이름</th>
            <th>휴대전화</th>
            <th>전화번호</th>
            <th>도구</th>
         </tr>
      </thead>
      	  <% for (PBVO vo: list) { %>
      
      	
      <tbody>
    
         <tr>

		
		
			<td><%= vo.getName() %></td>
			<td><%= vo.getHp() %></td>
			<td><%= vo.getTel() %></td>  
		
			
		
		
            
            <td colspan="2">
            
            
            <!-- 삭제 폼 -->
               <form action=""
                  method="POST">
                  <input type="submit" value="삭제" />
               </form>
               
               
               
            </td>
         </tr>
      </tbody>
   </table>
	<% } %>
	
	
  <a href="<%= request.getContextPath() %>/address/add.jsp">새 주소 추가</a>

</body>
</html>