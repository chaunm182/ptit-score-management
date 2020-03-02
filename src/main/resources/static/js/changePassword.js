var btnCheckPassword = $('#checkOldPassword');
var changePasswordForm = $('#changePasswordForm');
btnCheckPassword.on('click',function () {
    changePasswordForm.find('small').html('');
    var password = $('#password').val();
    if(password.trim()==''){
        $('#password').css('border','1px solid red');
    }
    else{
        $('#password').css('border','1px solid rgba(170, 170, 170, .3)');
        $.ajax({
            url : $('#checkPasswordUrl').prop('href'),
            method: 'post',
            dataType : 'text',
            contentType : 'application/json',
            data:password,
            cache: false,
            timeout : 100000,
            success: function (res) {

                if(res=='true'){
                    changePasswordForm.append('<div class="form-group">\n' +
                        '                                    <label for="newPassword">Mật khẩu mới</label>\n' +
                        '                                    <input type="password" class="form-control" id="newPassword" placeholder="mật khẩu mới...">\n' +
                        '                                </div>\n' +
                        '                                <div class="form-group">\n' +
                        '                                    <label for="reNewPassword">Nhập lại mật khẩu mới</label>\n' +
                        '                                    <input type="password" class="form-control" id="reNewPassword" placeholder="nhập lại mật khẩu mới...">\n' +
                        '                                </div>' +
                    '<button disabled id="saveNewPassword" type="button" class="btn btn-primary mt-4 pr-4 pl-4">Lưu thay đổi <i class="ti-save"></i></button>');
                    btnCheckPassword.hide();
                    $('#password').prop('disabled',true);
                }
                else{
                    changePasswordForm.find('div.form-group').append('<small class="text-danger">Mật khẩu không chính xác</small>')
                }
            },
            error : function (res) {
                console.log(res);
            }
        });
    }
});

changePasswordForm.on('keyup','#reNewPassword, #newPassword',function () {
    var btnSave = $('#saveNewPassword');
    var reNewPassword = $('#reNewPassword');
    var newPassword = $('#newPassword');

    var value = reNewPassword.val();
    var newPassValue = newPassword.val();
    if(value==newPassValue){
        reNewPassword.css('border','1px solid rgba(170, 170, 170, .3)');
        btnSave.prop('disabled',false);
    }
    else{
        btnSave.prop('disabled',true);
        reNewPassword.css('border','1px solid red');
    }
});

changePasswordForm.on('click','#saveNewPassword',function () {
    $.ajax({
        url : $('#changePasswordUrl').prop('href'),
        method: 'post',
        dataType : 'text',
        contentType : 'application/json',
        data: $('#newPassword').val(),
        cache: false,
        timeout : 100000,
        success :function (res) {
            if(res=="true"){
                Swal.fire({
                    position: 'top-end',
                    type: 'success',
                    title: 'Đổi mật khẩu thành công',
                    showConfirmButton : false,
                    timer : 1500
                }).then(()=>{
                    $(location).attr('href',$('#redirectMyAccount').prop('href'));
                });


            }
            else{
                Swal.fire("Lỗi!", "Vui lòng thử lại sau!", "error");
            }
        },
        error : function (res) {
            console.log(res);
        }
    });
});