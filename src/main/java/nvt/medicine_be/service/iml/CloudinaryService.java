package nvt.medicine_be.service.iml;


import java.io.IOException;
import java.util.Map;

import nvt.medicine_be.service.ICloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryService implements ICloudinaryService {

    @Autowired
    Cloudinary cloudinary;

    @Override
    public String upload(MultipartFile file, String folderName) {
        Map params = ObjectUtils.asMap(
                "folder", folderName, "public_id", file.getOriginalFilename()
        );

        try {
            Map data = cloudinary.uploader().upload(file.getBytes(), params);
            Object url = data.get("url");

            return url.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
