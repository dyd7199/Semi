<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/header/header.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	
	//작성하기 버튼
	$("#btnWriteInq").click(function() {
		$("form").submit();
	})
	
	//취소 버튼
	$("#btnCancel").click(function() {
		$(location).attr("href", "/mypage/inqlist");
	})
	
})

</script>


<style>
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


.inq_container {
	width: 80%;
	padding: 30px;
	
	float: right;
}


textarea {
	width: 100%;
	height: 100px;
}

td:nth-child(2n) {
	text-align: left;
}

</style>



<ul id="navi">
	<li class="group">
    	<div class="maintitle">나의맛객</div>
    </li>
    <li class="group">
        <div class="title">MyPage</div>
       	<ul class="sub">
            <li><a href="#">찜한식당</a></li>
            <li><a href="#">최근 본 식당</a></li>
            <li><a href="#">내가 작성한 후기</a></li>
            <li><a href="#">내가 작성한 레시피</a></li>
       	</ul>
    </li>
    <li class="group">
        <div class="title">MY혜택</div>
        <ul class="sub">
            <li><a href="#">프리미엄 가입하기</a></li>                
            <li><a href="#">프리미엄 혜택보기</a></li>                
        </ul>
    </li>
    <li class="group">
        <div class="title">MY 활동</div>
        <ul class="sub">
            <li><a href="/mypage/inq">문의하기</a></li>                
            <li><a href="/mypage/inqlist">문의내역 확인</a></li>  
        </ul>
    </li>        
  	<li class="group">
        <div class="title">MY 회원정보</div>
        <ul class="sub">
            <li><a href="#">회원정보 변경/탈퇴</a></li>                
            <li><a href="#">결제 수단 관리</a></li>    
        </ul>
    </li>        
</ul>





<div class="inq_container">

<h2>1 : 1 문의하기</h2>
<br><br>

<div>
<form action="/mypage/inq" method="post">

<table class="table">
<tr>
	<td class="active">문의번호</td>
	<td><%=session.getAttribute("inquiry_no") %></td>
</tr>
<tr>
	<td class="active">문의종류</td>
	<td colspan="2"><select>
		<option value="회원_정보">회원정보 수정</option>
		<option value="회원_탈퇴">회원탈퇴</option>
		<option value="회원_프리미엄">프리미엄 회원</option>
		<option value="식당">식당</option>
		<option value="기타">기타</option>
		</select></td>
</tr>
<tr>
	<td class="active">제목</td>
	<td><input type="text" name="title" style="width: 80%;"></td>
</tr>
<tr>
	<td class="active">회원번호</td>
	<td><%=session.getAttribute("userno") %></td>
</tr>
<tr>
	<td class="active" colspan="2">문의 내용</td>
</tr>
<tr>
	<td colspan="2"><textarea id="content" name="content"></textarea></td>
</tr>
</table>

<input type="file" name="attachmentsfile" />

</form>
</div>


<div>
	<button type="button" id="btnWriteInq" class="btn btn-info">작성하기</button>
	<button type="button" id="btnCancel" class="btn btn-default">취소</button>
</div>


<!-- .inq_container end -->
</div>


<div class="clearfix"></div>


<%@include file="/WEB-INF/views/footer/footer.jsp" %>
