package com.synchrony.project.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.synchrony.project.entity.FileData;
import com.synchrony.project.repository.FileDataRepository;


@Service
public class StorageService {

    @Autowired
    private FileDataRepository fileDataRepository;

    //replace below path with image api
    private final String FOLDER_PATH="C:\\test\\";

    public String uploadImageToFileSystem(MultipartFile file,String userName) throws IOException {
        String filePath=FOLDER_PATH+file.getOriginalFilename();

        FileData fileData=fileDataRepository.save(new FileData(file.getOriginalFilename(),file.getContentType(),filePath,userName));
        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "file uploaded successfully : " + filePath;
        }
        return null;
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        Optional<FileData> fileData = fileDataRepository.findByName(fileName);
        String filePath=fileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }
    
    public byte[] downloadImageFromFileSystemByUser(String username) throws IOException {
        Optional<FileData> fileData = fileDataRepository.findByUsername(username);
        String filePath=fileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }



}
