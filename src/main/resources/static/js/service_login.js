$(".login-btn").on("click", function(){
	var cellphone = $(".cellphone").val();
    var password = $(".password").val(); 
    var inputCode = $(".input-code").val();
    console.log(cellphone, password);
    $.ajax({
    	type:"post",
    	url:"/provider/providerlogin",
    	data:{
    		cellphone:cellphone,
    		password:password,
    		inputCode:inputCode,
    	},
    	dataType:"json",
    	success:function(data){
			console.log("成功返回的数据",data);	
			if(data.mem == "登陆成功"){
				 location.href="redirect?page=service_product";
				 sessionStorage.setItem("providerid",data.providerid);
				 sessionStorage.setItem("providername",data.providername);
				
				 
			}else{
				alert(data.mem);
			}	
		}
    })
})