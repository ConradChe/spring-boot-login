window.onload=function(){
    var oForm=document.getElementById('form-control');
    var aLabel=oForm.getElementsByTagName('label');
    var aInput=oForm.getElementsByTagName('input')

    for(var i=0;i<aLabel.length;i++){
        aInput[i].index=i;
        aLabel[i].onclick=function(){
            for(var i=0;i<aLabel.length;i++){
                aLabel[i].className='';
            }
            this.className='active';
        }
        aInput[i].onclick=function(){
            for(var i=0;i<aLabel.length;i++){
                aLabel[i].className='';
            }
            aLabel[this.index].className='active';
        }
    }
}

function checkemail() {
    if($("#email").val() != ""){
        $.get("checkemail",{name:$("#email").val()},
            function (data) {
                $("#errorMessage").html(data);
            }
        )
    }else {
        $("#errorMessage").html("邮箱为空");
    }
}
$(function(){
    $(".register").submit(function () {
        if (0==$("#email").val().length){
            $("#errorMessage").html("请输入邮箱");
            return false;
        }
        if (0==$("#password").val().length){
            $("#errorMessage").html("请输入密码");
            return false;
        }
        if (0==$("#vpassword").val().length){
            $("#errorMessage").html("请再次输入密码");
            return false;
        }
        if($("#vpassword").val() != $("#password").val()){
            $("#errorMessage").html("重复密码不一致");
            return false;
        }
        $("#errorMessage").html("");
        return true;
    });
    $('#clear').click(function () {
        $("#email").val("");
        $("#password").val("");
        $("#vpassword").val("");
    });
});