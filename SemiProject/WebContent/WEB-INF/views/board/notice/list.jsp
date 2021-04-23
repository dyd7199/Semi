<%@page import="dto.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% List<Notice> list = (List) request.getAttribute("noticeList"); %>    
<%@include file="/WEB-INF/views/header/header.jsp" %>

<style>
.totalnotice {
margin-top: 250px;
margin-bottom: 250px;
text-align: center;

}
</style>


<div class ="table totalnotice">
<h1>공지사항 목록 </h1>

<table>
<tr>
	<th>글번호 </th>
	<th>글제목 </th>
	<th>사용자번호 </th>
	<th>작성 날짜 </th>
	<th>조회수 </th>
</tr>
<% for(int i=0; i<list.size(); i++) { %>
<tr>
	<td><%=list.get(i).getPostno() %></td>
	<td><a href="/notice/view?postno=<%=list.get(i).getPostno() %>" ><%=list.get(i).getTitle() %></a></td>
	<td><%=list.get(i).getUserno() %></td>
	<td><%=list.get(i).getCreate_date() %></td>
	<td><%=list.get(i).getHit() %></td>
</tr>
<% } %>
</table>

</div>



<%@ include file="/WEB-INF/views/board/notice/paging.jsp" %>

<%@ include file="/WEB-INF/views/footer/footer.jsp" %>