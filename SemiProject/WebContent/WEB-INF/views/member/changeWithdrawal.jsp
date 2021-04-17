<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/header/header.jsp" %>

<% Member info = (Member)request.getAttribute("info"); %>
<% boolean check = true; %>
<script type="text/javascript">
$(document).ready(function () {
	$("#cancleBtn").click(function () {
		history.back();
	})
	
	$("#secessionBtn").click(function () {
		alert("정말 탈퇴하시겠습니까?")
	})
	
	
	
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
<form method = "post" action = "/member/secession" name = "userinput" >
<table width = "600" border = "1" cellspacing = "0" cellpadding = "3" align = "center" class="table table-boardered">
<tr class="active">
      <td colspan = "2" height = "39" align = "center">
            <font size = "+1"><b>회원 정보 수정</b></font>
      </td>
</tr>

<tr>
      <td width = "200">ID</td>
      <td width = "400"><%=info.getUserid() %></td>
</tr>


<tr>
      <td width = "200">이름</td>
      <td width = "400">
			<%=info.getUsername() %>
      </td>
</tr>
<tr>
      <td width = "200">닉네임</td>
       <td width = "400">
			<%=info.getNick() %>
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
            <%=info.getEmail() %>
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
            <input type = "button" class="btn btn-default" name = "modify" value = "수  정" id="modifyBtn" onclick = "location.href='/member/chg?check=<%=check%>'">
            <input type = "submit" class="btn btn-default" value = "탈  퇴" id="secessionBtn"/>
            <input type = "button" class="btn btn-default" value = "취  소" id="cancleBtn"/>
</form>


</div>
















<%@include file="/WEB-INF/views/footer/footer.jsp" %>