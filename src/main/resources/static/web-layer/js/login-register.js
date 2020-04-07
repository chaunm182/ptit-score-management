function showRegisterForm(){
    $('.loginBox').fadeOut('fast',function(){
        $('.registerBox').fadeIn('fast');
        $('.login-footer').fadeOut('fast',function(){
            $('.register-footer').fadeIn('fast');
        });
        $('.modal-title').html('Đăng ký');
    }); 
    $('.error').removeClass('alert alert-danger').html('');
       
}
function showLoginForm(){
    $('#loginModal .registerBox').fadeOut('fast',function(){
        $('.loginBox').fadeIn('fast');
        $('.register-footer').fadeOut('fast',function(){
            $('.login-footer').fadeIn('fast');    
        });
        $('.modal-title').html('Đăng nhập');
    });       
     $('.error').removeClass('alert alert-danger').html('');

}

function openLoginModal(){
    showLoginForm();
    setTimeout(function(){
        $('#loginModal').modal('show');    
    }, 230);
    
}
function openRegisterModal(){
    showRegisterForm();
    setTimeout(function(){
        $('#loginModal').modal('show');    
    }, 230);
    
}
function shakeModal(){
    $('#loginModal .modal-dialog').addClass('shake');
             $('.error').addClass('alert alert-danger').html("Sai tài khoản hoặc mật khẩu");
             $('input[type="password"]').val('');
             setTimeout( function(){ 
                $('#loginModal .modal-dialog').removeClass('shake'); 
    }, 1000 ); 
}

var formLogin = $('#form-login');
formLogin.on('submit',function (e) {
    e.preventDefault();
    // var form = new FormData();
    // var btnSubmit = $('#btnSubmitLogin');
    // form.append("username", $('#username').val());
    // form.append("password", $('#password').val());
    //
    // $.ajax({
    //     url:  formLogin.attr('action'),
    //     method: "POST",
    //     processData: false,
    //     contentType: false,
    //     data: form,
    //     timeout: 0,
    //     beforeSend: function(){
    //         btnSubmit.prop('disabled',true);
    //         btnSubmit.val('Vui lòng chờ...');
    //     },
    //     success: function (res) {
    //         console.log(res);
    //         if(res.trim()==='false'){
    //             btnSubmit.prop('disabled',false);
    //             btnSubmit.val('Đăng nhập');
    //             shakeModal();
    //         }
    //         else{
    //             $(location).attr('href','/');
    //         }
    //     },
    //     error: function (res) {
    //         console.log(res);
    //     }
    // });
    var form = new FormData();
    form.append("username", $('#username').val());
    form.append("password", $('#password').val());

    var settings = {
        "url": formLogin.attr('action'),
        "method": "POST",
        "timeout": 0,
        "processData": false,
        "mimeType": "multipart/form-data",
        "contentType": false,
        "data": form
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
    });
});