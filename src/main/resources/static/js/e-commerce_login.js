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

				 sessionStorage.setItem("memberid",data.memberid);
				 sessionStorage.setItem("membername",data.membername);

=======
				 //sessionStorage.setItem("memberid",data.memberid);
				
				 sessionStorage.setItem("memberid",data.memberid);
				 sessionStorage.setItem("membername",data.membername);
>>>>>>> ac7810fbdfc531926d55c23bf71380f621c03f9b
			}else{
				alert(data.mem);
			}	
		}
    })
})
