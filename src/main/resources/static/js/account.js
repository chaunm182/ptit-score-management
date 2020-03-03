var accountForm = $('#accountForm');

$('#btnSaveAccount').on('click',function () {
    accountForm.submit();
});

accountForm.on('submit',function (e) {
    var data = {};
    data['id'] = $('#id').val();
    data['email'] = $('#email').val();
    e.preventDefault();
    $.ajax({
        url : accountForm.attr('action'),
        type : 'PUT',
        contentType : 'application/json',
        dataType : 'text',
        data : JSON.stringify(data),
        cache : false,
        timeout : 100000,
        success : function (res) {
            if(res=="true"){
                Swal.fire({
                    position: 'top-end',
                    type: 'success',
                    title: 'Thay đổi thông tin tài khoản thành công',
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
        error: function (res) {
            console.log(res);
        }
    });
});