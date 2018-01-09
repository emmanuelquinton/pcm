package org.equinton.pcm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.stagemonitor.core.Stagemonitor;

@SpringBootApplication
public class PersonnalCollectionManagerApplication {

    public static void main(String[] args) {
        Stagemonitor.init();
        SpringApplication.run(PersonnalCollectionManagerApplication.class, args);
    }
}
