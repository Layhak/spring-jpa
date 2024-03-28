package co.istad.jbsdemo.springjba.restcontroller;

import co.istad.jbsdemo.springjba.service.FileStorageService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

@RestController
@RequestMapping("api/v1/files")
@RequiredArgsConstructor
public class FileStorageRestController {
    private final FileStorageService fileStorageService;

    private String generateImageUrl(String filename, HttpServletRequest request) {
        return String.format("%s://%s:%d/images/%s", request.getScheme(), request.getServerName(), request.getServerPort(), filename);
    }

    @PostMapping(value = "", consumes = {"multipart/form-data"})
    public TreeMap<String, Object> uploadFile(@RequestPart("file") MultipartFile file, HttpServletRequest request) {
        return new TreeMap<>() {{
            put("message", "Success");
            put("payload", generateImageUrl(fileStorageService.uploadSingleFile(file), request));
            put("status", HttpStatus.OK.value());
        }};
    }

    @PostMapping(value = "/multiple", consumes = {"multipart/form-data"})
    public TreeMap<String, Object> uploadMultipleFile(@RequestPart("files") MultipartFile[] files) {
        return new TreeMap<>() {{
            put("message", "Success");
            put("payload", fileStorageService.uploadMultipleFiles(files));
            put("status", HttpStatus.OK.value());
        }};
    }
    @DeleteMapping("/{filename}")
    public TreeMap<String,Object> deleteFile(@PathVariable String filename){
        fileStorageService.deleteSingleFile(filename);
        return new TreeMap<>(){{
            put("message","Success");
            put("payload",filename);
            put("status",HttpStatus.NO_CONTENT.value());
        }};
    }

}
