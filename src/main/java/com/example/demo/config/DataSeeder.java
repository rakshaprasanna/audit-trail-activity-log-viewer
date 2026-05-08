package com.example.demo.config;

import com.example.demo.entity.AuditLog;
import com.example.demo.repository.AuditLogRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final AuditLogRepository repository;

    public DataSeeder(AuditLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (repository.count() == 0) {

            for (int i = 1; i <= 30; i++) {

                AuditLog log = new AuditLog();

                log.setUsername("user" + i);
                log.setAction("LOGIN");
                log.setDescription("Demo Audit Log " + i);

                repository.save(log);
            }

            System.out.println("30 Demo Records Inserted");
        }
    }
}