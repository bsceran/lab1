<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>

<head>
  <title>Sueda'nin Blogu</title>
  <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
  <script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"></script>
  <script src="<c:url value="/resources/js/jquery.validate.js" />"></script>
  <script src="<c:url value="/resources/js/additional-methods.js" />"></script>
  <script type="text/javascript">
  	$(document).ready(function() {
  		$('#registerForm').validate({
  			rules:{
  				"username":{
  					required:true,
  					minlength:6,
  					maxlength:10
  				},
  				"password" : {
  					required:true,
  					minlength:4,
  					maxlength:20
  				}
  			},
            submitHandler: function(form){
                form.submit();
            }
  		});
  	});
  </script>
    
</head>

<body>
	<c:url value="/registerRequest" var="registerRequest" />
	<s:form id="registerForm" method="post" commandName="account" action="${registerRequest}">
		<table cellpadding="2" cellspacing="2">
			<tr>
				<td>Kullanici adi</td>
				<td><s:input path="username" id="username" /></td>
			</tr>
			<tr>
				<td>Sifre</td>
				<td><s:password path="password" id="password" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Kayit ol"></td>
			</tr>
		</table>
		 <input type="hidden" 
                     name="${_csrf.parameterName}" value="${_csrf.token}" />
	</s:form>
</body>
</html>