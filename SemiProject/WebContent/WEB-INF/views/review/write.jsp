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
<style type="text/css">
.star-box {
	/* 별과 별 사이 공백 제거 */
    font-size: 0;
}

.star {
	/* width,height 적용가능하도록 변경 */
	display: inline-block;

	/* 별이 표현되는 영역 크기 */
	width: 15px;
    height: 30px;

	/* 투명한 별 표현 */
	background-image: url(/resources/se2/img/empty.png);
	background-repeat: no-repeat;
	background-size: 200%;
}

.star_left {
	/* 왼쪽 별 */
	background-position: 0 0;
}

.star_right {
	/* 오른쪽 별 */
	background-position: 100% 0;
}

.on {
	/* 채워진 별로 이미지 변경 */
	background-image: url(/resources/se2/img/star.png);
}
</style>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">

//별 선택 위치 변수
var idx = -1;
$(document).ready(function() {
	
	//별 클릭 이벤트
	$(".star").click(function() {
		//클릭된 별이 몇 번째 칸인지 알아내기
		idx = $(this).index();
		
		//모두 투명하게 만들기
		$(".star").removeClass("on")
		
		//클릭이 된 곳까지 채워진 별로 만들기
		for(var i=0; i<=idx; i++) {
			$(".star").eq(i).addClass("on");
		}
		
		//선택한 별점 숫자를 클릭위치값으로 고정
		showStarValue(idx);
		
		$("#star").val( $("#grade").text() );
		$("form").submit();
		
	})
	
	//마우스를 올리면 별 채워지기
	var hover_idx = -1;
	$(".star").mouseover(function() {
		//클릭된 별이 몇 번째 칸인지 알아내기
		hover_idx = $(this).index();
		
		//모두 투명하게 만들기
		$(".star").removeClass("on")
		
		//클릭이 된 곳까지 채워진 별로 만들기
		for(var i=0; i<=hover_idx; i++) {
			$(".star").eq(i).addClass("on");
		}
		
		//선택한 별점 숫자를 마우스움직임에 따라 변경
		showStarValue(hover_idx);
		
	})
	
	//마우스를 떼면 클릭된 값으로 초기화시키기
	$(".star").mouseout(function() {
		
		//별점 숫자를 클릭된 값으로 초기화
		showStarValue(idx);
		
		//모두 투명하게 만들기
		$(".star").removeClass("on")
		
		//클릭이 된 곳까지 채워진 별로 만들기
		for(var i=0; i<=idx; i++) {
			$(".star").eq(i).addClass("on");
		}
		
	})
})

//별 선택 값을 숫자로 보여주는 함수
function showStarValue(val) {
	if( val < 0) {
		val = 0;
	} else {
		val = (val+1)/2;
	}
	
	$(".star-value").html(val);
	
	$("<input type='hidden' value="+val+" name='star_score'>").appendto('form');
}
</script>

</head>

<body>
  <div class="container">
     <h2 style="text-align:center">리뷰 작성</h2>
<br>
<h5 style="color: #808080; font-family:'바탕';">&nbsp;당 식당에 대한 평가를 별점으로 나타내주세요 </h5>
<div class="star-box">
<span class="star star_left"></span>
<span class="star star_right"></span>
<span class="star star_left"></span>
<span class="star star_right"></span>
<span class="star star_left"></span>
<span class="star star_right"></span>
<span class="star star_left"></span>
<span class="star star_right"></span>
<span class="star star_left"></span>
<span class="star star_right"></span>
</div>
    <hr>
<div>
<form action="/review/write" method="post" enctype="multipart/form-data">
<div Class="star-value" id="grade">0</div>
<input type="hidden" id="star" name="star_score" value=""/>

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
	<td colspan="2"><textarea id="inq_content" name="inq_content"></textarea></td>
      </tr>
</table>
첨부파일 <input type="file" name="file" />
      </form>
       </div>
 <div class="text-center">
      <button type="button" id="btnWrite" class="btn btn-warning">작성</button>
      <button type="button" id="btnCancel" class="btn btn-default">취소</button>
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