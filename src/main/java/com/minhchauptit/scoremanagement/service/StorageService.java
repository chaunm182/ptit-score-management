package com.minhchauptit.scoremanagement.service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    void uploadFile(MultipartFile file);
}
