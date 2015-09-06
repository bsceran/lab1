
$(document).ready(function() {
	$('.jqte-test').jqte();
	
});

function gotoHome() {
	var contextPath = $("#contextPath").val();
	window.location.href = contextPath + "/index.html";
}



