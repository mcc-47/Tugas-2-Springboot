/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import javax.mail.MessagingException;

/**
 *
 * @author William Yangjaya
 */
public interface NotificationService {

    /**
     *
     * @param employeeId
     * @throws MessagingException
     */
    public void sendEmail(Integer employeeId) throws MessagingException;
}
