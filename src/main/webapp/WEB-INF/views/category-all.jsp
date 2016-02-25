<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="template/staticFiles.jsp"/>
<body>
	<div id="wraper">
		<jsp:include page="template/bodyHeader.jsp"/>
		Category all
		<c:if test="${!empty categoryList}">
			<table class="data">
				<tr>
					<th>id</th>
					<th>title</th>
				</tr>
				<c:forEach items="${categoryList}" var="category">
					<tr>
						<td>${category.id}</td>
						<td>${category.title}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<jsp:include page="template/bodyFooter.jsp"/>
	</div>
</body>
</html>