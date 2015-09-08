(function(){
	$.getScript("resources/js/login.js");
})();

$(document).keyup(function(e) {
    if (e.keyCode == 27) { // escape key maps to keycode `27`
    	var path = $(location).attr('pathname');

		displayLoginDialog(false);
		displayRegisterDialog(false);
   }
});
