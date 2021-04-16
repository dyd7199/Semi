<%@page import="dto.Member"%>
<%@page import="java.util.List"%>
<%@page import="dto.Recipe"%>
    
<%@include file="/WEB-INF/views/board/recipe/recipeHeader.jsp" %>
    
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<% List<Recipe> list = (List) request.getAttribute("List"); %>
<% List<Member> mList = (List) request.getAttribute("mList"); %>

<a href="/notice/list">공지사항</a>
<a href="/recipe/list">레시피공유</a>
<a href="/faq">FAQ</a>
<hr>

<div id="content">
<table class="table table-hover">
	<tr class="active">
		<th width="5%">글번호</th>
		<th width="65%">제목</th>
		<th width="10%">작성자</th>
		<th width="15%">작성일</th>
		<th width="5%">조회수</th>
	</tr>
	<%	for(int i=0; i<list.size(); i++) { %>
	<tr>
		<td><%=list.get(i).getPostno() %></td>
		<td>
			<a href="/recipe/detail?postno=<%=list.get(i).getPostno() %>">
			<%=list.get(i).getTitle() %>
			</a>
		</td>
		<td><% for(int j=0; j<mList.size(); j++){ %>
				<% if( list.get(i).getUserno() == mList.get(j).getUserno() ) { %>
				 <%=mList.get(j).getUsername() %>
					<% } %>
				<% } %>
		</td>
		<td><%=list.get(i).getCreate_date() %></td>
		<td><%=list.get(i).getViews() %>
	<%	} %>
	</tr>
</table>
<hr>
</div>

<div>
<button style="float: right;" onclick='location.href="/recipe/write";'>글쓰기</button>
</div>

<%@ include file="/WEB-INF/views/board/recipe/paging.jsp" %>
    
<%@include file="/WEB-INF/views/footer/footer.jsp" %>
    

