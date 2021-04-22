<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/admin/admin_header.jsp" %>

<!-- 네이버 스마트에디터2    -->
<script type="text/javascript"
 src="/resources/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>



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

<div>
<form>

<table class="table table-bordered">
<tr><td class="info">아이디 </td></tr>
<tr><td class="info">닉네임 </td></tr>
<tr><td class="info">제목 </td></tr>
<tr><td class="info" colspan="2">본문 </td></tr>
<tr><td colspan="2"><textarea id="content" name="content"></textarea></td></tr>
</table>

</form>
</div>


</div>  <!-- totalnotice -->



<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: "content",
	sSkinURI: "/resources/se2/SmartEditor2Skin.html",
	fCreator: "createSEditor2"
})
</script>

<%@ include file="/WEB-INF/views/footer/footer.jsp" %>
