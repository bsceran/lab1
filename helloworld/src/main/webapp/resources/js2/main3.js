jQuery(document).ready(function() {
	$.getScript(url("resources/js/shortkeys.js"));
	$.getScript(url("resources/js/login.js"),function(e) {
		$("#login-dialog").load(url("login.html") + " #login-div", null, loginPageSettings);
	});
	$.getScript(url("resources/js/header.js"), function(e) {
		$("#header").load(url("header.html"), null, headerSettings); 
	});
	$.getScript(url("resources/js/register.js"), function(e) {
		$("#register-dialog").load(url("register.html") + " #register-div", null, registerPageSettings);
	});

	$('ul.sf-menu').sooperfish();
    $('.top').click(function() {$('html, body').animate({scrollTop:0}, 'fast'); return false;});
    $("#footer").load("footer.html");
    $("#articles-section").load("articles.html #articles_container");
  });



