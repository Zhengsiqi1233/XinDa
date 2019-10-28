$(".login-btn").on("click", function(){
	var cellphone = $(".cellphone").val();
	var password = $(".password").val();
	var queren_password = $(".queren_password").val();
	var inputCode = $(".input-code").val();
	if(password == queren_password){
		console.log(cellphone, inputCode, password, queren_password);
		 $.ajax({
		    	type:"post",
		    	url:"/member/memberfind",
		    	data:{
		    		cellphone:cellphone,
		    		password:password,
		    		queren_password:queren_password,
		    		inputCode:inputCode,
		    	},
		    	dataType:"json",
		    	success:function(data){
					console.log("成功返回的数据",data);					
					if(data.mem == "修改密码成功"){
						 location.href="redirect?page=e-commerce_login";
					}else{
						alert(data.mem);
					}				
				}
		    })
	}else{
		alert("密码不一致，请重新输入！");
	}	
})