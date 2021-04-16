<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/header/header.jsp" %>

<% Member info = (Member)request.getAttribute("info"); %>
<script type="text/javascript">
$(document).ready(function () {
	$("#cancleBtn").click(function () {
		history.back();
	})
	
	$("#nickInput").focus();
	
	
	
	
})




</script>

<style>

.session {
	margin-top: 250px;
	margin-bottom: 200px;


}



</style>



<div class="session">
<h1>회원정보 수정 / 탈퇴</h1><br><br>
<form method = "post" action = "/member/update"  >
<table width = "600" border = "1" cellspacing = "0" cellpadding = "3" align = "center" class="table table-boardered">
<tr class="active">
      <td colspan = "2" height = "39" align = "center">
            <font size = "+1"><b>회원 정보 수정</b></font>
      </td>
</tr>
<tr>
      <td colspan = "2" class = "normal" align = "center">
            회원의 정보를 수정합니다.
      </td>
</tr>

<tr>
      <td width = "200">ID</td>
      <td width = "400"><%=info.getUserid() %></td>
</tr>


<tr>
      <td width = "200">이름</td>
      <td width = "400">
<!--             <input type = "text" name = "name" size = "15" -->
<%--                   maxlength = "20" value = "<%= info.getUsername() %>"> --%>

			<%=info.getUsername() %>
      </td>
</tr>
<tr>
      <td width = "200">닉네임</td>
       <td width = "400">
                   <input type = "text" name = "nick" size = "15"
                  maxlength = "20" value = "<%= info.getNick() %>" id="nick" />

      </td>
</tr>


<tr>
      <td width = "200">E-Mail</td>
      <td width = "400">
       <%
             if(info.getEmail() == null)
             {
       %>
            <b>이메일없음</b>
       <%
             }
             else
             {
       %>
                 <input type = "text" name = "email" size = "15"
                  maxlength = "20" value = "<%= info.getEmail() %>">
       <%
             }
       %>
      </td>
</tr>

<tr>
      <td width = "200">생년월일</td>
      <td width = "400">
                 <%= info.getUserbirth() %>
      </td>
</tr>
<tr>
      <td width = "200">성별</td>
      <td width = "400">
            <%= info.getGender() %>
      </td>
</tr>

<tr>
      <td width = "200">회원등급</td>
      <td width = "400">
            <%= info.getGrade() %>
      </td>
</tr>


                 

</table>
            <input type = "submit" class="btn btn-default" name = "modify" value = "저  장" id="modifyBtn">
            <input type = "button" class="btn btn-default" value = "취  소" id="cancleBtn"/>
</form>


</div>
















<%@include file="/WEB-INF/views/footer/footer.jsp" %>