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
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fadel M Nasution
 */
@Service
public class NotificationService {
    
    JavaMailSender javaMailSender;
    EmployeeRepository employeeRepository;
    
    @Value("${spring.mail.username}")
    String sender;
    
    @Autowired
    NotificationService notificationService;
    
    public void sendEmail(Integer employeeId) throws MessagingException {
        Employees employee = employeeRepository.findById(employeeId).get();
        String province = employee.getAddresses().getVillageId().getSubdistrictId().getDistrictId().getProvinceId().getProvinceName();
        
        if (province == null){
            province = "unknown province";
        }
        
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        
        helper.setFrom(sender);
        helper.setTo(employee.getEmail());
        
        helper.setSubject("Ini demo pengiriman email dari ikhsan");
        
        message.setText(
                String.format("ID:  %d, Name: %a, province: %s", employee.getEmployeeId(), 
                employee.getEmployeeName(), province), "UTF-8", "html");
        
        javaMailSender.send(message);
    }
}
