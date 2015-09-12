<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>

<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>

<body>
	<div><tiles:insertAttribute name="header" /></div>  
	<div style="font-size:0px">
		<div style="float:left;padding:10px;width:80%; font-size:14px; box-sizing: border-box;"><tiles:insertAttribute name="articles" /></div>  
		<div style="float:right;padding:10px;width:20%; font-size:14px; box-sizing: border-box;"><tiles:insertAttribute name="sidebar" /></div>  
	</div>
	<div style="clear:both;"><tiles:insertAttribute name="scroll" /></div> 
	<div style="clear:both;"><tiles:insertAttribute name="footer" /></div>   
</body>
</html>
