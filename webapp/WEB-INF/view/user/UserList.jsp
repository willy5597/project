<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL 標籤 -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Spring Form 表單標籤 -->
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/2.0.7/css/dataTables.dataTables.min.css" />
<link rel="stylesheet" href="https://cdn.datatables.net/2.0.7/css/dataTables.dataTables.css" />
<link rel="stylesheet" href="https://cdn.datatables.net/buttons/3.0.2/css/buttons.dataTables.css" />
<script src="https://cdn.datatables.net/2.0.7/js/dataTables.js"></script>
<script src="https://cdn.datatables.net/buttons/3.0.2/js/dataTables.buttons.js"></script>
<script src="https://cdn.datatables.net/buttons/3.0.2/js/buttons.dataTables.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.10.1/jszip.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.2.7/pdfmake.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.2.7/vfs_fonts.js"></script>
<script src="https://cdn.datatables.net/buttons/3.0.2/js/buttons.html5.min.js"></script>
<script src="https://cdn.datatables.net/buttons/3.0.2/js/buttons.print.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() { 
		new DataTable('#myTable', {
		    layout: {
		        topStart: {
		            buttons: ['copy', 'csv', 'excel', 'pdf', 'print']
		        }
		    }
		});
	});
</script>

<div class="pure-form">
	<fieldset>
		<legend>
			User List
		</legend>
		
		<!-- User table -->
		<table id="myTable" class="pure-table pure-table-bordered">
			<thead>
				<tr>
					<th>序號</th><th>姓名</th><th>電子郵件</th><th>密碼</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ UserDtos }" var="userDto">
					<tr>
						<td>${ userDto.id }</td>
						<td>${ userDto.name }</td>
						<td>${ userDto.email}</td>
						<td>${ userDto.password}</td>
						<td>
                         <a href="${pageContext.request.contextPath}/users/${ userDto.id }" class="pure-button">修改</a>
						</td>
						<td>
							<!-- 刪除 from 表單 -->
							<form method="post" action="${pageContext.request.contextPath}/users/${ userDto.id }">
								<input name="_method" type="hidden" value="DELETE">
								<button type="submit" class="pure-button">刪除</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
				
	</fieldset>
</div>

  