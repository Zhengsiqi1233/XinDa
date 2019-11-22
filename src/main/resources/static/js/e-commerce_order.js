$(function(){
		$("#username").html("");
		var txt="";
		txt += sessionStorage.getItem("membername")
		$("#username").append(txt);
})
$(function(){
	var memberid = sessionStorage.getItem("memberid");
	var membername = sessionStorage.getItem("membername");
		$("#userinfo").html("");
		var txt="";
		txt += `<img src="/member/headImg?id=${memberid}" onerror="defaultImg(this)" style="height:90px; width:100px;"/>
<script>
	function defaultImg(img){
		img.src="/images/user-lg.png";
	}
</script>
                <p>${membername}</p>`
		$("#userinfo").append(txt);
})
$(function(){
	var memberid = sessionStorage.getItem("memberid");
	$.ajax({
		type:"get",
		url:"/cart/cartall",
		data:{
			memberid:memberid,
		},
		dataType:"json",
		success:function(data){
			console.log("成功返回的数据",data);
			var all = data.all;
			$("#all").html("");
			var txt="";
			txt += all
			$("#all").append(txt);
		},
		error:function(data){
			console.log("失败后返回的数据",data);
		}
	})
	
})
$(function(){
	var providerid = sessionStorage.getItem("memberid");
	$.ajax({
		type:"get",
		url:"/business/bussinessorderlist",
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
                            <li>${bussinessOrderList[i].produt.providerName}</li>
                            <li>${bussinessOrderList[i].produt.serviceName}*${bussinessOrderList[i].orderNum}</li>
                        </ul>
                        <p>${bussinessOrderList[i].produt.price}</p>
                        <p>${bussinessOrderList[i].orderNum}</p>
                    </li>
                    <li class="font-aqua">¥${bussinessOrderList[i].orderSum}</li>`
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
	console.log("删除",business_no);
	 $.ajax({
			type:"post",
			url:"/business/deleteorder",
			data:{
				business_no:business_no,
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
						url:"/business/bussinessorderlist",
						
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
				                            <li>${bussinessOrderList[i].provider.name}</li>
				                            <li>${bussinessOrderList[i].produt.serviceName}*${bussinessOrderList[i].orderNum}</li>
				                        </ul>
				                        <p>${bussinessOrderList[i].produt.price}</p>
				                        <p>${bussinessOrderList[i].orderNum}</p>
				                    </li>
				                    <li class="font-aqua">¥${bussinessOrderList[i].orderSum}</li>`
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
    location.href="redirect?page=e-commerce_settlement";
    sessionStorage.setItem("business_no",business_no);

		

}