/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.entities.Employees;
import com.mii.server.repositories.EmployeeRepository;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

/**
 *
 * @author User
 */
@Service
public class NotificationService {
   
    JavaMailSender javaMailSender;
    EmployeeRepository employeeRepository;

    @Value("${spring.mail.username}")
    String sender;

//    @Autowired
//    NotificationService notificationService;
    
    @Autowired

    public NotificationService(JavaMailSender javaMailSender, EmployeeRepository employeeRepository) {
        this.javaMailSender = javaMailSender;
        this.employeeRepository = employeeRepository;
    }

    
    

    public void sendEmail(Integer employeeId) throws MessagingException {
        Employees employee = employeeRepository.findById(employeeId).get();
        String province = employee.getAddresses().getVillageId().getSubdistrictId().getDistrictId().getProvinceId().getProvinceName();

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        System.out.println("From: " + sender);
        helper.setFrom(sender);
        helper.setTo(employee.getEmail());
        helper.setSubject("Ini demo pengiriman email");
        message.setText(String.format("ID: %d, Nama: %s, Province:%s", employee.getEmployeeId(),
                employee.getEmployeeName(),employee.getAddresses().getVillageId().getSubdistrictId().getDistrictId().getProvinceId().getProvinceName(), province), "UTF-8", "html");
        javaMailSender.send(message);
    }
}
