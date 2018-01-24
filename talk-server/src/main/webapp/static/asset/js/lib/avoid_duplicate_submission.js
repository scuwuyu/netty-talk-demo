function getToken(){
    $.ajax({
        type: "get",
        //TODO: change to the correct getToken Url
        url: "/web/demo/json/getToken",
        dataType:'json',
        data:{
        },
        success: function(msg){
            $('#tokenKey').val(msg.result.key);
            $('#token').val(msg.result.value);
        }
    });
}