var form = $('#forgotPasswordForm');
form.on('submit',function (e) {
    e.preventDefault();
    $.ajax({
        url : form.prop('action'),
        type : 'post',
        data:{
            email : $('#email').val()
        },
        dataType: 'text',
        cache: false,
        success: function (res) {
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
    })
});