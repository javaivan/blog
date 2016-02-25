<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="header">
	<h1 class="logo"><a href="<spring:url value="/" htmlEscape="true" />">Home</a></h1>
	<ul class="nav">
		<li><a href="<spring:url value="/post-add" htmlEscape="true" />">Post Add</a></li>
		<li><a href="<spring:url value="/post-all" htmlEscape="true" />">Post All</a></li>
		<li><a href="<spring:url value="/category-add" htmlEscape="true" />">Post Category Add</a></li>
		<li><a href="<spring:url value="/category-all" htmlEscape="true" />">Post Category All</a></li>
	</ul>
</div>
