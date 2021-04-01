/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.service;

import com.mii.server.entity.Employees;
import com.mii.server.repositories.EmpRepository;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author MyLaptop
 */
@Service
public class NotificationService {
    JavaMailSender javaMailSender;
    EmpRepository empRepository;
    
    @Value("$(spring.mail.username)")
    String sender;
    @Autowired
      public NotificationService(JavaMailSender javaMailSender, EmpRepository empRepository) {
        this.javaMailSender = javaMailSender;
        this.empRepository = empRepository;
    }
    
    public void sendEmail (Integer employeeId) throws MessagingException{
        Employees employee = empRepository.findById(employeeId).get();
        
        String province = employee.getAddresses().getVillageId().getSubdistrictId().getDistrictId().getProvinceId().getProvinceName();
        if(province == null){
            province = "Unknown Province";
        }
        
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        
        helper.setFrom(sender);
        
        helper.setTo(employee.getEmail());
        
        helper.setSubject("INI DEMO PENGIRIMAN EMAIL");
        
        message.setText(
                String.format("ID : %d, Name : %s, Province : %s", employee.getEmployeeId(),
                    employee.getEmployeeName(), province),
                "UTF-8" , "html"
        );
        
        javaMailSender.send(message);
    }  
}
