package com.mii.server.services;

import com.mii.server.entities.Employees;
import com.mii.server.repositories.EmpAdsRepository;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
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
    EmpAdsRepository empAdsRepository;

    @Value("${spring.mail.username}")
    String sender;

    public NotificationService(JavaMailSender javaMailSender, EmpAdsRepository empAdsRepository) {
        this.javaMailSender = javaMailSender;
        this.empAdsRepository = empAdsRepository;
    }

    public void sendEmail(Integer employeeId) throws MessagingException {
        Employees employee = empAdsRepository.findById(employeeId).get();

        String province = employee.getAddresses().getVillageId().getSubdistrictId().getDistrictId()
                .getProvinceId().getProvinceName();
        if (province == null) {
            province = "Unknown Province";
        }

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(sender);
        helper.setTo(employee.getEmail());
        helper.setSubject("SENDING EMAIL SPRINGBOT");

        message.setText(
                String.format("ID : %d, Name : %s, Province : %s", employee.getEmployeeId(),
                        employee.getEmployeeName(), province), "UTF-8", "html");

        javaMailSender.send(message);
    }
}
