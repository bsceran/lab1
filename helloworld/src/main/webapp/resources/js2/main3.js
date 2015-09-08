(function(){
	$.getScript("resources/js/shortkeys.js");
	$.getScript("resources/js/login.js");
})();

jQuery(document).ready(function() {
    $('ul.sf-menu').sooperfish();
    $('.top').click(function() {$('html, body').animate({scrollTop:0}, 'fast'); return false;});
    $("#header").load("header.html", null, headerSettings); 
    $("#footer").load("footer.html");
    $("#login-dialog").load("login.html #login-div", null, loginPageSettings);
    $("#register-dialog").load("register.html #register-div", null, registerPageSettings);
    $("#articles-section").load("articles.html #articles_container");
  });

function loginPageSettings() {
	$("#login-dialog").css("display","none");
	$("#login-dialog").css("position","fixed");
}

function registerPageSettings() {
	$('#registerForm').validate({
			rules:{
				"username":{
					required:true,
					minlength:4,
					maxlength:10
				},
				"password" : {
					minlength:4,
					maxlength:20
				},
				"password2" : {
					minlength:4,
					maxlength:20,
					equalTo : "#password"
				}
			},
			messages:{
				"username":{
					required:"Bir kullanici adı girmelısiniz.",
					minlength:"En az dört karakter olmalıdır.",
					maxlength:"En fazla on karakter olabilir."
				},
				"password" : {
					minlength:"En az dört karakter olmalıdır.",
					maxlength:"En fazla yirmi karakter olabilir."
				},
				"password2" : {
					minlength:"En az dört karakter olmalıdır.",
					maxlength:"En fazla yirmi karakter olabilir.",
					equalTo : "Aynı şifreyi girmelisiniz."
				}
			},
        submitHandler: function(form){
            form.submit();
        }
		});
	$("#register-dialog").css("display","none");
	$("#register-dialog").css("position","fixed");
	
}

function headerSettings() {
	var userRole = $('#userRole').val();
	console.log("role:" + userRole);
	if(userRole) {
		var userName = $('#userName').val();
		$("#loginButton").text(userName);
		$("#loginButton").attr("href", "#");
		$("#logoutButtonBar").css("display", "block");
		$("#registerButtonBar").css("display", "none");
		if(userRole == 'ROLE_ADMIN') {
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
