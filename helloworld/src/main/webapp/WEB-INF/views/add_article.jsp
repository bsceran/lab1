<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>

<head>
  <title>Sueda'nin Blogu</title>
  <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
  <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/jquery-te-1.4.0.css" />">
  <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/article.css" />">
  <script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/jquery-te-1.4.0.min.js" />"></script>
</head>
  
<body>
	<c:url value="/admin/addArticle" var="addArticle" />
	<s:form id="putArticleForm" method="post" commandName="articleContent" action="${addArticle}">
		<s:textarea id="content" class="jqte-test" path="content"></s:textarea>
		<input type="submit" value="Kayit ol">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</s:form>
</body>

<script>
	$('.jqte-test').jqte();
</script>
</html>