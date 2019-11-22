$(function(){
	var xxx = sessionStorage.getItem("xxx");
	console.log(xxx);
	$.ajax({
		type:"get",
		url:"/providerProdut/providerprodutlist",
		dataType:"json",
		data:{
			pagenum:20,
			pagesize:1,
		},
		success:function(data){
			console.log("成功返回的数据",data);
			var providerProdutList = data.providerProdutList;
			$("#providerprodutlist").html("");
			var txt = "";
			for(var i = 0; i < providerProdutList.length; i ++){
				txt += `<tr> 
				
				    <td><input type="checkbox" class="checkbox"></td>
					<td>${providerProdutList[i].serviceName}</td>
					<td>${providerProdutList[i].serviceContent}</td>
					<td>¥${providerProdutList[i].price}</td>
                        <td><span class="up-line-mark up-line-mark-red">在线</span></td>	`
                     if(providerProdutList[i].status == 1){
								txt += `<td><span class="up-line-mark up-line-mark-red">在线</span></td>
                        <td><span class="handle-btn"><i class="fa fa-arrow-down fa-fw" onclick="change(${providerProdutList[i].id})"></i>下线</span></td>`
							} else{
								txt += `<td><span class="down-line-mark down-line-mark-orange"  >下线</span></td>
                        <td>
                            <span class="handle-btn"><i class="fa fa-edit fa-fw"></i>编辑</span>
                            <span class="handle-btn"><i class="fa fa-close fa-fw" onclick="del(${providerProdutList[i].id})"></i>删除</span>
                            <span class="handle-btn"><i class="fa fa-arrow-up fa-fw" onclick="change(${providerProdutList[i].id})"></i>上线</span>
                        </td>`
							}
									txt += `</tr>`
				}
//			console.log(txt);
		
			$("#providerprodutlist").html(txt);
		},
		error:function(data){
			console.log("失败后返回的数据",data);
		}
	})
	
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
						dataType:"json",
						data:{
							pagenum:20,
							pagesize:1,
						},
						success:function(data){
							console.log("成功返回的数据",data);
							var providerProdutList = data.providerProdutList;
							$("#providerprodutlist").html("");
							var txt = "";
							for(var i = 0; i < providerProdutList.length; i ++){
								txt += `<tr> 
								
								    <td><input type="checkbox" class="checkbox"></td>
									<td>${providerProdutList[i].serviceName}</td>
									<td>${providerProdutList[i].serviceContent}</td>
									<td>¥${providerProdutList[i].price}</td>
				                        <td><span class="up-line-mark up-line-mark-red">在线</span></td>	`
				                     if(providerProdutList[i].status == 1){
												txt += `<td><span class="up-line-mark up-line-mark-red">在线</span></td>
				                        <td><span class="handle-btn"><i class="fa fa-arrow-down fa-fw" onclick="change(${providerProdutList[i].id})"></i>下线</span></td>`
											} else{
												txt += `<td><span class="down-line-mark down-line-mark-orange"  >下线</span></td>
				                        <td>
				                            <span class="handle-btn"><i class="fa fa-edit fa-fw"></i>编辑</span>
				                            <span class="handle-btn"><i class="fa fa-close fa-fw" onclick="del(${providerProdutList[i].id})"></i>删除</span>
				                            <span class="handle-btn"><i class="fa fa-arrow-up fa-fw" onclick="change(${providerProdutList[i].id})"></i>上线</span>
				                        </td>`
											}
													txt += `</tr>`
								}
//							console.log(txt);
						
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
function del(id){
	console.log("删除",id);
	 $.ajax({
			type:"post",
			url:"/providerProdut/providerprodutdelete",
			data:{
				id:id,
				//name:value, 
    			//pagenum:4,
    			//pagesize:1,
			}, 
			dataType:"json",
			success:function(data){
				console.log("成功返回的数据",data);
				if(data.code == 1){
					$.ajax({
						type:"get",
						url:"/providerProdut/providerprodutlist",
						dataType:"json",
						data:{
							pagenum:20,
							pagesize:1,
						},
						success:function(data){
							console.log("成功返回的数据",data);
							var providerProdutList = data.providerProdutList;
							$("#providerprodutlist").html("");
							var txt = "";
							for(var i = 0; i < providerProdutList.length; i ++){
								txt += `<tr> 
								
								    <td><input type="checkbox" class="checkbox"></td>
									<td>${providerProdutList[i].serviceName}</td>
									<td>${providerProdutList[i].serviceContent}</td>
									<td>¥${providerProdutList[i].price}</td>
				                        <td><span class="up-line-mark up-line-mark-red">在线</span></td>	`
				                     if(providerProdutList[i].status == 1){
												txt += `<td><span class="up-line-mark up-line-mark-red">在线</span></td>
				                        <td><span class="handle-btn"><i class="fa fa-arrow-down fa-fw" onclick="change(${providerProdutList[i].id})"></i>下线</span></td>`
											} else{
												txt += `<td><span class="down-line-mark down-line-mark-orange"  >下线</span></td>
				                        <td>
				                            <span class="handle-btn"><i class="fa fa-edit fa-fw"></i>编辑</span>
				                            <span class="handle-btn"><i class="fa fa-close fa-fw" onclick="del(${providerProdutList[i].id})"></i>删除</span>
				                            <span class="handle-btn"><i class="fa fa-arrow-up fa-fw" onclick="change(${providerProdutList[i].id})"></i>上线</span>
				                        </td>`
											}
													txt += `</tr>`
								}
//							console.log(txt);
						
							$("#providerprodutlist").html(txt);
						},
						error:function(data){
							console.log("失败后返回的数据",data);
						}
					})
				}
			},
			error:function(data){
				console.log("失败后返回的数据",data);
			}
		})
}
$(function(){
	$("#username").html("");
	var txt="";
	txt += sessionStorage.getItem("username")
	$("#username").append(txt);
})
$(".user-arrow-down").on("click",function(){
    if($(".dropdown").is(":hidden")){
        $(".dropdown").show();
 }else{
       $(".dropdown").hide();
 }
})  