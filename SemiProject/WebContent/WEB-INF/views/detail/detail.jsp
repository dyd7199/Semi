<%@page import="dto.Review"%>
<%@page import="java.util.List"%>
<%@page import="dto.Seoul"%>
<%@include file="/WEB-INF/views/header/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%	Seoul s = (Seoul) request.getAttribute("viewupso"); %>
<%	Seoul sn = (Seoul) request.getAttribute("upso_sno"); %>
<%	List<Review> list = (List) request.getAttribute("reviewList"); %>

<html>
<head>
<!-- 최신 제이쿼리 -->
<script type="text/javascript"
src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
function getListAjax(upso_sno, curpage) {
	var alldata = {upso_sno: upso_sno, curpage: curpage}
    $.ajax({
        type : "GET",
        url : "/review/list",
        data: alldata,
        dataType : "html",
        error : function() {
            alert('통신실패!!');
        },
        success : function(data) {
        	console.log(data)
        	$("#div1").html(data)
        }
 
    });
}
</script>

<script>
$(document).ready(function(){
	var upso_sno = <%=sn.getUpso_sno() %>
	
	var curpage = <%=request.getParameter("curPage") %>
	if( !curpage ) {
		curpage = 0;
	}
	
	getListAjax(upso_sno, curpage);


	$(document.body).on("click", ".my a", function(e) {
		e.preventDefault();
		
		console.log($(this).attr("data-curpage"))
		getListAjax(upso_sno, $(this).attr("data-curpage"));
		
	})
});

</script>
<style>
.01 {
	margin-top: 100px;
}
</style>
<meta charset="UTF-8">
<title>맛집 상세 화면</title>
</head>
<body>
<div class="container">
<h1>맛집 상세 화면</h1>

<table class="01">
<tbody>
<tr>
<td>업체명</td>
<td><%=s.getUpso_nm() %></td>
</tr>
<tr>
<td>업종</td>
<td><%=s.getBizcnd_code_nm() %>
</tr>
<td>주소</td>
<td><%=s.getRdn_code_nm() %></td>
</tbody>
</table>


<div id="div1" style="border: none; width:1100px; height:500x; "></div>

<%-- <%@ include file="/WEB-INF/views/layout/paging.jsp" %> --%>
</div>
</body>
</html>

<%@include file="/WEB-INF/views/footer/footer.jsp" %>