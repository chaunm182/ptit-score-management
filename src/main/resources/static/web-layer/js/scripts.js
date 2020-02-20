var studentInput = $('#studentInput');
$(document).ready(function () {
    studentInput.focus();
})
studentInput.on('keyup',function () {
    if (studentInput.val().trim().length == 0){
        hideStudentSuggest();
        showPopoverAndHightLightInput();
    }
    else if(studentInput.val().trim().length >=3){
        showStudentSuggest();
        destroyPoperAndHightLightInput();
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
        $('#scores').css('opacity',1);
    });

}

function showStudentSuggest() {
    var studentSuggestBox = $('#studentSuggest');
    studentSuggestBox.hide();
    //add data for student suggest here
    addStudentsInSuggestBox();
    //
    studentSuggestBox.show(480,function () {
        $('#scores').css('opacity',0.25);
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

$('#studentSuggest').on('click','a.list-group-item',function (e) {
    if($('#scores').css('display','none')){
        $('#scores').css('display','flex');
    }
    //set input
    studentInput.prop('disabled',true);
    //set progress bar property
    var progressBar = $('div.card-header');
    progressBar.css('display','block');
    //set table body
    var tableBody = $('tbody');
    tableBody.html('');
    //set heading
    var text = e.target.text;
    var studentId = text.substring(0,10);
    var studentName = text.substring(studentId.length+1,text.length);
    $('#scores').find('h4.header-title').text(studentId+' - '+studentName);
    studentInput.val(studentId);

    //find scores
    var searchScoresApiUrl = $('#getTranscriptApiUrl').prop('href')+studentId+','+$('#semester').val();
    $.ajax({
        url: searchScoresApiUrl,
        type: 'get',
        contentType: false,
        dataType: 'json',
        cache: false,
        timeout: 100000,
        success : function (data) {
            studentInput.prop('disabled',false);
            progressBar.hide();
            var listScores = data.listScore;
            $.each(listScores,function (index,item) {
                tableBody.append(drawScoreRow(item));

            });
            $('#termPointAverage').text(data.termPointAverage.toFixed(2));
        },
        error : function (res) {
            console.log(res);
        }
    })
});

function drawScoreRow(item) {
    var attendanceScore = (item.attendanceScore!=null) ? item.attendanceScore : '';
    var midTermScore = (item.midTermExamScore!=null) ? item.midTermExamScore : '';
    var practiceScore = (item.practiceScore!=null) ? item.practiceScore : '';
    var assignmentScore = (item.assignmentScore!=null) ? item.assignmentScore : '';
    var finalExamScore = (item.finalExamScore!=null) ? item.finalExamScore : '';
    var row = '<tr>\n' +
        '        <th scope="row">'+item.subjectDTO.subjectId+'</th>\n' +
        '        <td>'+item.subjectDTO.name+'</td>\n' +
        '        <td>'+item.subjectDTO.credit+'</td>\n' +
        '        <td>'+attendanceScore+'</td>\n' +
        '        <td>'+midTermScore+'</td>\n' +
        '        <td>'+practiceScore+'</td>\n' +
        '        <td>'+assignmentScore+'</td>\n' +
        '        <td>'+finalExamScore+'</td>\n' +
        '        <td>'+item.mark+'</td>\n' +
        '        <th scope="row">'+item.letter+'</th>\n' +
        '        <td>'+item.description+'</td>\n' +
        '      </tr>';
    return row;

}


