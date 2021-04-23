<%@page import="dto.UploadFile"%>
<%@page import="dto.Member"%>
<%@page import="dto.Recipe"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/header/header.jsp" %>


<style type="text/css">
body { 
    margin:20px auto; 
    padding: 0; 
    padding-top: 80px; 
}
    ul#navi {
        width: 200px;
        text-indent: 10px;
        margin:20px auto;
        padding: 0;
        font-size:0.9em;
        padding-top: 80px;
        
        background: #f4f4f4;
     	float: left;
    	min-height: 800px;
        
}
    ul#navi, ul#navi ul {
        margin:0;
        padding:0;
        list-style:none;
}
    li.group {
        margin-bottom: 0;
}
    li.group div.title {
        height: 35px;
        line-height: 35px;
        background:#f4f4f4;
        cursor:pointer;
        font-size: 15px;
        font-weight: bolder;
        padding-bottom: 30px;
}
	li.group div.maintitle {
	    height: 50px;
	    line-height: 50px;
	    background:#f4f4f4;
	    cursor:pointer;
	    font-size: 15px;
	    font-weight: bolder;
	    padding-bottom: 70px;
}
    ul.sub li {
        margin-bottom: 0px;
        height:35px;
        line-height:35px;
        background:#f4f4f4;
        cursor:pointer;
}
    ul.sub li a {
        display: block;
        width: 100%;
        height:100%;
        text-decoration:none;
        color:#000;
}
    ul.sub li:hover {
        background:#FFCC33;
}
</style>

<% Recipe recipe = (Recipe) request.getAttribute("recipe"); %>
<% List<UploadFile> fList = (List) request.getAttribute("fileList"); %>

<!-- 스마트에디터 2 -->
<script type="text/javascript"
 src="/Resources/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>
 
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
	
	//작성버튼 동작
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
 

<div style="text-align: left; height:15px;">
<h3>레시피 글 수정</h3><br>
</div>

<hr style="boarder: 0; height:1px; background: black;"><br>


<div id="area" style="height: 590px;">
<form action="/mypage/recipeupdate" method="post" >
<table class="table table=bordered">
	<tr>
		<td>아이디</td><td><%=session.getAttribute("userid") %></td>
	</tr>
	<tr>
		<td>닉네임</td><td><%=session.getAttribute("usernick") %>
	</tr>
	<tr>
		<td>제목</td><td><input type="text" name="title" style="width:100%;" value="<%=recipe.getTitle() %>"/></td>
	</tr>
	<tr>		
		<td colspan="2" ><textarea id="content" name="content"><%=recipe.getInq_content() %></textarea></td>
	</tr>
	<tr>
		<td>첨부파일</td>
		<td>
			<% for(int j=0; j<fList.size(); j++) {%>
				<% if( recipe.getPostno() == fList.get(j).getPostno() ){%>
					<%=fList.get(j).getStoredName() %>
				<% } %>
			<% } %>
		<input type="hidden" name="postno" value="<%=recipe.getPostno() %>"/>
		<input type="hidden" name="create_date" value="<%=recipe.getCreate_date() %>"/>
		<input type="hidden" name="userno" value="<%=recipe.getUserno() %>"/>
		<input type="hidden" name="views" value="<%=recipe.getViews() %>"/>
		</td>
	</tr>
	<tr>
		<td><a href="/upload/<%=fList.get(0).getStoredName() %>"  download="/upload/<%=fList.get(0).getOriginName() %>"></a></td>
	</tr> 
</table>
</form>
</div>

<div>
	<button type="button" id="btnUpdate">수정 완료</button>
	<button type="button" id="btnCancel">취소</button>
</div>


<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: "content", //에디터가 적용될 <textarea>의 id를 입력
	sSkinURI: "/Resources/se2/SmartEditor2Skin.html",
	fCreator: "createSEditor2"
})
</script>



<%@include file="/WEB-INF/views/footer/footer.jsp" %>