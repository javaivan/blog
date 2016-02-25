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
			add post

			<form:form method="post" action="post-add" commandName="post">
				<table>
					<tr>
						<td>Title</td>
						<td><form:input path="title" /></td>
					</tr>
					<tr>
						<td>Category List</td>
						<td>
							<%--
							<form:select
									path="categories"
									items="${cat}"
									multiple="false"
									itemValue="id"
									itemLabel="title"
							/>--%>
							23
							<form:select multiple="true" path="categories">
								<form:option value="select" />
								<form:options items="${cat}" itemValue="id" itemLabel="title"/>
							</form:select>
						</td>
					</tr>
					<tr>
						<td>Text</td>
						<td>
							<form:select multiple="true" path="text">
								<form:option label="select" value="select" />
								<form:option label="label" value="label" />
								<form:option label="value" value="value" />
								<form:option label="option" value="option" />
							</form:select>
						</td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="submit" /></td>
					</tr>
				</table>
			</form:form>
		<jsp:include page="template/bodyFooter.jsp"/>
	</div>
</body>
</html>