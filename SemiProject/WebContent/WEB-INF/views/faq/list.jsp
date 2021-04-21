<%@page import="dto.Faq"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style type="text/css">

</style>

<%@ include file="/WEB-INF/views/header/header.jsp" %>

<% Faq faq = (Faq) request.getAttribute("faq"); %>




<div class="container">

<h1>자주 묻는 질문</h1>
<hr>

<table class="table table-bordered">

<tr>

<td class="show warning"><button type="button" class="btn btn-link">👇</button><%=faq.getTitle() %></td>
</tr>

<tr>
<td class="hidden warning"><%=faq.getInq_content() %></td>
</tr>
</table>


<%@ include file="/WEB-INF/views/footer/footer.jsp" %>
