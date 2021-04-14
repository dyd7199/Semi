<%@page import="review.dto.Review"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	List<Review> list = (List) request.getAttribute("reviewList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	//글쓰기 버튼 누르면 이동
	$("#btnWrite").click(function() {
		location.href="/review/write";
	});
	
});
</script>
<title>::: 맛객 :::</title>
</head>
<body>
<h1>Review</h1>
<hr>
<table class="table table-striped table-hover table-condensed">
<tr>
	<th style="width: 5%;">글번호</th>
	<th style="width: 15%;">아이디</th>
	<th style="width: 20%;">제목</th>
	<th style="width: 45%;">본문</th>
	<th style="width: 10%;">작성일</th>
	<th style="width: 5%;">별점</th>
</tr>
<%	for(int i=0; i<list.size(); i++) { %>
<tr>
	
	<td><a href="/review/view?reviewno=<%=list.get(i).getReviewno() %>"><%=list.get(i).getReviewno() %></a></td>
	<td><%=list.get(i).getUserno() %></td>
	<td><%=list.get(i).getTitle() %></td>
	<td><%=list.get(i).getInq_content() %></td>
	<td><%=list.get(i).getCreate_date() %></td>
	<td><%=list.get(i).getStar_score() %></td>
</tr>
<%	} %>
</table>

<div id="btnBox">
	<button id="btnWrite" class="btn btn-primary">글쓰기</button>
</div>

<!-- .container -->
</div>
</body>
</html>