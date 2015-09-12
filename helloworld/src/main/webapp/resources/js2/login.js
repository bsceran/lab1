function loginPageSettings() {
	$("#login-dialog").css("display","none");
	$("#login-dialog").css("position","fixed");
}

function displayRegisterDialog(display) {
	if(display) {
		displayLoginDialog(false);
	}

	displayDialog(display, $("#register-dialog"));
	
	$("#register-dialog #username").focus();
	$("#register-dialog #username").val('');
	$("#register-dialog #password").val('');
	$("#register-dialog #password2").val('');
	$("#register-dialog #username-error").css("display","none");
	$("#register-dialog #password-error").css("display","none");
	$("#register-dialog #password2-error").css("display","none");
}

function displayDialog(display, dialog) {
	var top, left;
	
	if(display) {
		display = "block";
		top = ((($(window).height() - dialog.outerHeight()) / 2) + $(window).scrollTop() + "px");
		left = ((($(window).width() - dialog.outerWidth()) / 2) + $(window).scrollLeft() + "px");
		
	} else {
		display = "none";
	}
	dialog.css("top",top);
	dialog.css("left",left);
	dialog.css("position","fixed");
	dialog.css("display",display);

	$("#login-dialog input[name='username']").focus();
	$("#close").css("display",display);
}

function displayLoginDialog(display) {
	if(display) {
		displayRegisterDialog(false);
	}
	
	displayDialog(display, $("#login-dialog"));
	$("#login-dialog input[name='username']").focus();
	$("#register-dialog input[name='username']").val('');
	$("#register-dialog input[name='password']").val('');
	$("#register-dialog input[name='username-error']").css("display","none");
	$("#register-dialog input[name='password-error']").css("display","none");
}


