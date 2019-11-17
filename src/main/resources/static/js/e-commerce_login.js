$(".login-btn").on("click", function(){
    var cellphone = $(".cellphone").val();
    var password = $(".password").val(); 
    var inputCode = $(".input-code").val();
    console.log(cellphone, password);
    $.ajax({
    	type:"post",
    	url:"/member/memberlogin",
    	data:{
    		cellphone:cellphone,
    		password:password,
    		inputCode:inputCode,
    	},
    	dataType:"json",
    	success:function(data){
			console.log("成功返回的数据",data);	
			if(data.mem == "登陆成功"){
				 location.href="redirect?page=e-commerce_product";
<<<<<<< HEAD
				 //sessionStorage.setItem("memberid",data.memberid);
				
=======
				 sessionStorage.setItem("memberid",data.memberid);
				 sessionStorage.setItem("membername",data.membername);
>>>>>>> 80103050b21413fcf7364418868f0a9ec951a22b
			}else{
				alert(data.mem);
			}	
		}
    })
})
