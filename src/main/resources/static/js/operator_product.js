$(function(){
	$.ajax({
		type:"get",
		url:"/providerproductcontroller/providerprodutlist",
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
                        <td><span class="up-line-mark up-line-mark-red">在线</span></td>
                        <td><span class="down-line-mark down-line-mark-orange">下线</span></td>
                        <td>
                            <button class="handle-btn"><i class="fa fa-edit fa-fw"></i>编辑</button>
                            <button onclick="delUser('${providerProdutList[i].id}')" class="handle-btn"><i class="fa fa-close fa-fw"></i>删除</button>
                            <button class="handle-btn"><i class="fa fa-arrow-up fa-fw"></i>上线</button>
                        </td>
					
				</tr>`
				}
			console.log(txt);
			// var tbody = $("<tbody></tbody>").html(txt);
			$("#providerprodutlist").html(txt);
		},
		error:function(data){
			console.log("失败后返回的数据",data);
		}
	})
	
})
function delUser(id){
	console.log("删除",id);
	 $.ajax({
			type:"post",
			url:"/providerproductcontroller/providerprodutdelete",
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
						url:"/providerproductcontroller/providerprodutlist",
						
						dataType:"json",
						success:function(data){
							console.log("成功返回的数据",data);
							
							var providerProdutList=data.providerProdutList;
							$("#providerprodutlist").html("");
							var txt="";
							for(var i = 0; i < providerProdutList.length; i ++){
								txt += `<tr>
								    <td><input type="checkbox" class="checkbox"></td>
									<td>${providerProdutList[i].serviceName}</td>
									<td>${providerProdutList[i].serviceContent}</td>
									<td>${providerProdutList[i].price}</td>
									<td></td>
				                        <td><span class="down-line-mark down-line-mark-orange">下线</span></td>
				                        <td>
				                            <button class="handle-btn"><i class="fa fa-edit fa-fw"></i>编辑</button>
				                            <button onclick="delUser('${providerProdutList[i].id}')" class="handle-btn"><i class="fa fa-close fa-fw"></i>删除</button>
				                            <button class="handle-btn"><i class="fa fa-arrow-up fa-fw"></i>上线</button>
				                        </td>
								</tr>`;				
							}
							console.log(txt);
							//var tbody = $("<tbody></tbody>").html(txt);
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

$(".user-arrow-down").on("click",function(){
    if($(".dropdown").is(":hidden")){
        $(".dropdown").show();
 }else{
       $(".dropdown").hide();
 }
})  