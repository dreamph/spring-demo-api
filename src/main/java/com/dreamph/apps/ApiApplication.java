package com.dreamph.apps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableJdbcRepositories
public class ApiApplication implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(ApiApplication.class);

    @GetMapping("/")
    public String index() throws Exception {
        LOG.info("index");
        return "API Online";
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
