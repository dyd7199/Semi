<%@page import="dto.SeoulGrade"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/header/header.jsp" %>


    
   <% List<SeoulGrade> list = (List<SeoulGrade>)request.getAttribute("list"); %>
   
   
   
<div>
		  <img alt="" src="/Resources/img/테마별맛집.png" style="width: 20%; margin:0 auto; margin-top: 80px;">
<table class="table table-striped">
	<%for(int i=0;i<list.size();i++){ %>

	<tr>
		<td style="font-size: 50px; width: 150px;" >#<%=i+1 %></td>
		
		<td style="height: 100px;width: 300px; height: 150px;"><img width="100%" src="https://lh3.googleusercontent.com/proxy/5jQIs5mtkl_NYt3HUzlkYargOb7QKOe3dAe2nzfgUx28LH6PiTmg63WzNnHkmQ4u4VpuMNzH095lMpSGeCCIlzIMJwdxbpa1zb_X5stZG5LTfTHsNNX2R7ZJVuzWQCjOUAzzyxoIx-gpTjWwnS47LU26N-7VPzxqvRNt11QL4YgZ8-NEVfMJw_2CLAGNdiqC9mBsZi-mg5Q-HMk0H4ZRbjMF6hCeMOAzEdraFQd0w9V76g3ALezJ-tF9-UoyixkB9n5WRA"></td>
		<td style="font-size: 16px; width: 300px; text-align: left;"><a onclick="location.href='/detail?upso_sno=<%=list.get(i).getUpso_sno() %>'">이름:<%=list.get(i).getUpso_nm() %></a><br><br><br>평점:<%=list.get(i).getAvg()%><br><br><br>주소:<%=list.get(i).getRdn_code_nm() %><br><br><br>전화번호:<%=list.get(i).getTel_no() %></td>
		<td style="height: 100px;width: 300px; height: 150px;"><a onclick="location.href='/detail?upso_sno=<%=list.get(i).getUpso_sno() %>'"><img width="100%" src="https://lh3.googleusercontent.com/proxy/5jQIs5mtkl_NYt3HUzlkYargOb7QKOe3dAe2nzfgUx28LH6PiTmg63WzNnHkmQ4u4VpuMNzH095lMpSGeCCIlzIMJwdxbpa1zb_X5stZG5LTfTHsNNX2R7ZJVuzWQCjOUAzzyxoIx-gpTjWwnS47LU26N-7VPzxqvRNt11QL4YgZ8-NEVfMJw_2CLAGNdiqC9mBsZi-mg5Q-HMk0H4ZRbjMF6hCeMOAzEdraFQd0w9V76g3ALezJ-tF9-UoyixkB9n5WRA"></td>
		<td style="font-size: 16px; width: 300px; text-align: left;"><a onclick="location.href='/detail?upso_sno=<%=list.get(i).getUpso_sno() %>'">이름:<%=list.get(i).getUpso_nm() %><br><br><br><a onclick="location.href='/detail?upso_sno=<%=list.get(i).getUpso_sno() %>'">평점:<%=list.get(i).getAvg()%><br><br><br><a onclick="location.href='/detail?upso_sno=<%=list.get(i).getUpso_sno() %>'">주소:<%=list.get(i).getRdn_code_nm() %><br><br><br><a onclick="location.href='/detail?upso_sno=<%=list.get(i).getUpso_sno() %>'">전화번호:<%=list.get(i).getTel_no() %></a></td>
	</tr>
	<%} %>
</table>
</div>  




<%@include file="/WEB-INF/views/footer/footer.jsp" %>