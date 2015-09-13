$(document).ready(function() {
	$.getScript(url("resources/js/shortkeys.js"));
	$.getScript(url("resources/js/login.js"));
	$.getScript(url("resources/js/header.js"), function(e) {
		$("#header").load(url("header.html"), null, headerSettings); 
	});
	
	$.getScript(url("resources/js/jquery-te-1.4.0.min.js"), function(e) {
		if(! $('#articleEditor').hasClass('jqted')){
			$('#articleEditor').addClass('jqted');
			$('#articleEditor').jqte();
		}
	});
	
	$("#footer").load(url("footer.html"));
	
	if(userRole() != "ROLE_ADMIN" || pageName() == "index") {
		$("form[name='deleteArticleForm']").css("display","none");
		$("input[name='displayForEditButton']").css("display","none");
	}
	
	$( "input[name='displayForEditButton']" ).click(function() {
	  var articleId = $(this).closest(".content").find("input[name='articleId']").val();
	  $.ajax({
	        url : url("getArticleContent?articleId="+articleId),
	        success : function(data) {
	        	$("#articleEditor").jqteVal(data);
	        }
	  });
		
	});
});

function gotoHome() {
	window.location.href = url("index.html");
}



