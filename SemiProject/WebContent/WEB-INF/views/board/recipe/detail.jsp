<%@page import="java.util.List"%>
<%@page import="dto.Member"%>
<%@page import="dto.Recipe"%>

<%@include file="/WEB-INF/views/board/recipe/recipeHeader.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<% Recipe recipe = (Recipe) request.getAttribute("Recipe"); %>
<% List<Member> mList = (List) request.getAttribute("mList"); %>



<div id="content">
<table id="detail" class="table" style="marget-top: 200px;">
	<tr>
		<th>글 번호</th>
		<th>닉네임</th>
		<th>작성일</th>
		<th>조회수</th>
		<th>제목</th>
		<th>본문</th>
	</tr>
	<tr>
		<td><%=recipe.getPostno() %></td>
		<td>
		<% for(int i=0; i<mList.size(); i++) { %>
			<% if( recipe.getUserno() == mList.get(i).getUserno() ) { %>
			<%=mList.get(i).getNick() %>
			<% } %>
		<% } %>
		</td>
		<td><%=recipe.getCreate_date() %></td>
		<td><%=recipe.getViews() %></td>
		<td><%=recipe.getTitle() %></td>
		<td><%=recipe.getInq_content() %></td>
		
	</tr>


</table>
<hr>

<button id="btnUpdate" name="update" onclick='location.href="/recipe/update?userno=<%=recipe.getUserno() %>";'>수정</button>
<button id="btnDelete" name="delete" onclick='location.href="/recipe/delete?userno=<%=recipe.getUserno() %>&postno=<%=recipe.getPostno() %>";'>삭제</button>
<button id="btnList" name="btnReturn" onclick='location.href="/recipe/list";'>목록으로</button>

</div>

<%@include file="/WEB-INF/views/footer/footer.jsp" %>