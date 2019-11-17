/*
 * 根据服务名称查询产品列表
 */
 $(".search-btn").on("click",function(){
    var value=$(".searchlist").val();
	var providerid = sessionStorage.getItem("providerid");
	
			$.ajax({
				type:"get",
				url:"/providerProdut/providerprodutbylike",
				data:{
					providerid:providerid,
					service_name:value, 
				},
				dataType:"json",
				success:function(data){
					console.log("成功返回的数据",data);	
					var providerProdutList = data.providerProdutByLike;
					$("#providerprodutlist").html("");
					var txt = "";
					for(var i = 0; i < providerProdutList.length; i ++){
						txt += `<tr>
							<td>${providerProdutList[i].serviceName}</td>
							<td>${providerProdutList[i].serviceInfo}</td>
							<td>${providerProdutList[i].price}</td>`
							if(providerProdutList[i].status == 1){
								txt += `<td><span class="up-line-mark up-line-mark-red">在线</span></td>
                        <td><span class="handle-btn"><i class="fa fa-arrow-down fa-fw" onclick="change(${providerProdutList[i].id})"></i>下线</span></td>`
							} else{
								txt += `<td><span class="down-line-mark down-line-mark-orange"  >下线</span></td>
                        <td>
                            <span class="handle-btn"><i class="fa fa-edit fa-fw"></i>编辑</span>
                            <span class="handle-btn"><i class="fa fa-close fa-fw"></i>删除</span>
                            <span class="handle-btn"><i class="fa fa-arrow-up fa-fw" onclick="change(${providerProdutList[i].id})"></i>上线</span>
                        </td>`
							}	
						txt += `</tr>`
						}			
					console.log(txt);			
					$("#providerprodutlist").html(txt);
				},
				error:function(data){
					console.log("失败后返回的数据",data);
				}
		})
})

$(".user-arrow-down").on("click",function(){
    if($(".dropdown").is(":hidden")){
        $(".dropdown").show();
 }else{
       $(".dropdown").hide();
 }
})  
$(".add-product-action").on("click", function(event){
    $(".masking").show();
})
$(".save").on("click", function(event){
	var providerid = sessionStorage.getItem("providerid");
    var serviceName = $(".service_name").val();
    var serviceInfo = $(".service_info").val();
    var price = $(".price").val();
    $.ajax({
    	type:"post",
    	url:"/providerProdut/providerprodutInsert",
    	data:{
    		serviceName:serviceName,
    		serviceInfo:serviceInfo,
    		price:price,
    		providerid:providerid,
    	},
    	dataType:"json",
    	success:function(data){
			console.log("成功返回的数据",data);	
			if(data.mem == "添加成功"){
				$.ajax({
					type:"get",
					url:"/providerProdut/providerprodutlistbyid",
					data:{
						providerid:providerid,
					},
					dataType:"json",
					
					success:function(data){
						console.log("成功返回的数据",data);
						
						
						var providerProdutList = data.providerProdutList;
						$("#providerprodutlist").html("");
						var txt = "";
						for(var i = 0; i < providerProdutList.length; i ++){
							txt += `<tr>
								<td>${providerProdutList[i].serviceName}</td>
								<td>${providerProdutList[i].serviceInfo}</td>
								<td>${providerProdutList[i].price}</td>`
								if(providerProdutList[i].status == 1){
									txt += `<td><span class="up-line-mark up-line-mark-red">在线</span></td>
	                        <td><span class="handle-btn"><i class="fa fa-arrow-down fa-fw" onclick="change(${providerProdutList[i].id})"></i>下线</span></td>`
								} else{
									txt += `<td><span class="down-line-mark down-line-mark-orange"  >下线</span></td>
	                        <td>
	                            <span class="handle-btn"><i class="fa fa-edit fa-fw"></i>编辑</span>
	                            <span class="handle-btn"><i class="fa fa-close fa-fw"></i>删除</span>
	                            <span class="handle-btn"><i class="fa fa-arrow-up fa-fw" onclick="change(${providerProdutList[i].id})"></i>上线</span>
	                        </td>`
								}	
							txt += `</tr>`
							}
						
						console.log(txt);
						
						$("#providerprodutlist").html(txt);
					},
					error:function(data){
						console.log("失败后返回的数据",data);
					}
				})
				
				 
			}else{
				alert(data.mem);
			}	
		}
    })
     $(".masking").hide();
    console.log("保存");
})
$(".cancel").on("click", function(event){
    $(".masking").hide();
    console.log("取消");
})
$(function(){
		$("#username").html("");
		var txt="";
		txt += sessionStorage.getItem("providername")
		$("#username").append(txt);
})

