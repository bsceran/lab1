$(document).ready(function() {
	$.getScript(url("resources/js/shortkeys.js"));
	$.getScript(url("resources/js/login.js"));
	$.getScript(url("resources/js/header.js"), function(e) {
		$("#header").load(url("header.html"), null, headerSettings); 
	});
	
	$('.jqte-test').jqte();
	$("#footer").load(url("footer.html"));
});

function gotoHome() {
	window.location.href = url("index.html");
}



