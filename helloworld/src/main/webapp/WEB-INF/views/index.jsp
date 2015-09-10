<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>

<head>
  <title>Sueda'nin Blogu</title>
  <meta name="description" content="sueda'nin blogu" />
  <meta name="keywords" content="sueda, psikolojik danisman rehber" />
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <meta content="utf-8" http-equiv="encoding">
  <meta http-equiv="robots" content="noindex,nofollow" />
  <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
  <!-- modernizr enables HTML5 elements and feature detects -->
  <script type="text/javascript" src="<c:url value="/resources/js/modernizr-1.5.min.js" />"></script>
</head>

<body>
  <div id="main">
  	<div id="header" ></div>
  	<div id="login-dialog"></div>
  	<div id="register-dialog"></div>
  	
    <div id="site_content">
      <div id="sidebar_container">
        <img class="paperclip" src="<c:url value="/resources/images/paperclip.png" />" alt="paperclip" />
        <div class="sidebar">
          <h3>Latest News</h3>
          <h4>New Website Launched</h4>
          <h5>January 1st, 2012</h5>
          <p>2012 sees the redesign of our website. Take a look around and let us know what you think.<br /><a href="#">Read more</a></p>
        </div>
        <img class="paperclip" src="<c:url value="/resources/images/paperclip.png" />" alt="paperclip" />
        <div class="sidebar">
          <h3>Useful Links</h3>
          <ul>
            <li><a href="#">First Link</a></li>
            <li><a href="#">Another Link</a></li>
            <li><a href="#">And Another</a></li>
            <li><a href="#">Last One</a></li>
          </ul>
        </div>
        <img class="paperclip" src="<c:url value="/resources/images/paperclip.png" />" alt="paperclip" />
        <div class="sidebar">
          <h3>More Useful Links</h3>
          <ul>
            <li><a href="#">First Link</a></li>
            <li><a href="#">Another Link</a></li>
            <li><a href="#">And Another</a></li>
            <li><a href="#">Last One</a></li>
          </ul>
        </div>
      </div>
      <div id="articles-section"></div>
    </div>
    <div id="scroll">
      <a title="Scroll to the top" class="top" href="#"><img src="<c:url value="/resources/images/top.png" />"  alt="top" /></a>
    </div>
    <div id="footer" ></div>
  </div>
  <!-- javascript at the bottom for fast page loading -->
  <script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"></script>
  <script src="<c:url value="/resources/js/jquery.easing-sooper.js" />"></script>
  <script src="<c:url value="/resources/js/jquery.sooperfish.js" />"></script>
  <script src="<c:url value="/jsBridge" />"></script>
  <script src="<c:url value="/resources/js/main3.js" />"></script>
   <script src="<c:url value="/resources/js/jquery.validate.js" />"></script>
  <script src="<c:url value="/resources/js/additional-methods.js" />"></script>
</body>
</html>
