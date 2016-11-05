function SendPost() {

    $.ajax({
        type:'post',
        url:'/parse',
        response:'json',

    success:function (data) {
       console.log(data);

    }

});

}
