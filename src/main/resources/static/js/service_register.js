$(".login-btn").on("click", function(){
	var id=$(".p_id").val();
	var cellphone=$(".p_cellphone").val();
	var password=$(".p_password").val();
	console.log(id,cellphone,password);
	$.ajax({
		type:"post",
		url:"/membercontroller/providerregister",
		data:{
			id:id,
			cellphone:cellphone,
			password:password,
		},
		dataType:"json",
		success:function(data){
			console.log("成功后返回的数据",data);
			alert(data.msg);
			location.href="redirect?page=service_login";
			},
			error:function(data){
				console.log("失败后返回的数据",data);
			location.href="redirect?page=service_register";
			}
			
        })
})
