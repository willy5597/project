<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL 標籤 -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Spring Form 表單標籤 -->
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
${ user }
<sp:form modelAttribute="user" method="post" action="${pageContext.request.contextPath}/com/leeSofa${ user.id }" class="pure-form">
	<fieldset>
		<legend>User Form</legend>
		<!-- HttpMethod 隱藏欄位 -->
		<input name="_method" type="hidden" value="${ _method }" />
		<!-- 表單元素 -->
		編號: <sp:input path="id" />
		     <br><sp:errors path="id" cssStyle="color: red" /><p />
		電子郵件: <sp:input path="Email" type="text" />
			 <br><sp:errors path="Email" cssStyle="color: red" />
			 <p />
		姓名: <sp:input path="name" type="text" />
			 <br><sp:errors path="name" cssStyle="color: red" />
			<p />
		密碼: <sp:input path="password" type="text" />
			 <br><sp:errors path="password" cssStyle="color: red" />
			<p />
		<button type="submit" class="pure-button pure-button-primary">${ _method eq 'PUT' ? '修改' : '新增' }</button>
		<p />
		<!-- 顯示所有錯誤訊息 -->
		<sp:errors path="*" cssStyle="color: red" />
	</fieldset>
	
</sp:form>