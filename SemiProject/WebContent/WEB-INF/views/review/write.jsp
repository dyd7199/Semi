<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<!-- 스마트에디터2 -->
<style type="text/css">
   #inq_content {
 width: 95%;
   }
</style>
</head>

<body>
  <div class="container">
     <h3>리뷰 작성</h3>
    <hr>
<div>
<form action="/review/write" method="post" enctype="multipart/form-data">
 <table class="table table-bordered">
   <tr>
<td class="info" style="background-color: #FAA600; width: 100px;">회원번호</td>
    <td>
 <%=session.getAttribute("userno") %>
    </td>
</tr>
<tr>
    <td class="info" style="background-color: #FAA600;">제목</td>
     <td><input type="text" name="title" style="width:100%" /></td>
</tr>
     <tr>
     <td class="info" style="background-color: #FAA600;" colspan="2">본문</td>
       </tr>
      <tr>
<td colspan="2"><textarea id="inq_content" name="content"></textarea></td>
      </tr>
</table>
      </form>
       </div>
 <div class="text-center">
      <button type="button" id="btnWrite" class="btn btn-info">작성</button>
      <button type="button" id="btnCancel" class="btn btn-danger">취소</button>
        </div>
        </div>
 <script type="text/javascript">
            
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
oAppRef: oEditors,
elPlaceHolder: "inq_content", //에디터가 적용될 <textarea>의 id를 입력
sSkinURI: "/resources/se2/SmartEditor2Skin.html",
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
    </body>

    </html>