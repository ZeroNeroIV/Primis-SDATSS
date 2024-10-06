package com.primis.seismicdetectionacrossthesolarsystem.services;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
@RequiredArgsConstructor
public class UploadZipFileService {

    private static final String UPLOAD_LOCATION = "../../resources/uploadedFiles/";
    private static final String CSV_LOCATION = "../../resources/scriptOutput/";
    private static final String PYTHON_SCRIPT = "../../resources/python/main.py";
    private static Integer Counter = 0;

    public Map<String, String> uploadZipFile(@NotNull MultipartFile file) throws Exception {
        //? Checking if file is empty
        if (file.isEmpty()) {
            throw new IllegalArgumentException("File cannot be empty!");
        }
        //? Checking if folder exists
        Path uploadPath = uploadPathChecker();

        //? Get file name
        String fileName = file.getOriginalFilename();
        assert fileName != null;
        Path filePath = uploadPath.resolve(fileName);

        //? Unzip file, save it and send the path back to the controller
        String extractedFilePath = unzipFile(filePath);

        //? Send the path to the csv file
        return sendToPythonScript(Path.of(extractedFilePath));
    }

    private Path uploadPathChecker() throws IOException {
        Path uploadPath = Paths.get(UploadZipFileService.UPLOAD_LOCATION);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        return uploadPath;
    }

    private String unzipFile(@NotNull Path filePath) throws Exception {
        try (ZipInputStream zis = new ZipInputStream(Files.newInputStream(filePath))) {
            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null) {
                Path extractedFilePath = Paths.get(UploadZipFileService.UPLOAD_LOCATION, zipEntry.getName());
                if (zipEntry.isDirectory()) {
                    Files.createDirectories(extractedFilePath);
                } else {
                    Files.copy(zis, extractedFilePath);
                }
                return extractedFilePath.toString();
            }
            zis.closeEntry();
        }
        throw new Exception("Unzipping failed - File cannot be empty!");
    }

    private Map<String, String> sendToPythonScript(Path filePath) {
        String csvFilePath = CSV_LOCATION + "output" + Counter++ + ".csv";
        // TODO: implement this
        try {
            //? Build the command to execute the python script with the folder path as an argument
            ProcessBuilder processBuilder = new ProcessBuilder("python3", PYTHON_SCRIPT, filePath.toString());
            //? Redirect error stream to standard output
            processBuilder.redirectErrorStream(true);
            //? Start the process
            Process process = processBuilder.start();
            //? Read the output of the process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            //? Wait for the process to finish
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                throw new RuntimeException("Python script failed with exit code: " + exitCode);
            }
            //? Check if the CSV file was created
            File csvFile = new File(csvFilePath);
            if (!csvFile.exists()) {
                throw new RuntimeException("CSV file not created!");
            }
            //? Return the file download URL to the frontend, and close the reader
            String downloadUrl = "http://localhost:8080/download/" + csvFilePath;
            reader.close();
            return Map.of("downloadUrl", downloadUrl,
                    "csvFilePath", csvFilePath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}