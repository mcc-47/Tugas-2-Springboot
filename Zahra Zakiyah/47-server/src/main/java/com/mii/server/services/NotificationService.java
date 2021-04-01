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
 * @author Zahra
 */
@Service
public class NotificationService {
    
    JavaMailSender javaMailSender;
    EmployeeRepository employeeRepository;
    
    @Value("${spring.mail.username")
    String sender;
    
    @Autowired
    public NotificationService(JavaMailSender javaMailSender, EmployeeRepository employeeRepository) {
        this.javaMailSender = javaMailSender;
        this.employeeRepository = employeeRepository;
    }
    
    public void sendEmail(Integer employeeId) throws MessagingException{
        
        Employees employee = employeeRepository.findById(employeeId).get();
        String province = employee.getAddresses().getVillageId().getSubdistrictId().getDistrictId().getProvinceId().getProvinceName();
        if(province == null){
            province = "unknown province";
        }
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(sender);
        helper.setTo(employee.getEmail());
        helper.setSubject("Registrasi berhasil");
//        message.setText(String.format("ID: %d, Name: %s, Province %s", employee.getEmployeeId(),employee.getEmployeeName(),province), "UTF-8", "html");
        message.setText(String.format("HALO %s ! Registrasimu berhasil. berikut data yang kamu inputkan :\n"
                + "ID\t\t: %d\n"
                + "Nama\t\t: %s\n"
                + "Pendidikan\t: %s - %s - %s\n"
                + "Kontak\t: %s / %s\n"
                + "Alamat\t: %s \n"
                + "SELAMAT TIDUR :) ",
                employee.getEmployeeName(),
                employee.getEmployeeId(),
                employee.getEmployeeName(),
                employee.getEducations().getDegree(), employee.getEducations().getMajorId().getMajorName(), employee.getEducations().getUniversityId().getUniversityName(),
                employee.getContacts().getPhone(), employee.getContacts().getLinkedin(),
                province), "UTF-8", "html");
        
        javaMailSender.send(message);
        
    }
}
