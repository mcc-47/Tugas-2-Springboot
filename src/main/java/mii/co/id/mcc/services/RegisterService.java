/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.mcc.services;

import java.util.ArrayList;
import java.util.List;
import mii.co.id.mcc.dto.RegisterDTO;
import mii.co.id.mcc.entities.Addresses;
import mii.co.id.mcc.entities.Contacts;
import mii.co.id.mcc.entities.Educations;
import mii.co.id.mcc.entities.Employees;
import mii.co.id.mcc.entities.Majors;
import mii.co.id.mcc.entities.Roles;
import mii.co.id.mcc.entities.Universities;
import mii.co.id.mcc.entities.Users;
import mii.co.id.mcc.entities.Villages;
import mii.co.id.mcc.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author ROG
 */
@Service
public class RegisterService {

    @Autowired
    EmployeeRepository employeeRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    //read
    public RegisterDTO showData(Integer id) {
        Employees e = employeeRepository.findById(id).get();
        
        RegisterDTO user = new RegisterDTO(
                e.getPrefix(), 
                id, 
                e.getEmployeeName(), 
                e.getBirthDate(), 
                e.getGender(), 
                e.getEmail(), 
                e.getAddresses().getVillageId().getVillageId(), 
                e.getContacts().getPhone(), 
                e.getContacts().getLinkedin(), 
                e.getEducations().getMajorId().getMajorId(), 
                e.getEducations().getUniversityId().getUniversityId(), 
                e.getUsers().getUsername(),
                e.getUsers().getPassword()
        );
        return user;
    }
    
    
    //insert
    public Employees insert(RegisterDTO registerDTO) {
        String newEmployeePrefix = registerDTO.getPrefix();
        Integer newEmployeeId = registerDTO.getIdEmployee();
        
        List<Roles> role = new ArrayList<>();
        role.add(new Roles(3, "Trainee"));
        
        Employees newEmployee = new Employees(
                newEmployeeId, 
                newEmployeePrefix, 
                registerDTO.getNameEmployee(), 
                registerDTO.getBirthdate(), 
                registerDTO.getGender(), 
                registerDTO.getEmail(), 
                new Addresses(
                        newEmployeeId, 
                        newEmployeePrefix, 
                        new Villages(registerDTO.getVillageId())), 
                new Educations(
                        newEmployeeId, 
                        newEmployeePrefix, 
                        new Majors(registerDTO.getMajorId()), 
                        new Universities(registerDTO.getUniversityId())), 
                new Contacts(
                        newEmployeeId, 
                        newEmployeePrefix, 
                        registerDTO.getPhone(), 
                        registerDTO.getLinkedin()), 
                new Users(
                        newEmployeeId, 
                        registerDTO.getUserName(), 
                        passwordEncoder.encode(registerDTO.getPassword()), 
                        role)
        );
        return employeeRepository.save(newEmployee);
    }
    
    //Delete
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }
}
