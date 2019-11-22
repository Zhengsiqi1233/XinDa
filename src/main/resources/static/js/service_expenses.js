$(".user-arrow-down").on("click",function(){
    if($(".dropdown").is(":hidden")){
        $(".dropdown").show();
 }else{
       $(".dropdown").hide();
 }
})
$(".order1").on("click", function(){
    $(".main-content").show();
    $(".returns_detailed").hide();
    $(".order1").addClass("border-red");
    $(".order2").removeClass("border-red");
})
$(".order2").on("click", function(){
    $(".main-content").hide();
    $(".returns_detailed").show();
    $(".order2").addClass("border-red");
    $(".order1").removeClass("border-red");
})
$(function(){
		$("#username").html("");
		var txt="";
		txt += sessionStorage.getItem("providername")
		$("#username").append(txt);
})
/*$(function(){
	var providerid = sessionStorage.getItem("providerid");
		$("#img").html("");
		var txt="";
		txt += `<img src="/provider/headImg?id=${providerid}" onerror="defaultImg(this)"/>`
		$("#img").append(txt);
})*/