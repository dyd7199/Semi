<%@page import="dto.Inquiry"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	Inquiry inq = (Inquiry) request.getAttribute("viewInquiry"); %>

<%@include file="/WEB-INF/views/header/header.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	
	//목록 버튼 클릭 시
	$("#btnListInq").click(function() {
		$(location).attr("href", "/mypage/inqlist");
	});
	
	//삭제 버튼 클릭 시
	$("#btnDelete").click(function() {
	});
});
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


.inqView_container {
	width: 80%;
	padding: 30px;
	
	float: right;
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
            <li><a href="/mypage/inqwrite">문의하기</a></li>                
            <li><a href="/mypage/inqlist">문의내역 확인</a></li>    
        </ul>
    </li>        
	<li class="group">
        <div class="title">MY 회원정보</div>
        <ul class="sub">
            <li><a href="/member/chg">회원정보 변경/탈퇴</a></li>                
            <li><a href="#">결제 수단 관리</a></li>    
        </ul>
    </li>        
</ul>



<div class="inqView_container">

<h2>문의내용 상세보기</h2>
<br><br>

<div>
<table class="table" style="border: 1px solid #ccc;">
<tr>
	<td class="active">문의번호</td><td><%=inq.getInquiryno() %></td>
	<td class="active">문의종류</td><td><%=inq.getInqsort() %></td>
</tr>
<tr>
	<td class="active">회원번호</td><td><%=inq.getUserno() %></td>
	<td class="active">닉네임</td><td><%=request.getAttribute("nick") %></td>
</tr>
<tr>
	<td class="active">제목</td><td><%=inq.getTitle() %></td>
	<td class="active">작성일자</td><td><%=inq.getCreateDate() %></td>
</tr>
<tr>
	<td class="active" colspan="4">내용</td>
</tr>
<tr>
	<td colspan="4" style="height: 200px;"><%=inq.getInqcontent() %></td>
</tr>
</table>
</div>


<div>
	<button type="button" id="btnListInq" class="btn btn-default">목록으로</button>
	<button type="button" id="btnDeleteInq" class="btn btn-danger">삭제</button>
</div>


<!-- .inqView_container end -->
</div>

<div class="clearfix"></div>




<%@include file="/WEB-INF/views/footer/footer.jsp" %>



