package com.example.demo.service;

import com.example.demo.entity.AuditLog;
import com.example.demo.repository.AuditLogRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditLogService {

    private final AuditLogRepository repository;

    public AuditLogService(AuditLogRepository repository) {
        this.repository = repository;
    }

    @Cacheable("logs")
    public List<AuditLog> getAllLogs() {
        return repository.findAll();
    }

    @CacheEvict(value = "logs", allEntries = true)
    public AuditLog saveLog(AuditLog log) {
        return repository.save(log);
    }
}