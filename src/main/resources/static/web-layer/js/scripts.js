var studentInput = $('#studentInput');
studentInput.on('keyup',function () {
    if (studentInput.val().trim().length == 0){
        hideStudentSuggest();
        showPopoverAndHightLightInput();
    }
    else if(studentInput.val().trim().length >=2){
        showStudentSuggest();
    }
});


studentInput.on('blur',function (e) {
    if (studentInput.val().trim().length == 0){
        showPopoverAndHightLightInput();
    }
    else{
        destroyPoperAndHightLightInput();
    }
    hideStudentSuggest();
});




function hideStudentSuggest() {
    $('#studentSuggest').hide(function (e) {
        $('#scores').fadeTo(100,1);
    });

}

function showStudentSuggest() {
    var studentSuggestBox = $('#studentSuggest');
    studentSuggestBox.hide();
    //add data for student suggest here
    addStudentsInSuggestBox();
    //
    studentSuggestBox.show(450,function () {
        $('#scores').fadeTo('fast',0.25);
    })
}

function showPopoverAndHightLightInput() {
    studentInput.prop('class','form-control border-danger');
    $('div.input-group').popover('show');
}

function destroyPoperAndHightLightInput() {
    studentInput.prop('class','form-control');
    $('div.input-group').popover('hide');
}

function addStudentsInSuggestBox() {
    var searchApiUrl = $('#searchApiUrl').prop('href');
    var url = searchApiUrl+$('#studentInput').val();
    $.ajax({
        url : url,
        dataType : 'json',
        contentType : false,
        type : 'get',
        cache : false,
        timeout : 100000,
        success : function (data) {
            $('#studentSuggest').html('');
            if(data.length==0){
                $('#studentSuggest').html('<p class="list-group-item text-center">Không tìm thấy kết quả phù hợp</p>')
            }
            else{
                $.each(data,function (index,item) {
                    $('#studentSuggest').append(drawStudentRowForSuggestBox(item));
                });
            }


        },
        error : function (res) {
            console.log(res);
        }
    });
}

function drawStudentRowForSuggestBox(item) {
    var row = '<a class="list-group-item list-group-item-action">' +
        '<span class="badge badge-info mr-2">'+item.studentId+'</span> '+item.firstName+' '+item.lastName+
        '</a>';
    return row;
}

$('#studentSuggest').on('click','.list-group-item',function (e) {
    var text = e.target.text;
    var studentId = text.substring(0,10);
    var studentName = text.substring(studentId.length+1,text.length);
    $('#scores').find('h4.header-title').text(studentId+' - '+studentName);
    studentInput.val(studentId);
    //find scores
});


