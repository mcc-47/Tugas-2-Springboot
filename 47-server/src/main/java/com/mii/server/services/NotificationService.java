/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.entities.Employee;
import com.mii.server.repositories.EmployeeRepository;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class NotificationService {
    JavaMailSender javaMailSender;
    EmployeeRepository employeeRepository;
    
    @Value("$(spring.mail.username)")
    String sender;
    
    @Autowired
    public NotificationService(JavaMailSender javaMailSender, EmployeeRepository employeeRepository){
        this.javaMailSender = javaMailSender;
        this.employeeRepository = employeeRepository;
    }
    
    public void sendMail(Integer employeeId) throws MessagingException{
        Employee employee = employeeRepository.findById(employeeId).get();
//        String province = employee.getAddress().getVillage().getSubdistrict().getDistrict()
//                .getProvince().getProvinceName();
        
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        System.out.println("From" + sender);
        helper.setFrom(sender);
        helper.setTo(employee.getEmail());
        helper.setSubject("Demo pengiriman email");
        message.setText("Berhasil terkirim");
        javaMailSender.send(message);
        
    }
}
