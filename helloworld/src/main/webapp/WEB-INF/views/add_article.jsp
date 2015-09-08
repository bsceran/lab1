<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>

<head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>Sueda'nin Blogu</title>
  <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
  <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/jquery-te-1.4.0.css" />">
  <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/article.css" />">
  <script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />" charset="utf-8"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/jquery-te-1.4.0.min.js"/>"  charset="utf-8"></script>
  <script src="<c:url value="/resources/js/article.js" />"></script>
</head>
  
<body>
	<h1>Yeni Konu</h1>
	<c:url value="/admin/addArticle" var="addArticle" />
	<s:form id="putArticleForm" method="post" commandName="articleContent" action="${addArticle}">
		<s:textarea id="content" class="jqte-test" path="content"></s:textarea>
		<input type="submit" value="Gönder" style="width: 103px; height: 30px;">
		<input onclick="gotoHome()" type="button" value="İptal" style="width: 103px; height: 30px;">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</s:form>
</body>

</html>