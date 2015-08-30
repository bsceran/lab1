<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>

<head>
  <title>Sueda'nin Blogu</title>
  <meta name="description" content="sueda'nin blogu" />
  <meta name="keywords" content="sueda, psikolojik danisman rehber" />
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="robots" content="noindex,nofollow" />
  <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
  <!-- modernizr enables HTML5 elements and feature detects -->
  <script type="text/javascript" src="<c:url value="/resources/js/modernizr-1.5.min.js" />"></script>
</head>

<body>
  <div id="main">
  	<div id="header" ></div>
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
      <div class="content">
        <img style="float: left; vertical-align: middle; margin: 0 10px 0 0;" src="<c:url value="/resources/images/home.png" />" alt="home" /><h1 style="margin: 15px 0 0 0;">Welcome to the CSS3_two template</h1>
        <p>This simple, fixed width website template is released under a <a href="http://creativecommons.org/licenses/by/3.0">Creative Commons Attribution 3.0 Licence</a>. This means you are free to download and use it for personal and commercial projects. However, you <strong>must leave the 'design from css3templates.co.uk' link in the footer of the template</strong>.</p>
        <p>This template is written entirely in <strong>HTML5</strong> and <strong>CSS3</strong>.</p>
        <p>You can view more free CSS3 web templates <a href="http://www.css3templates.co.uk">here</a>.</p>
        <p>This template is a fully documented 5 page website, with an <a href="examples.html">examples</a> page that gives examples of all the styles available with this design. There is also a working PHP contact form on the contact page.</p>
        <p></p>
        <img style="float: left; vertical-align: middle; margin: 0 10px 0 0;" src="<c:url value="/resources/images/browser.png" />" alt="browser" /><h1 style="margin: 15px 0 0 0;">Browser Compatibility</h1>
        <p>This template has been tested in the following browsers:</p>
        <ul>
          <li>Internet Explorer 8</li>
          <li>Internet Explorer 7</li>
          <li>FireFox 10</li>
          <li>Google Chrome 17</li>
          <li>Safari 5</li>
        </ul>
      </div>
    </div>
    <div id="scroll">
      <a title="Scroll to the top" class="top" href="#"><img src="<c:url value="/resources/images/top.png" />"  alt="top" /></a>
    </div>
    <div id="footer" ></div>
  </div>
  <!-- javascript at the bottom for fast page loading -->
  <script src="<c:url value="/resources/js/jquery.js" />"></script>
  <script src="<c:url value="/resources/js/jquery.easing-sooper.js" />"></script>
  <script src="<c:url value="/resources/js/jquery.sooperfish.js" />"></script>
  <script src="<c:url value="/resources/js/main3.js" />"></script>
</body>
</html>
