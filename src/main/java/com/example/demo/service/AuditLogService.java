package com.example.demo.service;

import com.example.demo.entity.AuditLog;
import com.example.demo.repository.AuditLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditLogService {

    private final AuditLogRepository repository;

    public AuditLogService(AuditLogRepository repository) {
        this.repository = repository;
    }

    public List<AuditLog> getAllLogs() {
        return repository.findAll();
    }

    public AuditLog saveLog(AuditLog log) {

        if (log.getUsername() == null || log.getUsername().isEmpty()) {
            throw new RuntimeException("Username is required");
        }

        return repository.save(log);
    }
}