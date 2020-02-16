package com.minhchauptit.scoremanagement.serviceimpl;


import com.minhchauptit.scoremanagement.exception.StorageException;
import com.minhchauptit.scoremanagement.service.StorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class StorageServiceImpl implements StorageService {

    @Value("${upload.path.excel}")
    private String uploadPath;

    @Override
    public String uploadFile(MultipartFile file) {
        if(file.isEmpty()) throw new StorageException("File is empty");
        String fileName = file.getOriginalFilename();
        try {
            InputStream inputStream = file.getInputStream();
            Path path = Paths.get(uploadPath+fileName);
            Files.copy(inputStream, path,StandardCopyOption.REPLACE_EXISTING);
            return path.toAbsolutePath().toString();
        } catch (IOException e) {
            throw new StorageException("Failed to upload file",e);
        }
    }
}
