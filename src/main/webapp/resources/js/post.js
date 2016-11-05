function SendPost() {

    $.ajax({
        type:'post',
        url:'http://192.168.1.60:8080/parse',
        data: file,
        dataType:'text',
        response:'json',

    success:function (data) {
       console.log(data);

    }

});

}
