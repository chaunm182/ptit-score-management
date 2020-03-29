package com.minhchauptit.scoremanagement.util.score;

import com.minhchauptit.scoremanagement.dto.ScoreDetailDTO;
import com.minhchauptit.scoremanagement.dto.SubjectDTO;

public class ScoreUtil {
    public static String convertMarkToLetter(float mark){
        if(mark>=(float)9.0 && mark<=(float)10.0) return "A+";
        else if(mark>=(float)8.5 && mark<=(float)8.9) return "A";
        else if(mark>=(float)8.0 && mark<=(float)8.4) return "B+";
        else if(mark>=(float)7.0 && mark<=(float)7.9) return "B";
        else if(mark>=(float)6.5 && mark<=(float)6.9) return "C+";
        else if(mark>=(float)5.5 && mark<=(float)6.4) return "C";
        else if(mark>=(float)5.0 && mark<=(float)5.4) return "D+";
        else if(mark>=(float)4.0 && mark <=(float)4.9) return "D";
        return "F";
    }

    public static float convertLetterToPoint4(String letter){
        letter = letter.trim();
        if(letter.equals("A+")) return (float) 4.0;
        else if(letter.equals("A")) return (float) 3.7;
        else if(letter.equals("B+")) return (float) 3.5;
        else if(letter.equals("B")) return (float) 3.0;
        else if(letter.equals("C+")) return (float) 2.5;
        else if(letter.equals("C")) return (float) 2.0;
        else if(letter.equals("D+")) return (float) 1.5;
        else if(letter.equals("D")) return (float) 1.0;
        return (float) 0.0;

    }

    public static void setMark(ScoreDetailDTO scoreDetailDTO){
        SubjectDTO subjectDTO = scoreDetailDTO.getSubjectDTO();
        Integer attendanceWeight = subjectDTO.getSubjectDetailDTO().getAttendanceWeight();
        Integer midTermExamWeight = subjectDTO.getSubjectDetailDTO().getMidTermExamWeight();
        Integer practiceWeight = subjectDTO.getSubjectDetailDTO().getPracticeWeight();
        Integer assignmentWeight = subjectDTO.getSubjectDetailDTO().getAssignmentWeight();
        Integer finalExamWeight = 100 - (attendanceWeight+midTermExamWeight+practiceWeight+assignmentWeight);
        float mark = (float) 0.0;
        if(scoreDetailDTO.getFinalExamScore()==null){
            scoreDetailDTO.setMark(mark);
            return;
        }
        mark+=(getScore(attendanceWeight,scoreDetailDTO.getAttendanceScore())+
                getScore(midTermExamWeight,scoreDetailDTO.getMidTermExamScore())+
                getScore(practiceWeight,scoreDetailDTO.getPracticeScore())+
                getScore(assignmentWeight,scoreDetailDTO.getAssignmentScore())+
                getScore(finalExamWeight,scoreDetailDTO.getFinalExamScore()));
        //if english subject then mark/1000 else mark/100
        mark = mark>1000 ? mark/1000 : mark/100;
        mark = roundMark(mark);
        scoreDetailDTO.setMark(mark);
    }

    private static float getScore(Integer weight,Float score){
        if(score!=null) return weight*score;
        return 0;
    }

    public static void setLetter(ScoreDetailDTO scoreDetailDTO){
        scoreDetailDTO.setLetter(convertMarkToLetter(scoreDetailDTO.getMark()));
    }

    private static float roundMark(float mark){
        mark *=10;
        mark = Math.round(mark);
        return mark/10;
    }

}
