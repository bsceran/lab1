$(document).keyup(function(e) {
	if (e.keyCode == 27) { // escape key maps to keycode `27`
		$.getScript(url("resources/js/login.js"), function(e) {
			displayLoginDialog(false);
			displayRegisterDialog(false);
		});
   }
});
