$('#studentInput').focus();

var scoresDiv = $('#scores');

function searchScoresByStudentId(studentSuggestion) {
        //set input
    var studentInput = $('#studentInput');
    studentInput.prop('disabled',true);
    //set table body
    var tableBody = $('tbody');
    tableBody.html('');

    var studentId = studentSuggestion.value;
    var studentName = studentSuggestion.data;

    //find scores
    var searchScoresApiUrl = $('#getTranscriptApiUrl').prop('href')+studentId+','+$('#semester').val();
    $.ajax({
        url: searchScoresApiUrl,
        type: 'get',
        contentType: false,
        dataType: 'json',
        cache: false,
        timeout: 100000,
        beforeSend : function(){
            if(scoresDiv.css('display')!='none'){
                scoresDiv.slideUp(400);
            }
            scoresDiv.find('h4.header-title').text(studentId+' - '+studentName);
        },
        success : function (data) {
            studentInput.prop('disabled',false);
            var listScores = data.listScore;
            $.each(listScores,function (index,item) {
                tableBody.append(drawScoreRow(item));

            });
            $('#termPointAverage').text(data.termPointAverage.toFixed(2));
            scoresDiv.slideDown(400);
        },
        error : function (res) {
            console.log(res);
        }
    })
}

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
//
//
var searchApiUrl = $('#searchApiUrl').prop('href');
$('#studentInput').autocomplete({
    serviceUrl : searchApiUrl,
    minChars : 3,
    autoSelectFirst: true,
    showNoSuggestionNotice : true,
    triggerSelectOnValidInput : false,
    noSuggestionNotice : 'Không tìm thấy kết quả phù hợp',
    formatResult : function(suggestion,currentValue){
       return '<span class="badge badge-info mr-2">'+suggestion.value+'</span> '+suggestion.data;
    },
    onSearchStart:function(){
      if(scoresDiv.css('display')!='none'){
          scoresDiv.fadeTo(1,0.25);
      }
    },
    onSelect : function (suggestion) {
        if(scoresDiv.css('opacity')<1){
            scoresDiv.css('opacity',1);
        }
        searchScoresByStudentId(suggestion);
    }
});