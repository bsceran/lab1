jQuery(document).ready(function() {
    $('ul.sf-menu').sooperfish();
    $('.top').click(function() {$('html, body').animate({scrollTop:0}, 'fast'); return false;});
    $("#header").load("header.html", null, function() {
    	var username = $('#username').val();
    	if(username) {
    		$("#loginButton").text(username);
    		$("#loginButton").attr("href", "#");
    		$("#logoutButtonBar").css("display", "block");
    	} else {
    		$("#loginButton").text('Giriş yap');
    		$("#loginButton").attr("href", "javascript:displayLoginDialog(true)")
    		$("#logoutButtonBar").css("display", "none");
    	}
    }); 
    $("#footer").load("footer.html");
    $("#registerwindow_").load("register.html");
    $("#login-dialog").load("login.html #login-div", null, function() {
    	$("#login-dialog").css("display","none");
    	$("#login-dialog").css("position","fixed");
    });
  });

function displayLoginDialog(display) {
	var top, left;
	
	if(display) {
		display = "block";
		top = ((($(window).height() - $("#login-dialog").outerHeight()) / 2) + $(window).scrollTop() + "px");
		left = ((($(window).width() - $("#login-dialog").outerWidth()) / 2) + $(window).scrollLeft() + "px");
		
	} else {
		display = "none";
	}
	$("#login-dialog").css("top",top);
	$("#login-dialog").css("left",left);
	$("#login-dialog").css("display",display);
	$("#login-dialog input[name='username']").focus();
	$("#close").css("display",display);
}

$(document).keyup(function(e) {
    if (e.keyCode == 27) { // escape key maps to keycode `27`
    	var path = $(location).attr('pathname');

    	var display = $("#login-dialog").css("display");
    	if(display != "none") {
    		displayLoginDialog(false);
    	} else {
//    		if(path === "login") {
//    			window.location.href = "/index.html";
//    		}
    	}
    	
   }
});
