<%@page import="dto.NoticeFile"%>
<%@page import="dto.Notice"%>
<%@page import="java.lang.Integer" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/admin/admin_header.jsp" %>

<!-- 네이버 스마트에디터2    -->
<script type="text/javascript"
 src="/Resources/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>
 
 <% Notice notice = (Notice) request.getAttribute("Notice"); %>
 <% NoticeFile noticeFile = (NoticeFile) request.getAttribute("NoticeFile"); %>
 <% Integer postno = (Integer)request.getAttribute("Postno"); %>

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
	
	$("#btnUpdate").click(function() {
	
		//스마트에디터의 내용을 <textarea>에 적용하는 함수를 호출한다
		submitContents( $("#btnUpdate") );

		//<form> submit
		$("form").submit();
	});

	//취소하기 버튼
	$("btnCancel").click(function() {
		history.go(-1);
	})
});

</script>


<style type="text/css">
body { 
    margin:20px auto; 
    padding: 0; 
    padding-top: 80px; 
}

ul#navi {
	margin:20px auto;
    padding: 0;
    font-size:0.9em;
    padding-top: 80px;
    width: 200px;
    text-indent: 10px;
    
    background: #f4f4f4;
    float: left;
    min-height: 700px;
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

.totalnotice {
margin-top: 250px;
margin-bottom: 250px;
text-align: center;

}

.contain {
}


#content {
	width: 98%;
}

</style>



<ul id="navi">
	<li style="height: 50px; padding: 10px;">
    </li>
    <li class="group">
        <div class="title">게시판 관리</div>
       	<ul class="sub">
            <li><a href="#">레시피 공유</a></li>
            <li><a href="/admin/noticelist">공지사항</a></li>
            <li><a href="/admin/inqlist">문의하기</a></li>
       	</ul>
    </li>
    <li class="group">
        <div class="title">데이터 관리</div>
        <ul class="sub">
            <li><a href="#">회원 관리</a></li>                
            <li><a href="#">식당관리</a></li>                
        </ul>
    </li>
</ul>





<div class="contain">
<h1>공지사항 관리자페이지 </h1>
<hr>

<div >
<form action="/admin/noticeupdate" method="post" enctype="multipart/form-data">

<table class="table table-bordered" style="width: 80%;">
<input type="hidden" name ="postno" id ="postno" value= "<%=postno%>"/>
<tr><td class="info">제목</td><td><input type="text" style="width: 98%" name="title" value="<%=notice.getTitle() %>" /><td></tr>
<tr><td class="info" colspan="2">본문 </td></tr>
<tr><td colspan="2"><textarea id="content" name="content" ><%=notice.getInq_content() %></textarea></td></tr>
</table>

첨부파일 <input type="file" name="file" value="<%=noticeFile.getStoredName() %>"/>

</form>
</div>

<div class="text-center">
	<button type="button" id="btnUpdate" class="btn btn-info">수정</button>
	<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
</div>
</div>  <!-- totalnotice -->


<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: "content",
	sSkinURI: "/Resources/se2/SmartEditor2Skin.html",
	fCreator: "createSEditor2"
})
</script>

<%@ include file="/WEB-INF/views/footer/footer.jsp" %>
