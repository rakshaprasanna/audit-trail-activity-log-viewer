package com.example.demo.controller;

import com.example.demo.entity.AuditLog;
import com.example.demo.service.AuditLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class AuditLogController {

    private final AuditLogService service;

    public AuditLogController(AuditLogService service) {
        this.service = service;
    }

    @GetMapping
    public List<AuditLog> getAllLogs() {
        return service.getAllLogs();
    }

    @PostMapping
    public AuditLog createLog(@RequestBody AuditLog log) {
        return service.saveLog(log);
    }
}