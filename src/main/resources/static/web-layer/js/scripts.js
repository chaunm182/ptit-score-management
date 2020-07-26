var studentInput = $('#studentInput');
var iconSection = $('#icon');
studentInput.focus();
var tableSection = $('.table-responsive');
var scoresDiv = $('#scores');
var sessionSuggestion = null;

function searchScoresByStudentId(studentSuggestion) {
    //set input
    studentInput.prop('disabled',true);

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
            var rows = '';
            $.each(listScores,function (index,item) {
                rows+=drawScoreRow(item);
            });
            //draw table
            refreshTableScore(rows);
            $('#termPointAverage').text(data.termPointAverage.toFixed(2));
            //slide down
            scoresDiv.slideDown(400);
        },
        error : function (res) {
            console.log(res);
        }
    })
}

function refreshTableScore(rows) {
    var table = '<table id="main-table" class="table table-hover table-striped text-center" data-tablesaw-mode="columntoggle">\n' +
        '<thead class="text-uppercase bg-deepblue">\n' +
        '<tr>\n' +
        '<th data-tablesaw-priority="persist" scope="col">Mã MH</th>\n' +
        '<th data-tablesaw-priority="1" scope="col">Tên MH</th>\n' +
        '<th data-tablesaw-priority="5" scope="col">Số TC</th>\n' +
        '<th data-tablesaw-priority="5" scope="col">CC</th>\n' +
        '<th data-tablesaw-priority="5" scope="col">KT</th>\n' +
        '<th data-tablesaw-priority="5" scope="col">TN-TH</th>\n' +
        '<th data-tablesaw-priority="5" scope="col">BTL</th>\n' +
        '<th data-tablesaw-priority="1" scope="col">Thi</th>\n' +
        '<th data-tablesaw-priority="5" scope="col">TK(10)</th>\n' +
        '<th data-tablesaw-priority="1" scope="col">TK(CH)</th>\n' +
        '<th data-tablesaw-priority="5" scope="col">Ghi chú</th>\n' +
        '</tr>\n' +
        '</thead>\n' +
        '<tbody>\n' +
        '</tbody>\n' +
        '</table>';
    tableSection.html(table);
    var tableBody = $('#main-table tbody');
    tableBody.html(rows);
    $('#main-table').tablesaw().data( "tablesaw" ).refresh();
}

function drawScoreRow(item) {
    var attendanceScore = (item.attendanceScore!=null) ? item.attendanceScore : '';
    var midTermScore = (item.midTermExamScore!=null) ? item.midTermExamScore : '';
    var practiceScore = (item.practiceScore!=null) ? item.practiceScore : '';
    var assignmentScore = (item.assignmentScore!=null) ? item.assignmentScore : '';
    var finalExamScore = (item.finalExamScore!=null) ? item.finalExamScore : '';
    var row = '<tr>\n' +
        '        <th data-tablesaw-priority="persist" scope="row">'+item.subjectDTO.subjectId+'</th>\n' +
        '        <td data-tablesaw-priority="1">'+item.subjectDTO.name+'</td>\n' +
        '        <td data-tablesaw-priority="5">'+item.subjectDTO.credit+'</td>\n' +
        '        <td data-tablesaw-priority="4">'+attendanceScore+'</td>\n' +
        '        <td data-tablesaw-priority="4">'+midTermScore+'</td>\n' +
        '        <td data-tablesaw-priority="4">'+practiceScore+'</td>\n' +
        '        <td data-tablesaw-priority="4">'+assignmentScore+'</td>\n' +
        '        <td data-tablesaw-priority="1">'+finalExamScore+'</td>\n' +
        '        <td data-tablesaw-priority="5">'+item.mark+'</td>\n' +
        '        <th data-tablesaw-priority="1" scope="row">'+item.letter+'</th>\n' +
        '        <td data-tablesaw-priority="5">'+item.description+'</td>\n' +
        '      </tr>';
    return row;

}
//
//
var searchApiUrl = $('#searchApiUrl').prop('href');
studentInput.autocomplete({
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
        // if(scoresDiv.css('display')!='none'){
        //     scoresDiv.fadeTo(1,0.25);
        // }
        iconSection.html('<i class="loader"></i>');
    },

    onSearchComplete: function(){
        iconSection.html('<ti class="fa fa-search"></ti>');
    },
    onSelect : function (suggestion) {
        // if(scoresDiv.css('opacity')<1){
        //     scoresDiv.css('opacity',1);
        // }
        sessionSuggestion = suggestion;
        searchScoresByStudentId(suggestion);
    }
});

$('#semester').on('change', function () {
    searchScoresByStudentId(sessionSuggestion);
})