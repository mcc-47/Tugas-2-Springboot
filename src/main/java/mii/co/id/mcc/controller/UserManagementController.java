/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.mcc.controller;

import mii.co.id.mcc.dto.LoginDTO;
import mii.co.id.mcc.dto.RegisterDTO;
import mii.co.id.mcc.dto.UserSessionDTO;
import mii.co.id.mcc.entities.Employees;
import mii.co.id.mcc.services.RegisterService;
import mii.co.id.mcc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ROG
 */
@RestController
@RequestMapping("management")
public class UserManagementController {
    
    @Autowired
    RegisterService registerService;
    
    @Autowired
    UserService userService;
    
    @GetMapping("/{id}")
    public RegisterDTO getEmployeeData(@PathVariable Integer id) {
        return registerService.showData(id);
    }
    
    @PostMapping("register")
    public String insert(@RequestBody RegisterDTO registerDTO) {
        registerService.insert(registerDTO);
        return "Registrasi Sukses";
    }
    
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        registerService.delete(id);
        return "Delete Success";
    }
    
    @PostMapping("login")
    public UserSessionDTO login(@RequestBody LoginDTO loginDTO) {
        return userService.loginUser(loginDTO);
    }
}
