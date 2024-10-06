package com.primis.seismicdetectionacrossthesolarsystem.controllers;

import com.primis.seismicdetectionacrossthesolarsystem.services.UploadZipFileService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController("/api/v1/files")
@RequiredArgsConstructor
public class UploadZipFileController {
    private final UploadZipFileService uploadZipFileService;

    @PostMapping("/upload-zip-file")
    public ResponseEntity<?> uploadZipFile(@NotNull @RequestParam("file") MultipartFile file) throws Exception {
        return new ResponseEntity<>(uploadZipFileService.uploadZipFile(file), HttpStatus.CREATED);
    }

    @GetMapping("/download/{filePath:.+}")
    public ResponseEntity<?> downloadZipFile(@NotNull @PathVariable String filePath) throws IOException {
        if (!filePath.endsWith(".zip")) {
            throw new IllegalArgumentException("File path must end with .zip");
        }
        Path path = Paths.get(filePath);
        byte[] bytes = Files.readAllBytes(path);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).body(bytes);
    }

}
