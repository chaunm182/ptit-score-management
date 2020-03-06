var form = $('#forgotPasswordForm');
var btn = $('#btnResetPassword');
form.on('submit',function (e) {
    e.preventDefault();
    var requestAlert = Swal.fire({
        text: 'Đang yêu cầu, vui lòng chờ',
        allowOutsideClick : false,
        onBeforeOpen: function(){
            Swal.showLoading();
        }
    })
    $.ajax({
        url : form.prop('action'),
        type : 'post',
        data:{
            email : $('#email').val()
        },
        dataType: 'text',
        cache: false,
        beforeSend: function(){
            btn.prop('disabled',true);
            btn.text('Vui lòng chờ...');
        },
        success: function (res) {
            requestAlert.close();
            btn.prop('disabled',false);
            btn.text('Reset');
            if(res=='true'){
                Swal.fire('Thành công','Bạn đã yêu cầu đổi mật khẩu, vui lòng chờ và kiểm tra hòm thư email','success');
            }
            else{
                Swal.fire('Lỗi','Chúng tôi không tìm thấy thông tin email bạn yêu cầu','error');
            }
        },
        error: function (res) {
          console.log(res);
        }
    });
});