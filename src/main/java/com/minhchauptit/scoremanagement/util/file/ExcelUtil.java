package com.minhchauptit.scoremanagement.util.file;

import com.minhchauptit.scoremanagement.dto.ScoreDetailDTO;
import com.minhchauptit.scoremanagement.dto.StudentDTO;
import com.minhchauptit.scoremanagement.util.factory.WorkbookFactory;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Logger;

@Component
public class ExcelUtil {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private Environment env;

    public List<ScoreDetailDTO> readScoreDetailFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        if(!file.exists()){
            throw new FileNotFoundException("file not found");
        }
        Workbook workbook = WorkbookFactory.getWorkbook(file);
        //get first sheet
        Sheet sheet = getSheet(workbook);
        //get properties
        Map<String,Integer> properties = findProperties(sheet);
        long startTime = System.currentTimeMillis();
        //get result
        List<ScoreDetailDTO> result = getListScoreDetail(sheet,properties);
        long endTime = System.currentTimeMillis();
        long time = (endTime-startTime);
        logger.info("Time for reading file: "+ time+"ms");
        logger.info("numbers of record: "+result.size()+ " records");

        return result;
    }

    private Sheet getSheet(Workbook workbook){
        logger.info("Number of Sheets: " +workbook.getNumberOfSheets());
        int sheetNum = 0;
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
        while (sheetIterator.hasNext()){
            Sheet currentSheet  = sheetIterator.next();
            Row firstRow = currentSheet.getRow(currentSheet.getFirstRowNum());
            Iterator<Cell> cellIterator = firstRow.cellIterator();
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                if(getCellValue(cell).equals("BẢNG ĐIỂM HỌC PHẦN")){
                    sheetNum = workbook.getSheetIndex(currentSheet);
                    break;
                }
            }
            if(sheetNum!=0) break;
        }
        return workbook.getSheetAt(sheetNum);
    }


    private Map<String,Integer> findProperties(Sheet sheet){
        Map<String,Integer> properties = new HashMap<>();
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()){
            Row currentRow = rowIterator.next();
            Iterator<Cell> cellIterator = currentRow.cellIterator();
            while(cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                String cellValue = getCellValue(cell);
                if(cellValue.equals(ScoreProperty.STUDENT_ID)){
                    properties.put(env.getProperty("score.student-id.name"),cell.getColumnIndex());
                    continue;
                }
                else if(cellValue.equals(ScoreProperty.FULL_NAME)){
                    properties.put(env.getProperty("score.first-name.name"),cell.getColumnIndex());
                    properties.put(env.getProperty("score.last-name.name"),cell.getColumnIndex()+1);
                    continue;
                }
                else if(cellValue.equals(ScoreProperty.ATTENDANCE_SCORE)){
                    properties.put(env.getProperty("score.attendance-score.name"),cell.getColumnIndex());
                    continue;
                }
                else if(cellValue.equals(ScoreProperty.MID_TERM_EXAM_SCORE)){
                    properties.put(env.getProperty("score.mid-term-exam-score.name"),cell.getColumnIndex());
                    continue;
                }
                else if(cellValue.equals(ScoreProperty.PRACTICE_SCORE)){
                    properties.put(env.getProperty("score.practice-score.name"),cell.getColumnIndex());
                    continue;
                }
                else if(cellValue.equals(ScoreProperty.ASSIGNMENT_SCORE)){
                    properties.put(env.getProperty("score.assignment-score.name"),cell.getColumnIndex());
                    continue;
                }
                else if(cellValue.equals(ScoreProperty.FINAL_EXAM_SCORE)){
                    properties.put(env.getProperty("score.final-exam-score.name"),cell.getColumnIndex());
                    continue;
                }
                else if(cellValue.equals(ScoreProperty.DESCRIPTION)){
                    properties.put(env.getProperty("score.description.name"),cell.getColumnIndex());
                    break;
                }

            }
            if(properties.size()==Integer.parseInt(env.getProperty("score.numbers-of-property"))) break;
        }
        return properties;
    }

    private String getCellValue(Cell cell) {
        CellType cellType = cell.getCellTypeEnum();
        String value = "";
        switch (cellType){
            case _NONE:{
                value = "NONE";
                break;
            }
            case BLANK: {
                value = "";
                break;
            }
            case STRING:{
                value = cell.getStringCellValue();
                break;
            }
            case NUMERIC:{
                value = String.valueOf(cell.getNumericCellValue());
                break;
            }
            case BOOLEAN:{
                value = String.valueOf(cell.getBooleanCellValue());
                break;
            }
            case FORMULA:{
                value = "FOMULA";
                break;
            }
            case ERROR:{
                value = "ERROR";
                break;
            }
            default:{
                break;
            }
        }
        return value;
    }
    private List<ScoreDetailDTO> getListScoreDetail(Sheet sheet, Map<String, Integer> properties) {
        List<ScoreDetailDTO> result = new ArrayList<>();
        Iterator<Row> rowIterator = sheet.rowIterator();
        while(rowIterator.hasNext()){
            Row row = rowIterator.next();
            if(!isScoreDetailRow(row)) continue;
            StudentDTO studentDTO = new StudentDTO();
            ScoreDetailDTO scoreDetailDTO = new ScoreDetailDTO();

            Cell cellStudentId = row.getCell(properties.get(env.getProperty("score.student-id.name")));
            studentDTO.setStudentId(cellStudentId.getStringCellValue());
            Cell cellFirstName = row.getCell(properties.get(env.getProperty("score.first-name.name")));
            studentDTO.setFirstName(cellFirstName.getStringCellValue());
            Cell cellLastName = row.getCell(properties.get(env.getProperty("score.last-name.name")));
            studentDTO.setLastName(cellLastName.getStringCellValue());
            Cell cellAttendanceScore = row.getCell(properties.get(env.getProperty("score.attendance-score.name")));
            scoreDetailDTO.setAttendanceScore(getCellScoreValue(cellAttendanceScore));
            Cell cellMidTermExamScore = row.getCell(properties.get(env.getProperty("score.mid-term-exam-score.name")));
            scoreDetailDTO.setMidTermExamScore(getCellScoreValue(cellMidTermExamScore));
            Cell cellPracticeScore = row.getCell(properties.get(env.getProperty("score.practice-score.name")));
            scoreDetailDTO.setPracticeScore(getCellScoreValue(cellPracticeScore));
            Cell cellAssignmentScore = row.getCell(properties.get(env.getProperty("score.assignment-score.name")));
            scoreDetailDTO.setAssignmentScore(getCellScoreValue(cellAssignmentScore));
            Cell cellFinalExamScore = row.getCell(properties.get(env.getProperty("score.final-exam-score.name")));
            scoreDetailDTO.setFinalExamScore(getCellScoreValue(cellFinalExamScore));
            Cell cellDescription = row.getCell(properties.get(env.getProperty("score.description.name")));
            scoreDetailDTO.setDescription(cellDescription.getRichStringCellValue().getString());

            scoreDetailDTO.setStudentDTO(studentDTO);
            result.add(scoreDetailDTO);
        }
        return result;
    }

    private boolean isScoreDetailRow(Row row) {
        try{
            Cell cell = row.getCell(row.getFirstCellNum());
            Float.parseFloat(getCellValue(cell));
        }catch (NumberFormatException ex){
            return false;
        }
        return true;
    }

    private Float getCellScoreValue(Cell cellScore){
        try{
            String cellValue = getCellValue(cellScore);
            Float score = Float.parseFloat(cellValue);
            return score;
        }catch (Exception ex){
            return null;
        }
    }

}
