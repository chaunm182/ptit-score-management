package com.minhchauptit.scoremanagement.exception;

public class IncorrectExcelFileTypeException extends RuntimeException {
    public IncorrectExcelFileTypeException() {
        super();
    }

    public IncorrectExcelFileTypeException(String message) {
        super(message);
    }

    public IncorrectExcelFileTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
