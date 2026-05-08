package com.example.demo.service;

import com.example.demo.entity.AuditLog;
import com.example.demo.exception.ResourceNotFoundException;
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

    // Get All Logs
    @Cacheable("logs")
    public List<AuditLog> getAllLogs() {

        List<AuditLog> logs = repository.findAll();

        if (logs.isEmpty()) {
            System.out.println("No Logs Found");
        }

        return logs;
    }

    // Save Log
    @CacheEvict(value = "logs", allEntries = true)
    public AuditLog saveLog(AuditLog log) {

        if (log.getUsername() == null || log.getUsername().isEmpty()) {
            throw new RuntimeException("Username is required");
        }

        return repository.save(log);
    }

    // Get By ID
    public AuditLog getLogById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Log not found with ID: " + id));
    }

    // Delete Log
    @CacheEvict(value = "logs", allEntries = true)
    public void deleteLog(Long id) {

        AuditLog log = getLogById(id);

        repository.delete(log);
    }
}