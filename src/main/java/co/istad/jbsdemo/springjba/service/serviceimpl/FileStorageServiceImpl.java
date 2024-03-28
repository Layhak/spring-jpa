package co.istad.jbsdemo.springjba.service.serviceimpl;

import co.istad.jbsdemo.springjba.service.FileStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//? Validation type of file to be uploaded
@Service
public class FileStorageServiceImpl implements FileStorageService {
    @Value("${file_storage.image_location}")
    String fileStorageLocation;

    @Override
    public String uploadSingleFile(MultipartFile file) {
        try {
            Path imageStoragePath = Path.of(fileStorageLocation);
            if (!Files.exists(imageStoragePath)) {
                Files.createDirectories(imageStoragePath);
            }
            String newFileName = UUID.randomUUID()+"."+ file.getOriginalFilename().split("\\.")[1];
            Path imageFullPath = imageStoragePath.resolve(newFileName);

            Files.copy(file.getInputStream(), imageFullPath, StandardCopyOption.REPLACE_EXISTING);
            return newFileName;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> uploadMultipleFiles(MultipartFile[] files) {
        return new ArrayList<>(){{
            for (MultipartFile file:files){
                add(uploadSingleFile(file));
            }
        }};
    }
}
