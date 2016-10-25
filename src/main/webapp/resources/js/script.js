$(function () {
    var inputFile = $('#file');

    inputFile.bind('change', function(e) {
        e.preventDefault();
        const COEFFICIENT = 1024;
        var button = $('#button');
        var sizeFile = this.files[0].size/COEFFICIENT/1024;
        var maxSize = 1;
        if(sizeFile > maxSize){
            alert('to big file sizeFile');
            var input = $('#file');
            input.replaceWith(input.val('').clone(true));
        }
        console.log('sizeFile', sizeFile);
    });

    inputFile.change(function () {
        var fileType = this.value.match(/\.(.+)$/)[1];
        switch (fileType) {
            case 'css':
                $('#button').attr('disabled', false);
                break;
            default:
                alert('This is not an allowed file type.');
                this.value = '';
        }
    });
    inputFile.submit(function (e) {
        e.preventDefault();
        var file = new FormData();
        file.append('cssFile', this.files[0]);
    });

});