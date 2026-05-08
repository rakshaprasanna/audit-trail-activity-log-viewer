package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public String sendMail() {
        return "Email Notification Sent";
    }
}