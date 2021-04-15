<%@page import="review.dto.Review"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	List<Review> list = (List) request.getAttribute("reviewList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	//글쓰기 버튼 누르면 이동
	$("#btnWrite").click(function() {
		location.href="/review/write";
	});
	
});
</script>

<style>
details {
    margin-bottom: 1rem;
}

details > summary {
    background: white;
    padding: 1rem;
    outline: 0;
    border-radius: 5px;
    cursor: pointer;
    transition: background 0.5s;
}

details > summary::-webkit-details-marker {
    background: url(https://marshall-storage.tistory.com/attachment/cfile29.uf@993E16335F785C0037CB43.svg) no-repeat center;
    background-size: contain;
    color: transparent;
    transform: rotate3d(0, 0, 1, 90deg);
    transition: transform 0.25s;
}

details[open] > summary::-webkit-details-marker {
    transform: rotate3d(0, 0, 1, 180deg);
}

details[open] > summary {
    background: #FAA600;
}

details[open] > summary ~ * {
    animation: reveal 0.5s;
}

@keyframes reveal {
    from {
        opacity: 0;
        transform: translate3d(0, -10px, 0);
    }

    to {
        opacity: 1;
        transform: translate3d(0, 0, 0);
    }
    
    details > summary::marker {
    /* styles */
}

details > summary::-webkit-details-marker {
    /* styles */
}
</style>
<title>::: 맛객 :::</title>
</head>
<body>
<h1>Review</h1>
<hr>
<div id="btnBox">
	<button id="btnWrite" class="btn btn-primary">글쓰기</button>
</div>
<br>
<table class="table table-condensed">
<tr>
	<th style="width: 5%;">글번호</th>
	<th style="width: 5%;">회원</th>
	<th style="width: 60%;">리뷰</th>
	<th style="width: 10%;">작성일</th>
	<th style="width: 30%;">&nbsp;&nbsp;&nbsp;수정/삭제</th>

</tr>
<%	for(int i=0; i<list.size(); i++) { %>
<tr>
	
	<td style="width: 5%;"><a href="/review/view?reviewno=<%=list.get(i).getReviewno() %>"><%=list.get(i).getReviewno() %></a></td>
	<td style="width: 5%;"><%=list.get(i).getUserno() %></td>
	<td>
	<details style="width: 60%;"><summary><%=list.get(i).getTitle() %></summary><%=list.get(i).getInq_content() %></details></td>
	<td style="width: 10%;"><%=list.get(i).getCreate_date() %></td>
	<td><button type="button" id="btnUpdate" style="width: 50px;">수정</button>
	<button id="btnDelete" style="width: 50px;">삭제</button>
	&nbsp;&nbsp;
	<img id="star" src="/Resources/img/star<%=list.get(i).getStar_score() %>.png">
		</td>

</tr>
<%	} %>
</table>
<%@ include file="/WEB-INF/views/layout/paging.jsp" %>


<!-- .container -->
</div>
</body>
</html>