package com.example.demo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ReminderService {

    @Scheduled(fixedRate = 10000)
    public void reminder() {
        System.out.println("Reminder Notification Running...");
    }
}