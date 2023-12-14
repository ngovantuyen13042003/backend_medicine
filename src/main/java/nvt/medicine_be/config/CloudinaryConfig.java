package nvt.medicine_be.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class CloudinaryConfig {

    public static final String CLOUD_NAME = "dbrorw5z0";
    public static final String API_KEY = "117498647486942";
    public static final String API_SECRET = "4qLcjBeIdjuS2CmuhaK4S3SDl_o";

    @Bean
    Cloudinary cloudinary() {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", CLOUD_NAME,
                "api_key", API_KEY,
                "api_secret", API_SECRET,
                "secure", true));
        return cloudinary;
    }

}