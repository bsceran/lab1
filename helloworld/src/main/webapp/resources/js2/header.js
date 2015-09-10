
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
