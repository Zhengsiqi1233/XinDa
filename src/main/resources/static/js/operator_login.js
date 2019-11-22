$(".login-btn").on("click", function(){
	var cellphone = $(".cellphone").val();
    var password = $(".password").val(); 
    var inputCode = $(".input-code").val();
    console.log(cellphone, password);
    
    $.ajax({
    	type:"post",
    	url:"/user/userlogin",
    	data:{
    		cellphone:cellphone,
    		password:password,
    		inputCode:inputCode,
    		
    	},
    	dataType:"json",
    	success:function(data){
			console.log("成功返回的数据",data);	
			if(data.mem == "登陆成功"){
				 location.href="redirect?page=operator_product";
				 
//				 sessionStorage.setItem("xxx", data.list);
				 sessionStorage.setItem("userid",data.userid);
				 sessionStorage.setItem("username", data.username);
				 
			}else{
				alert(data.mem);
			}	
		}
    })
})