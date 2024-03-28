package co.istad.jbsdemo.springjba.restcontroller;

import co.istad.jbsdemo.springjba.service.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.TreeMap;

@RestController
@RequestMapping("api/v1/files")
@RequiredArgsConstructor
public class FileStorageRestController {
    private final FileStorageService fileStorageService;

    @PostMapping(value = "", consumes = {"multipart/form-data"})
    public TreeMap<String, Object> uploadFile(@RequestPart("file") MultipartFile file) {
        return new TreeMap<>() {{
            put("message","Success");
            put("payload", fileStorageService.uploadSingleFile(file));
            put("status",HttpStatus.OK.value());
        }};
    }

    @PostMapping(value = "/multiple", consumes = {"multipart/form-data"})
    public TreeMap<String, Object> uploadMultipleFile(@RequestPart("files") MultipartFile[] files) {
        return new TreeMap<>() {{
            put("message","Success");
            put("payload", fileStorageService.uploadMultipleFiles(files));
            put("status", HttpStatus.OK.value());
        }};
    }
}
