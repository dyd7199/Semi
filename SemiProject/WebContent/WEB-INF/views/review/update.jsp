<%@page import="review.dto.Review"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	Review r = (Review) request.getAttribute("viewReview"); %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript"
 src="/Resources/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<!-- <form>태그의 submit을 수행하면 editor에 작성한 내용을 <textarea>에 반영 -->
<style type="text/css">
   #inq_content {
 width: 95%;
   }
</style>
<script type="text/javascript">
function submitContents( elClickedObj ) {
	
	//에디터의 내용을 #content에 반영한다
	oEditors.getById["inq_content"].exec("UPDATE_CONTENTS_FIELD", []);
	try {
		// <form>태그의 submit 수행
		elClickedObj.form.submit();
	} catch(e) {}
	
}
</script>
<script type="text/javascript">
$(document).ready(function() {
	
	//수정버튼 동작
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
<style type="text/css">
#content {
/* 	width: 100%; */
	width: 98%;
}
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">


<h3  style="text-align:center">리뷰 수정</h3>
<hr>

<div class="text-center">	
	<button type="button" id="btnUpdate" class="btn btn-info">수정</button>
	<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
</div>
<br>
<div>
<form action="/review/update" method="post">
<input type="hidden" name="boardno" value="<%=r.getReviewno() %>" />

<table class="table table-bordered">
<tr><td class="info" style="background-color: #FAA600; width: 100px;">회원번호</td><td><%=r.getUserno() %></td></tr>
<tr><td class="info" style="background-color: #FAA600;">제목</td><td><input type="text" name="title" style="width:100%" value="<%=r.getTitle() %>"/></td></tr>
<tr><td class="info" style="background-color: #FAA600;" colspan="2">본문</td></tr>
<tr><td colspan="2"><textarea id="inq_content" name="inq_content"><%=r.getInq_content() %></textarea></td></tr>
</table>
</form>
</div>

</div>
<script type="text/javascript">
            
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
oAppRef: oEditors,
elPlaceHolder: "inq_content", //에디터가 적용될 <textarea>의 id를 입력
sSkinURI: "/Resources/se2/SmartEditor2Skin.html",
fCreator: "createSEditor2"
 })

            

function submitContents(elClickedObj) {
  //에디터의 내용을 #content에 반영한다
    oEditors.getById["inq_content"].exec("UPDATE_CONTENTS_FIELD", []);

    console.log(3);
        try {
            // <form>태그의 submit 수행
            elClickedObj.form.submit();
                } catch (e) { }

            }

            console.log(4);
            $(document).ready(function () {

                console.log(5);
                //작성버튼 동작
                $("#btnWrite").click(function () {
                    //스마트 에디터의 내용을 <textarea>에 적용하는 함수를 호출한다
                    console.log(6);
                    submitContents($("#btnWrite"))
                    //<form> submit
                    $("form").submit();
                });

                //취소버튼 동작
                $("#btnCancel").click(function () {
                    console.log(7);
                    history.go(-1);
                });
            });
        </script>
</div>

</body>
</html>