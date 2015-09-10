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