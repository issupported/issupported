$(function () {
    var button = $('.button');
    var sendForm = $('.content');

    button.on('click', function (e) {
        e.preventDefault();
        sendForm.show();
        console.log('ok');

    })
});
