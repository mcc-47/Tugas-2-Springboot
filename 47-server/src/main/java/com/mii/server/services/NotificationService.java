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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class NotificationService {
    JavaMailSender javaMailSender;
    
    EmployeeRepository employeeRepository;
    
    @Value("${spring.mail.username}")
    String sender;
    
    public NotificationService(JavaMailSender javaMailSender, EmployeeRepository employeeRepository) {
        this.javaMailSender = javaMailSender;
        this.employeeRepository = employeeRepository;
    }
    
    public void sendEmail(Integer employeeId) throws MessagingException {
        Employees employee = employeeRepository.findById(employeeId).get();
        
        String employeeProvince = employee.getAddresses().getVillageId().getSubdistrictId().getDistrictId().getProvinceId().getProvinceName();
        if (employeeProvince == null) {
            employeeProvince = "unknown";
        }
        
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        
        helper.setFrom(sender);
        
        helper.setTo(employee.getEmail());
        
        helper.setSubject("Notifikasi Registrasi User Baru MCC");
        
        message.setText(String.format(
                "Halo %s, selamat datang di MCC!\n Anda berhasil melakukan registrasi di MCC cabang %s dengan ID %d.", 
                employee.getEmployeeName(), employeeProvince, employee.getEmployeeId()), 
                "UTF-8", "html");
        
        javaMailSender.send(message);
    }
    
}
