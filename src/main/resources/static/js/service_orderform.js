$(".user-arrow-down").on("click",function(){
    if($(".dropdown").is(":hidden")){
        $(".dropdown").show();
 }else{
       $(".dropdown").hide();
 }
})
$(".order1").on("click", function(){
    /*$(".main-content").show();
    $("table").show();
    $(".main-pagination").show();
    $(".main-sercive").hide();*/
    $(".order1").addClass("border-red");
    $(".order2").removeClass("border-red");
    $(".main-top li").eq(3).text("正常用户");
})
$(".order2").on("click", function(){
   /* $(".main-content").hide();
    $("table").hide();
    $(".main-pagination").hide();
    $(".main-sercive").show();*/
    $(".order2").addClass("border-red");
    $(".order1").removeClass("border-red");
    $(".main-top li").eq(3).text("停用用户");
})
$(".order3").on("click", function(){
    $(".main-top li").eq(3).text("未通过用户");
})
<<<<<<< HEAD

=======
>>>>>>> ac7810fbdfc531926d55c23bf71380f621c03f9b
$(function(){
		$("#username").html("");
		var txt="";
		txt += sessionStorage.getItem("providername")
		$("#username").append(txt);
})

$(function(){
		$("#username").html("");
		var txt="";
		txt += sessionStorage.getItem("providername")
		$("#username").append(txt);
})
$(function(){
	var providerid = sessionStorage.getItem("providerid");
		$("#img").html("");
		var txt="";
		txt += `<img src="/provider/headImg?id=${providerid}" onerror="defaultImg(this)"/>`
		$("#img").append(txt);
})
$(function(){
	var providerid = sessionStorage.getItem("providerid");
	function format(time){
		var date = new Date(time);
		return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	}

			$.ajax({
				type:"get",
				url:"/business/businessorderlistbyid", 
				data:{
					providerid:providerid,
				},
				dataType:"json",
				
				success:function(data){
					console.log("成功返回的数据",data);
					
					var businessOrderList = data.businessOrderList;
					$("#businessorderlist").html("");
					var txt = "";
					for(var i = 0; i < businessOrderList.length; i ++){
						txt += `<tr>
							<td>${businessOrderList[i].businessNo}</td>
							<td>${businessOrderList[i].orderInfo}</td>
							<td>${businessOrderList[i].member.name}</td>
							<td>${businessOrderList[i].member.cellphone}</td>
							<td>${businessOrderList[i].orderNum}</td>
							<td>${businessOrderList[i].orderSum}</td>
							<td>${format(businessOrderList[i].createTime)}</td>
							<td>
                            	<span class="handle-btn"><i class="fa fa-edit fa-fw"></i>详情</span>
                           </td>
						</tr>`
						}
					console.log(txt);
					
					$("#businessorderlist").html(txt);
				},
				error:function(data){
					console.log("失败后返回的数据",data);
				}
			})
			
})
/*
 * 服务中的所有正在进行中的订单展示
 */
$(".businessordercommon").on("click",function(){
	var providerid = sessionStorage.getItem("providerid");
	function format(time){
		var date = new Date(time);
		return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	}

			$.ajax({
				type:"get",
				url:"/business/businessorderlistbyid", 
				data:{
					providerid:providerid,
				},
				dataType:"json",
				
				success:function(data){
					console.log("成功返回的数据",data);
					
					var businessOrderList = data.businessOrderList;
					$("#businessorderlist").html("");
					var txt = "";
					for(var i = 0; i < businessOrderList.length; i ++){
						txt += `<tr>
							<td>${businessOrderList[i].businessNo}</td>
							<td>${businessOrderList[i].orderInfo}</td>
							<td>${businessOrderList[i].member.name}</td>
							<td>${businessOrderList[i].member.cellphone}</td>
							<td>${businessOrderList[i].orderNum}</td>
							<td>${businessOrderList[i].orderSum}</td>
							<td>${format(businessOrderList[i].createTime)}</td>
							<td>
                            	<span class="handle-btn"><i class="fa fa-edit fa-fw"></i>详情</span>
                           </td>
						</tr>`
						}
					console.log(txt);
					
					$("#businessorderlist").html(txt);
				},
				error:function(data){
					console.log("失败后返回的数据",data);
				}
		})
		$(".search-btn").on("click",function(){
            	var value=$(".searchlist").val();
            	/*var providerid = sessionStorage.getItem("providerid");
            	function format(time){
            		var date = new Date(time);
            		return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
            	}*/

            			$.ajax({
            				type:"get",
            				url:"/business/bussinessorderlike", 
            				data:{
            					providerid:providerid,
            					order_info:value,
            				},
            				dataType:"json",
            				
            				success:function(data){
            					console.log("成功返回的数据",data);
            					
            					var businessOrderList = data.bussinessOrderLike;
            					$("#businessorderlist").html("");
            					var txt = "";
            					for(var i = 0; i < businessOrderList.length; i ++){
            						txt += `<tr>
            							<td>${businessOrderList[i].businessNo}</td>
            							<td>${businessOrderList[i].orderInfo}</td>
            							<td>${businessOrderList[i].member.name}</td>
            							<td>${businessOrderList[i].member.cellphone}</td>
            							<td>${businessOrderList[i].orderNum}</td>
            							<td>${businessOrderList[i].orderSum}</td>
            							<td>${format(businessOrderList[i].createTime)}</td>
            							<td>
                                        	<span class="handle-btn"><i class="fa fa-edit fa-fw"></i>详情</span>
                                       </td>
            						</tr>`
            						}
            					console.log(txt);
            					
            					$("#businessorderlist").html(txt);
            				},
            				error:function(data){
            					console.log("失败后返回的数据",data);
            				}
            		})
            })
		
})
/*
 * 查询已经停用的订单信息
 */
