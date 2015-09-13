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
	
	$( "input[name='displayForEditButton']" ).click(function() {
	  var articleId = $(this).closest(".content").find("input[name='articleId']").val();
	  $.ajax({
	        url : url("getArticleContent?articleId="+articleId),
	        success : function(data) {
	        	$("#articleEditor").jqteVal(data);
	        	$("#articleId").val(articleId);
	        	window.scrollTo(0,0);
	        }
	  });
		
	});
	
	$("form[name='publishArticleForm']" ).each(function( index ) {
		var published = $(this).find("input[name='articlePublished']").val();
		if(published == 'true') {
			$(this).css("display","none");
		} else {
			$(this).css("display","block");
		}
	});
	
	$("form[name='unpublishArticleForm']" ).each(function( index ) {
		var published = $(this).find("input[name='articlePublished']").val();
		if(published == 'true') {
			$(this).css("display","block");
		} else {
			$(this).css("display","none");
		}
	});
	
	if(userRole() != "ROLE_ADMIN" || pageName() == "index") {
		$("form[name='deleteArticleForm']").css("display","none");
		$("input[name='displayForEditButton']").css("display","none");
		$("form[name='publishArticleForm']").css("display","none");
		$("form[name='unpublishArticleForm']").css("display","none");
	}
});

function cancelArticle() {
	var articleId = $("#articleId").val();
	if(articleId == "" || articleId == null) {
		$("#articleEditor").jqteVal("");
	} else {
		$.ajax({
			url : url("getArticleContent?articleId="+articleId),
			success : function(data) {
				$("#articleEditor").jqteVal(data);
				$("#articleEditor").focus();
			}
		});
	}
}



