package com.example.backofficepro.config; // Remplacez par le package approprié

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
//hhhhh
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        // Vous pouvez définir explicitement le charset si nécessaire
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        converters.add(converter);
    }
}
