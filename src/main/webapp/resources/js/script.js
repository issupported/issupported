$(function () {

    $('#file').bind('change', function(e) {
        e.preventDefault();
        var button = $('#button');
        var size = this.files[0].size/1024/1024;//REVIEW: вот эти деления лучше вынести в константу и сделать коментарий к ней что это такое
        var maxSize = 1 ;
        if(size > maxSize){
            alert('error'); //REVIEW:нормальное сообщение надо
            var input = $('#image-file');
            input.replaceWith(input.val('').clone(true));
        }

        console.log('size', size);
    });
    $('INPUT[type="file"]').change(function () {
        var ext = this.value.match(/\.(.+)$/)[1]; //REVIEW: название переменой не о чем не говорит
        switch (ext) {
            case 'css':
                $('#button').attr('disabled', false);
                break;
            default:
                alert('This is not an allowed file type.');
                this.value = '';
        }
    });
    //REVIEW: баг с выводом ошибок, написал тебе в вк
});