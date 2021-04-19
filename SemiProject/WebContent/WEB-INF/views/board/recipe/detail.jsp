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
		<td colspan="4"><%=recipe.getTitle() %></td>
	</tr>
	<tr>
		<td>닉네임</td>
		<td style="width: 450px;">
			<% for(int i=0; i<mList.size(); i++) { %>
			<% if( recipe.getUserno() == mList.get(i).getUserno() ) { %>
			<%=mList.get(i).getNick() %>
			<% } %>
			<% } %>
		</td>
		<td>조회수 : <%=recipe.getViews() %></td>
		<td>작성일 : <%=recipe.getCreate_date() %></td>
	</tr>
	<tr>
		<td colspan="4" style="height: 300px;"><%=recipe.getInq_content() %></td>
	</tr>
	<tr style="border: white;">
		<td>첨부파일</td>
		<td></td>
	</tr>
</table>
<hr>

<button id="btnUpdate" name="update" onclick='location.href="/recipe/update?userno=<%=recipe.getUserno() %>&postno=<%=recipe.getPostno() %>";'>수정</button>
<button id="btnDelete" name="delete" onclick='location.href="/recipe/delete?userno=<%=recipe.getUserno() %>&postno=<%=recipe.getPostno() %>";'>삭제</button>
<button id="btnList" name="btnReturn" onclick='location.href="/recipe/list";'>목록으로</button>

</div>

<%@include file="/WEB-INF/views/footer/footer.jsp" %>