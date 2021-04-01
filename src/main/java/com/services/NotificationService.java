/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.entities.Employees;
import com.repositories.EmployeeRepository;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author jakab
 */
@Service
public class NotificationService {
    
    @Autowired
    JavaMailSender javaMailSender;
    
    @Autowired
    EmployeeRepository employeeRepository;
    
    @Value("${spring.mail.username}")
    String sender;

    public NotificationService(JavaMailSender javaMailSender, EmployeeRepository employeeRepository) {
        this.javaMailSender = javaMailSender;
        this.employeeRepository = employeeRepository;
    }
    
    public void sendEmail(Integer employeeId) throws MessagingException{
        
        //Finding employee
        Employees employee = employeeRepository.findById(employeeId).get();
        
        //Mime making email
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        
        //From (App) sender
        helper.setFrom(sender);
        //To (person) receiver
        helper.setTo(employee.getEmail());
        
        //Subject maker
        helper.setSubject("Registration Confirmation");
        //Mail body
        message.setText("Selamat anda sukses", "UTF-8", "html");
        //Sending email
        javaMailSender.send(message);
    }
}
