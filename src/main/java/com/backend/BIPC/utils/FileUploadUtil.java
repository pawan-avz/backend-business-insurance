package com.backend.BIPC.utils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

import java.nio.file.*;

@Component
public class FileUploadUtil {

    private static final String UPLOAD_DIR="src/main/resources/static/images";

    public  String saveFile(MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(UPLOAD_DIR);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(multipartFile.getOriginalFilename());
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
//            System.out.println(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename());
            return UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename();
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + multipartFile.getOriginalFilename(), ioe);
        }
    }
}
