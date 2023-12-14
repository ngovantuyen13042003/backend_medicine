package nvt.medicine_be.service;

import org.springframework.web.multipart.MultipartFile;

public interface ICloudinaryService {
    String upload(MultipartFile file, String folderName);
}
