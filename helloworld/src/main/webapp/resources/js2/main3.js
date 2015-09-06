jQuery(document).ready(function() {
    $('ul.sf-menu').sooperfish();
    $('.top').click(function() {$('html, body').animate({scrollTop:0}, 'fast'); return false;});
    $("#header").load("header.html", null, function() {
    	var username = $('#username').val();
    	if(username) {
    		$("#loginButton").text(username);
    		$("#loginButton").attr("href", "#");
    		$("#logoutButtonBar").css("display", "block");
    		$("#registerButtonBar").css("display", "none");
    		$("#addArticleButtonBar").css("display", "block");
    	} else {
    		$("#loginButton").text('Giriş yap');
    		$("#loginButton").attr("href", "javascript:displayLoginDialog(true)")
    		$("#logoutButtonBar").css("display", "none");
    		$("#registerButtonBar").css("display", "block");
    		$("#registerButton").attr("href", "javascript:displayRegisterDialog(true)");
    		$("#addArticleButtonBar").css("display", "none");
    	}
    }); 
    $("#footer").load("footer.html");
    $("#login-dialog").load("login.html #login-div", null, function() {
    	$("#login-dialog").css("display","none");
    	$("#login-dialog").css("position","fixed");
    });
    $("#register-dialog").load("register.html #register-div", null, function() {
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
    	
    });
  });

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
	dialog.css("display",display);
	$("#login-dialog input[name='username']").focus();
	$("#close").css("display",display);
}



$(document).keyup(function(e) {
    if (e.keyCode == 27) { // escape key maps to keycode `27`
    	var path = $(location).attr('pathname');

		displayLoginDialog(false);
		displayRegisterDialog(false);
   }
});
