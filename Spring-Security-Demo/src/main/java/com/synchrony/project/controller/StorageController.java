package com.synchrony.project.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.synchrony.project.service.StorageService;

@RestController
public class StorageController {
	
    Logger logger = LoggerFactory.getLogger(StorageController.class);


	@Autowired
	private StorageService service;


	@PostMapping("/fileSystem")
	public ResponseEntity<?> uploadImageToFIleSystem(@RequestParam("image")MultipartFile file,@RequestParam("user") String user) throws IOException {
		String uploadImage = service.uploadImageToFileSystem(file,user);
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage);
	}

	@GetMapping("/fileSystem/{fileName}")
	public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String fileName) throws IOException {
		byte[] imageData=service.downloadImageFromFileSystem(fileName);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageData);

	}
	
	@GetMapping("/fileSystem/username/{username}")
	public ResponseEntity<?> downloadImageFromFileSystemByUser(@PathVariable String username) throws IOException {
		byte[] imageData=service.downloadImageFromFileSystemByUser(username);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageData);

	}


}
