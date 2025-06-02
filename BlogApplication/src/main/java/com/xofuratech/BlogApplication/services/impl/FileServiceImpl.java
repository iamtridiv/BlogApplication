package com.xofuratech.BlogApplication.services.impl;

import com.xofuratech.BlogApplication.services.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
@Service
public class FileServiceImpl implements FileService {
    private static Logger LOGGER = LoggerFactory.getLogger(FileServiceImpl.class);
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        // File name
        String fileName = file.getOriginalFilename();

        // Full path
        String filePath = path + File.separator + fileName;
        // Create folder if not exists
        File f = new File(path);
        if(!f.exists()) {
            boolean isFolderCreated = f.mkdir();
            LOGGER.info("Folder created -"+isFolderCreated);
        } else {
            LOGGER.info("Folder already exists in path: "+path);
        }

        // file copy
        Files.copy(file.getInputStream(), Paths.get(filePath));
        return fileName;
    }


    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String fullPath = path + File.separator+fileName;
        return new FileInputStream(fullPath);
    }
}