$(".businessorderstop").on("click",function(){
	var providerid = sessionStorage.getItem("providerid");
	function format(time){
		var date = new Date(time);
		return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	}

			$.ajax({
				type:"get",
				url:"/business/businessorderlistbyidstop", 
				data:{
					providerid:providerid,
				},
				dataType:"json",
				
				success:function(data){
					console.log("成功返回的数据",data);
					
					var businessOrderList = data.businessOrderListStop;
					$("#businessorderlist").html("");
					var txt = "";
					for(var i = 0; i < businessOrderList.length; i ++){
						txt += `<tr>
							<td>${businessOrderList[i].businessNo}</td>
							<td>${businessOrderList[i].orderInfo}</td>
							<td>${businessOrderList[i].member.name}</td>
							<td>${businessOrderList[i].member.cellphone}</td>
							<td>${businessOrderList[i].orderNum}</td>
							<td>${businessOrderList[i].orderSum}</td>
							<td>${format(businessOrderList[i].createTime)}</td>
							<td>
                            	<span class="handle-btn"><i class="fa fa-edit fa-fw"></i>详情</span>
                           </td>
						</tr>`
						}
					console.log(txt);
					
					$("#businessorderlist").html(txt);
				},
				error:function(data){
					console.log("失败后返回的数据",data);
				}
		})
<<<<<<< HEAD

=======
>>>>>>> ac7810fbdfc531926d55c23bf71380f621c03f9b
		$(".search-btn").on("click",function(){
            	var value=$(".searchlist").val();
            	/*var providerid = sessionStorage.getItem("providerid");
            	function format(time){
            		var date = new Date(time);
            		return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
            	}*/

            			$.ajax({
            				type:"get",
            				url:"/business/bussinessorderlikestop", 
            				data:{
            					providerid:providerid,
            					order_info:value,
            				},
            				dataType:"json",
            				
            				success:function(data){
            					console.log("成功返回的数据",data);
            					
            					var businessOrderList = data.bussinessOrderLikeStop;
            					$("#businessorderlist").html("");
            					var txt = "";
            					for(var i = 0; i < businessOrderList.length; i ++){
            						txt += `<tr>
            							<td>${businessOrderList[i].businessNo}</td>
            							<td>${businessOrderList[i].orderInfo}</td>
            							<td>${businessOrderList[i].member.name}</td>
            							<td>${businessOrderList[i].member.cellphone}</td>
            							<td>${businessOrderList[i].orderNum}</td>
            							<td>${businessOrderList[i].orderSum}</td>
            							<td>${format(businessOrderList[i].createTime)}</td>
            							<td>
                                        	<span class="handle-btn"><i class="fa fa-edit fa-fw"></i>详情</span>
                                       </td>
            						</tr>`
            						}
            					console.log(txt);
            					
            					$("#businessorderlist").html(txt);
            				},
            				error:function(data){
            					console.log("失败后返回的数据",data);
            				}
            		})
            })
<<<<<<< HEAD
})
		

=======
})
>>>>>>> ac7810fbdfc531926d55c23bf71380f621c03f9b
