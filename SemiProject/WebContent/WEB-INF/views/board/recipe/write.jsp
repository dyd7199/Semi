<%@include file="/WEB-INF/views/board/recipe/recipeHeader.jsp" %>
    
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
	$("#btnWrite").click(function() {
		
		//스마트 에디터의 내용을 <textarea>에 적용하는 함수를 호출한다
		submitContents( $("#btnWrite") )
		
		//<form> submit
		$("form").submit();
	});
	
	//취소버튼 동작
	$("#btnCancel").click(function() {
		history.go(-1);
	});
});
</script>
 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style type="text/css">
#content {
	/* width: 100%; */
	width: 98%;
}


input .title{
	width: 98%;
}
</style>

<h3>레시피 쓰기</h3><br>

<hr><br>

<div id="area">
<form action="/recipe/write" method="post" >
<table class="table table-bordered">

	<tr>
		<td>아이디</td><td><%=session.getAttribute("userid") %></td>
	</tr>
	<tr>
		<td>닉네임</td><td><%=session.getAttribute("usernick") %>
	</tr>
	<tr>
		<td>제목</td><td><input type="text" name="title" style="width: 95%"/></td>
	</tr>
	<tr>
		<td colspan="2">내용</td>
	</tr>
	<tr>		
		<td colspan="2"><textarea id="content" name="content"></textarea></td>
	</tr>

</table>
</form>

</div>
<div>
	<button type="button" id="btnWrite">완료</button>
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