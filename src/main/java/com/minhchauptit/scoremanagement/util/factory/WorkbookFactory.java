package com.minhchauptit.scoremanagement.util.factory;

import com.minhchauptit.scoremanagement.exception.IncorrectExcelFileTypeException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class WorkbookFactory {
    public static Workbook getWorkbook(File file){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            if(file.getName().endsWith(".xls")){
                return new HSSFWorkbook(fileInputStream);
            }
            else if(file.getName().endsWith(".xlsx") || file.getName().endsWith(".xlsm")){
                return new XSSFWorkbook(fileInputStream);
            }
            else throw new IncorrectExcelFileTypeException("Incorrect file type");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Chay vao day");
            e.printStackTrace();
        }
        return null;

    }
}
