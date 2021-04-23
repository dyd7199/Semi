
<%@page import="com.google.gson.Gson"%>
<%@page import="dto.SeoulGrade"%>
<%@page import="review.dto.Seoul"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% List<SeoulGrade> list = (List<SeoulGrade>)request.getAttribute("list"); %>

<script type="text/javascript">
json = '<%=new Gson().toJson(list) %>';
</script>

<table class="table table-striped">
	<%for(int i=0;i<list.size();i++){ %>

	<tr>
		<td style="font-size: 50px; width: 150px;" >#<%=i+1 %></td>
		
		<td style="height: 100px;width: 300px; height: 150px;">
		<div class="row">
  			<div class="col-xs-6 col-md-10">
   			 <a href="http://d20aeo683mqd6t.cloudfront.net/ko/articles/title_images/000/039/143/medium/IMG_5649%E3%81%AE%E3%82%B3%E3%83%92%E3%82%9A%E3%83%BC.jpg?2019" class="thumbnail">
     		 <img src="http://d20aeo683mqd6t.cloudfront.net/ko/articles/title_images/000/039/143/medium/IMG_5649%E3%81%AE%E3%82%B3%E3%83%92%E3%82%9A%E3%83%BC.jpg?2019" alt="...">
   			 </a>
  		</div>
  		</td>
		
		<td style="font-size: 16px; width: 300px; text-align: left;">
							이름:<%=list.get(i).getUpso_nm() %><a onclick="location.href='/detail?upso_sno=<%=list.get(i).getUpso_sno() %>'"><span style="float: right;" id="moreBtn">자세히보기..</span></a>
							
							<br><br><br>
							평점:<%for(int j=0;j<list.get(i).getAvg();j++) {%>
									<span>⭐</span>
							<%} %><br><br><br>주소:<%=list.get(i).getRdn_code_nm() %><br><br><br>전화번호:<%=list.get(i).getTel_no() %>
		</td>
	</tr>
	<%} %>
</table>
    