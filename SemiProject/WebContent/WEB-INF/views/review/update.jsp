<%@page import="review.dto.Review"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	Review r = (Review) request.getAttribute("viewReview"); %>
<!DOCTYPE html>
<html>
<head>
<!-- 스마트에디터 2 -->
<script type="text/javascript"
 src="/resources/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<!-- <form>태그의 submit을 수행하면 editor에 작성한 내용을 <textarea>에 반영 -->
<script type="text/javascript">
function submitContents( elClickedObj ) {
	
	//에디터의 내용을 #content에 반영한다
	oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
	
	try {
		// <form>태그의 submit 수행
		elClickedObj.form.submit();
	} catch(e) {}
	
}
</script>
<script type="text/javascript">
$(document).ready(function() {
	
	//수정버튼 동작
	$("#btnUpdate").click(function() {
		
		//스마트 에디터의 내용을 <textarea>에 적용하는 함수를 호출한다
		submitContents( $("#btnUpdate") )
		
		//<form> submit
		$("form").submit();
	});
	
	//취소버튼 동작
	$("#btnCancel").click(function() {
		history.go(-1);
	});
});
</script>
<style type="text/css">
#content {
/* 	width: 100%; */
	width: 98%;
}
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">

<h3>게시글 쓰기</h3>
<hr>

<div>
<form action="/board/update" method="post" enctype="multipart/form-data">
<input type="hidden" name="boardno" value="<%=r.getReviewno() %>" />

<table class="table table-bordered">
<tr><td class="info">회원번호</td><td><%=r.getUserno() %></td></tr>
<tr><td class="info">제목</td><td><input type="text" name="title" style="width:100%" value="<%=r.getTitle() %>"/></td></tr>
<tr><td class="info" colspan="2">본문</td></tr>
<tr><td colspan="2"><textarea id="content" name="content"><%=r.getInq_content() %></textarea></td></tr>
</table>
</form>
</div>
</div>

</body>
</html>