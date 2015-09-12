jQuery(document).ready(function() {
	$.getScript(url("resources/js/shortkeys.js"));
	$.getScript(url("resources/js/login.js"),function(e) {
		$("#login-dialog").load(url("login.html") + " #login-div", null, loginPageSettings);
	});
	$.getScript(url("resources/js/register.js"), function(e) {
		$("#register-dialog").load(url("register.html") + " #register-div", null, registerPageSettings);
	});

	headerSettings();
  });

function headerSettings() {
	if(userRole()) {
		$("#loginButton").text(userName());
		$("#loginButton").attr("href", "#");
		$("#logoutButtonBar").css("display", "block");
		$("#registerButtonBar").css("display", "none");
		if(userRole() == 'ROLE_ADMIN') {
			$("#addArticleButtonBar").css("display", "block");
		} else {
			$("#addArticleButtonBar").css("display", "none");
		}
	} else {
		$("#loginButton").text('Giriş yap');
		$("#loginButton").attr("href", "javascript:displayLoginDialog(true)")
		$("#logoutButtonBar").css("display", "none");
		$("#registerButtonBar").css("display", "block");
		$("#registerButton").attr("href", "javascript:displayRegisterDialog(true)");
		$("#addArticleButtonBar").css("display", "none");
	}
}
