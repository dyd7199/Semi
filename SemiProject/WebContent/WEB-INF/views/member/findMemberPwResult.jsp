<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% Member member = (Member)request.getAttribute("member"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">

$(document).ready(function () {
	<%if(member == null){%>
		alert("등록된 정보를 찾을 수 없습니다!")
		self.close();
	<%} else {%>
		alert("등록된 이메일로 발송합니다.")
		self.close();
	<%}%>
})


</script>


</head>
<body>

</body>
</html>