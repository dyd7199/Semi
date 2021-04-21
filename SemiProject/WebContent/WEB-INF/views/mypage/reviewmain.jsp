<%@page import="dto.SeoulGrade"%>
<%@page import="dto.Review"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/header/header.jsp" %>



<style>
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
/*     	float: left; */
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

<% List<Review> list = (List) request.getAttribute("list"); %>
<% List<SeoulGrade> nlist = (List) request.getAttribute("nList"); %>

<ul id="navi">
 		<li class="group">
            <div class="maintitle">나의맛객</div>
        </li>
        <li class="group">
            <div class="title">My페이지</div>
            <ul class="sub">
                <li><a href="#">찜한 식당</a></li>
                <li><a href="#">최근 본 식당</a></li>
                <li><a href="/mypage/review">내가 작성한 후기</a></li>
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
    
<div>
	<h3>내가 작성한 후기</h3>
</div>
<hr>

<div>
<table class="table">
	<tr>
		<td>리뷰번호</td>
		<td>업소명</td>
		<td>제목</td>
		<td>작성일</td>
		<td>별점</td>
	</tr>
	<% for(int i=0; i<list.size(); i++)  { %>
	<tr>
		<td><%=list.get(i).getReviewno() %><td>
		<% for(int j=0; j<nlist.size(); j++){ %>
			<% if( list.get(i).getupso_sno() == nlist.get(j).getUpso_sno()) %>
			<td>
				<%=nlist.get(j).getUpso_nm() %>
			</td>
		<% } %>
		<td><%=list.get(i).getTitle() %></td>
		<td><%=list.get(i).getCreate_date() %></td>
		<td><%=list.get(i).getStar_score() %></td>
	</tr>
	<% } %>
</table>
</div>






<%@include file="/WEB-INF/views/footer/footer.jsp" %>