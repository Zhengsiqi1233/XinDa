$(function(){
	var memberid = sessionStorage.getItem("memberid");
	var sum = sessionStorage.getItem("sum");
	console.log("查询该用户的订单",memberid);

	$.ajax({
		type:"get",
		url:"/business/bussinessorderlist",
		dataType:"json",
		data:{
			memberid:memberid,
		},
		success:function(data){
			console.log("成功返回的数据",data);
			var bussinessOrderList = data.bussinessOrderList;
			$("#bussinessorderlist").html("");
			var txt = "";
			for(var i = 0; i < bussinessOrderList.length; i ++){
				txt += `<div class="orders">
                <div class="order-num">
                                  订单号：${bussinessOrderList[i].businessNo} 下单时间：${format(bussinessOrderList[i].createTime)}</div>
                <ul class="order-details">
                    <li>
                        <img src="./images/user-lg.png" alt="图片">
                        <ul>
                            <li>${bussinessOrderList[i].providerName}</li>
                            <li>${bussinessOrderList[i].orderInfo}</li>
                        </ul>
                        <p>${bussinessOrderList[i].orderSum}</p>
                        <p>${bussinessOrderList[i].orderNum}</p>
                    </li>
                    <li class="font-aqua">¥${sum}</li>`
					if(bussinessOrderList[i].status == 1){
						txt +=`<li class="font-aqua">已付款</li>
						 <li>交易完成</li>
						 </ul>`
					}else{
						txt +=`<li class="font-aqua">等待买家付款</li>
                        <li>
                            <p onclick="pay('${bussinessOrderList[i].businessNo}')">付款</p>
                            <button onclick="delUser('${bussinessOrderList[i].businessNo}')">删除订单</button>
                        </li>
                        </ul>`
					}
						
            txt += `</div>`
				}
			console.log(txt);
			// var tbody = $("<tbody></tbody>").html(txt);
			$("#bussinessorderlist").html(txt);
		},
		error:function(data){
			console.log("失败后返回的数据",data);
		}
	})
	
})
function format(time){
	var date = new Date(time);
	return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
}

function delUser(business_no){
	var sum = sessionStorage.getItem("sum");

	console.log("删除",business_no);
	 $.ajax({
			type:"post",
			url:"/business/deleteorder",
			data:{
				business_no:business_no,
			}, 
			dataType:"json",
			success:function(data){
				console.log("成功返回的数据",data);
				if(data.code == 1){
					$.ajax({
						type:"get",
						url:"/business/bussinessorderlist",
						data:{
							business_no:business_no,
						}, 
						dataType:"json",
						success:function(data){
							console.log("成功返回的数据",data);
							
							var bussinessOrderList = data.bussinessOrderList;
							$("#bussinessorderlist").html("");
							var txt = "";
							for(var i = 0; i < bussinessOrderList.length; i ++){
								txt += `<div class="orders">
				                <div class="order-num">
				                                  订单号：${bussinessOrderList[i].businessNo} 下单时间：${format(bussinessOrderList[i].createTime)}</div>
				                <ul class="order-details">
				                    <li>
				                        <img src="./images/user-lg.png" alt="图片">
				                        <ul>
				                            <li>${bussinessOrderList[i].providerName}</li>
				                            <li>${bussinessOrderList[i].orderInfo}</li>
				                        </ul>
				                        <p>${bussinessOrderList[i].createTime}</p>
				                        <p>${bussinessOrderList[i].orderNum}</p>
				                    </li>
				                    <li class="font-aqua">¥${sum}</li>`
									if(bussinessOrderList[i].status == 1){
										txt +=`<li class="font-aqua">已付款</li>
										 <li>交易完成</li>
										 </ul>`
									}else{
										txt +=`<li class="font-aqua">等待买家付款</li>
				                        <li>
				                            <p onclick="pay('${bussinessOrderList[i].businessNo}')">付款</p>
				                            <button onclick="delUser('${bussinessOrderList[i].businessNo}')">删除订单</button>
				                        </li>
				                        </ul>`
									}
										
				            txt += `</div>`
								}
							console.log(txt);
							// var tbody = $("<tbody></tbody>").html(txt);
							$("#bussinessorderlist").html(txt);
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

$(".search-product").on("click", function(){
    $(".search-product").addClass("font-aqua");
    $(".search-service").removeClass("font-aqua");
})
$(".search-service").on("click", function(){
    $(".search-service").addClass("font-aqua");
    $(".search-product").removeClass("font-aqua");
})

$(".banner a").on("click", function(event){
    $(".banner a").removeClass("border-b");
    $(event.target).addClass("border-b");
})

$(".user-action a").on("click", function(event){
    $(".user-action a").removeClass("bg-gray");
    $(event.target).addClass("bg-gray");
})
function pay(business_no){
	console.log("付款",business_no);
    location.href="redirect?page=e-commerce_settlement2";
    sessionStorage.setItem("business_no",business_no);

		

}