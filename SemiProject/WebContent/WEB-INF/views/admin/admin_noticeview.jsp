<%@page import="dto.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% Notice list = (Notice) request.getAttribute("viewNotice"); %>
<%@include file="/WEB-INF/views/header/header.jsp" %>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js" ></script>

<script>
$(document).ready(function() {
	
	$("#btnList").click(function() {
		$(location).attr("href", "/notice/list");
	});
	
});

</script>


<div class="table">
<h1>공지사항 상세보기 </h1>

<div>
<table>
<tr>
<td>글번호 </td><td><%=list.getPostno() %></td>
</tr>

<tr>
<td>글제목 </td><td><%=list.getTitle() %></td>
</tr>

<tr>
<td>사용자번호 </td>
<td><%=list.getUserno() %></td>
</tr>

<tr>
<td>작성 날짜 </td><td><%=list.getCreate_date() %></td>
</tr>

<tr>
<td>조회수 </td><td><%=list.getHit() %></td>
</tr>

<tr>
<td>글내용 </td><td><%=list.getInq_content() %></td>
</tr>

</table>
</div>

<div>
<button id="btnList">목록 </button>
<button id="btnUpdate">수정 </button>
<button id="btnDelete">삭제 </button>
</div>

</div>


<%@include file="/WEB-INF/views/footer/footer.jsp" %>