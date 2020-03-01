var btnCheckPassword = $('#checkOldPassword');
btnCheckPassword.on('click',function () {
    var password = $('#password').val();
    if(password.trim()==''){
        $('#password').css('border','1px solid red');
    }
    else{
        $.ajax({
            url : $('#checkPasswordUrl').prop('href'),
            method: 'post',
            dataType : 'text',
            contentType : 'application/json',
            data:password,
            cache: false,
            timeout : 100000,
            success: function (res) {
                var changePasswordForm = $('#changePasswordForm');
                if(res=='true'){
                    changePasswordForm.append('<div class="form-group">\n' +
                        '                                    <label for="newPassword">Mật khẩu mới</label>\n' +
                        '                                    <input type="password" class="form-control" id="newPassword" placeholder="mật khẩu mới...">\n' +
                        '                                </div>\n' +
                        '                                <div class="form-group">\n' +
                        '                                    <label for="reNewPassword">Nhập lại mật khẩu mới</label>\n' +
                        '                                    <input type="password" class="form-control" id="reNewPassword" placeholder="nhập lại mật khẩu mới...">\n' +
                        '                                </div>' +
                    '<button id="saveNewPassword" type="button" class="btn btn-primary mt-4 pr-4 pl-4">Lưu thay đổi <i class="ti-save"></i></button>');
                    btnCheckPassword.hide();
                    $('#password').prop('disabled',true);
                    $('#password').css('border','0.5px solid grey');
                }
                else{
                    changePasswordForm.find('div.form-group').append('<small class="text-danger">Tài khoản hoặc mật khẩu không chính xác</small>')
                }
            },
            error : function (res) {
                console.log(res);
            }
    })
    }

});