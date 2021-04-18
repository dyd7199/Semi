<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/header/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<script>
$(document).ready(function(){
    $("#div1").load("review/list");
});

</script>
<script type="text/javascript" async> 
var url_default_ks = "https://story.kakao.com/share?url="; 
var url_default_fb = "https://www.facebook.com/sharer/sharer.php?u="; 
var url_default_tw_txt = "https://twitter.com/intent/tweet?text="; 
var url_default_tw_url = "&url="; 
var url_default_band = "http://band.us/plugin/share?body="; 
var url_route_band = "&route="; 
var url_default_naver = "http://share.naver.com/web/shareView.nhn?url="; 
var title_default_naver = "&title="; 
var url_this_page = location.href; 
var title_this_page = document.title; 
var url_combine_ks = url_default_ks + url_this_page; 
var url_combine_fb = url_default_fb + url_this_page; 
var url_combine_tw = url_default_tw_txt + document.title + url_default_tw_url + url_this_page; 
var url_combine_band = url_default_band + encodeURI(url_this_page)+ '%0A' + encodeURI(title_this_page)+'%0A' + '&route=tistory.com'; 
var url_combine_naver = url_default_naver + encodeURI(url_this_page) + title_default_naver + encodeURI(title_this_page); 
</script>
</head>

<body>
<!-- SNS 공유용 주소 연결 용 --> 


<br>
<br>

<img align="left" src="/resources/se2/img/korean2.jpg">

<h1 align="left">&nbsp;&nbsp;&nbsp;&nbsp;식당명</h1>
<span class="btn-type1">
<img width=50; height=50; src="/resources/se2/img/iconshare.png">
<!-- SNS버튼 시작 --> 
<div style="width: 100%; text-align: center; margin-bottom: 64px;"> 
<!-- 페이스북 공유 버튼 --> 
<a href="" onclick="window.open(url_combine_fb, '', 'scrollbars=no, width=600, height=600'); return false;"><img src="/resources/se2/img/facebook.png" title="페이스북으로 공유하기" class="sharebtn_custom" style="width: 32px;"></a> 
<!-- 트위터 공유 버튼 --> <a href="" onclick="window.open(url_combine_tw, '', 'scrollbars=no, width=600, height=600'); return false;"><img src="/resources/se2/img/twitter.png" title="트위터로 공유하기" class="sharebtn_custom" style="width: 32px;"></a> 
<!-- 카카오 스토리 공유 버튼 --> <a href="" onclick="window.open(url_combine_ks, '', 'scrollbars=no, width=600, height=600'); return false;"><img src="/resources/se2/img/kakaostory.png" title="카카오스토리로 공유하기" class="sharebtn_custom" style="width: 32px;"></a> 
<!-- 네이버 공유 버튼 --> <a href="" onclick="window.open(url_combine_naver, '', 'scrollbars=no, width=600, height=600'); return false;"><img src="/resources/se2/img/naver.jpg" title="네이버로 공유하기" class="sharebtn_custom" style="width: 32px;"></a> 
<!-- SNS버튼 끝 -->

</span>
<hr>
<br>
<table>
<tr>
<td>업체명</td>
<td>&nbsp;&nbsp;한식밥상</td>
</tr>
<tr>
<td>업종</td>
<td>한식</td>
</tr>
<tr>
<td>주소</td>
<td>&nbsp;&nbsp;서울시 강동구</td>
</tr>
<tr>
<td>전화번호</td>
<td>&nbsp;&nbsp;02-1234-4729</td>
</tr>
<tr>
<td>메뉴</td>
<td>&nbsp;&nbsp;비빔밥</td>
</tr>
</table>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

<div id="div1" style="border: none; width:1000px; height:500x; "></div>







</body>

</html>



<%@include file="/WEB-INF/views/footer/footer.jsp" %>