function change(produtid){
	console.log("改变状态", produtid);
	 $.ajax({
			type:"get",
			url:"/providerProdut/providerprodutchange",
			data:{
				produtid:produtid,
			}, 
			dataType:"json",
			success:function(data){
				console.log("成功返回的数据",data);
				var providerid = sessionStorage.getItem("providerid");
				if(data.code == 1){
					$.ajax({
						type:"get",
						url:"/providerProdut/providerprodutlist",
						data:{
							providerid:providerid,
						},
						dataType:"json",
						
						success:function(data){
							console.log("成功返回的数据",data);
							
							var providerProdutList = data.providerProdutList;
							$("#providerprodutlist").html("");
							var txt = "";
							for(var i = 0; i < providerProdutList.length; i ++){
								txt += `<tr>
									<td>${providerProdutList[i].serviceName}</td>
									<td>${providerProdutList[i].serviceInfo}</td>
									<td>${providerProdutList[i].price}</td>`
									if(providerProdutList[i].status == 1){
										txt += `<td><span class="up-line-mark up-line-mark-red">在线</span></td>
		                        <td><span class="handle-btn"><i class="fa fa-arrow-down fa-fw" onclick="change(${providerProdutList[i].id})"></i>下线</span></td>`
									} else{
										txt += `<td><span class="down-line-mark down-line-mark-orange"  >下线</span></td>
		                        <td>
		                            <span class="handle-btn"><i class="fa fa-edit fa-fw"></i>编辑</span>
		                            <span class="handle-btn"><i class="fa fa-close fa-fw"></i>删除</span>
		                            <span class="handle-btn"><i class="fa fa-arrow-up fa-fw" onclick="change(${providerProdutList[i].id})"></i>上线</span>
		                        </td>`
									}	
								txt += `</tr>`
								}
							
							console.log(txt);
							
							$("#providerprodutlist").html(txt);
						},
						error:function(data){
							console.log("失败后返回的数据",data);
						}
					})
				}
			}
	 })	
}

$(function(){
	var providerid = sessionStorage.getItem("providerid");
	
			$.ajax({
				type:"get",
				url:"/providerProdut/providerprodutlistbyid",
				data:{
					providerid:providerid,
				},
				dataType:"json",
				success:function(data){
					console.log("成功返回的数据",data);	
					var providerProdutList = data.providerProdutList;
					$("#providerprodutlist").html("");
					var txt = "";
					for(var i = 0; i < providerProdutList.length; i ++){
						txt += `<tr>
							<td>${providerProdutList[i].serviceName}</td>
							<td>${providerProdutList[i].serviceInfo}</td>
							<td>${providerProdutList[i].price}</td>`
							if(providerProdutList[i].status == 1){
								txt += `<td><span class="up-line-mark up-line-mark-red">在线</span></td>
                        <td><span class="handle-btn"><i class="fa fa-arrow-down fa-fw" onclick="change(${providerProdutList[i].id})"></i>下线</span></td>`
							} else{
								txt += `<td><span class="down-line-mark down-line-mark-orange"  >下线</span></td>
                        <td>
                            <span class="handle-btn"><i class="fa fa-edit fa-fw"></i>编辑</span>
                            <span class="handle-btn"><i class="fa fa-close fa-fw"></i>删除</span>
                            <span class="handle-btn"><i class="fa fa-arrow-up fa-fw" onclick="change(${providerProdutList[i].id})"></i>上线</span>
                        </td>`
							}	
						txt += `</tr>`
						}			
					console.log(txt);			
					$("#providerprodutlist").html(txt);
				},
				error:function(data){
					console.log("失败后返回的数据",data);
				}
			})
		})