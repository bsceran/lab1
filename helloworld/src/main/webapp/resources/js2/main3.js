jQuery(document).ready(function() {
    $('ul.sf-menu').sooperfish();
    $('.top').click(function() {$('html, body').animate({scrollTop:0}, 'fast'); return false;});
    $("#header").load("header.html"); 
    $("#footer").load("footer.html");
    $("#registerwindow_").load("register.html");
  });

