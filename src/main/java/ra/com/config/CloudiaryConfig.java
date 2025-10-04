package ra.com.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;

public class CloudiaryConfig {
    private static final String CLOUD_NAME = "ddedgep8x";
    private static final String API_KEY = "982842968986635";
    private static final String API_SECRET = "zkX-OndnTSLQYdOn2MG9-nGariA";

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap("cloud_name", CLOUD_NAME,
                "api_key", API_KEY,
                "api_secret", API_SECRET));
    }

}
