$(function () {

    $('#file').bind('change', function(e) {
        e.preventDefault();
        var button = $('#button');
        var size = this.files[0].size/1024/1024;
        var maxSize = 1 ;
        if(size > maxSize){
            alert('error');
            var input = $('#image-file');
            input.replaceWith(input.val('').clone(true));
        }

        console.log('size', size);
    });
    $('INPUT[type="file"]').change(function () {
        var ext = this.value.match(/\.(.+)$/)[1];
        switch (ext) {
            case 'css':
                $('#button').attr('disabled', false);
                break;
            default:
                alert('This is not an allowed file type.');
                this.value = '';
        }
    });
});