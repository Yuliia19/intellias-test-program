package project;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import project.service.FileReaderService;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        run(Application.class, args);
    }

    @Bean
    public FileReaderService getFileReaderService(@Value("${file.location}") String fileLocation){
        return new FileReaderService(fileLocation);
    }
}
