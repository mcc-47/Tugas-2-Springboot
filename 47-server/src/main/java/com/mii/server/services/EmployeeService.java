/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dto.EmployeeProvinceDto;
import com.mii.server.dto.RegistrationDto;
import com.mii.server.entities.Address;
import com.mii.server.entities.Contact;
import com.mii.server.entities.District;
import com.mii.server.entities.Education;
import com.mii.server.entities.Employee;
import com.mii.server.entities.Major;
import com.mii.server.entities.Province;
import com.mii.server.entities.Subdistrict;
import com.mii.server.entities.University;
import com.mii.server.entities.Village;
import com.mii.server.repositories.AddressRepository;
import com.mii.server.repositories.DistrictRepository;
import com.mii.server.repositories.EmployeeRepository;
import com.mii.server.repositories.ProvinceRepository;
import com.mii.server.repositories.SubdistrictRepository;
import com.mii.server.repositories.VillageRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class EmployeeService{
    
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * menyimpan data yang diregistrasi
     */
    public void saveRegistration(RegistrationDto rdto) {
        
        Employee employee = new Employee(
                rdto.getPrefix(), rdto.getEmployeeId(), rdto.getEmployeeName(),rdto.getBirthDate(), rdto.getGender(), rdto.getEmail(), 
                new Address(rdto.getPrefix(), rdto.getEmployeeId(), new Village(rdto.getVillageId())),
                new Education(rdto.getPrefix(), rdto.getEmployeeId(), new Major(rdto.getMajorId()), new University(rdto.getUniversityId())),
                new Contact(rdto.getPrefix(), rdto.getEmployeeId(),rdto.getPhone(), rdto.getLinkedin()));
        employeeRepository.save(employee);
    }
    
//    public void saveRegistration(Employee employee){
//        employeeRepository.save(employee);
//    }
    
//    public void saveRegistration(String employeeName, Date birthDate, String gender, 
//            String email, String phone, String linkedin, Village villageId, Major majorId, 
//            University universityId) {
//        
//        Employee employee = new Employee(
//                employeeName, birthDate, gender, email, 
//                new Address(villageId), 
//                new Education(majorId, universityId), 
//                new Contact(phone, linkedin));
////        employee.setEmployeeName(employeeName);
//        employeeRepository.save(employee);
//    }
    
    
    /**
     * 
     * @return mengambil data dari tabel employee sampai province
     */
    public List<EmployeeProvinceDto> getAll(){
        employeeRepository.findAll();
        List<EmployeeProvinceDto> dts = new ArrayList<>();
        for (Employee e : employeeRepository.findAll()) {
            EmployeeProvinceDto dt = new EmployeeProvinceDto(
                    e.getEmployeeName(), 
                    e.getBirthDate(), 
                    e.getGender(), 
                    e.getEmail(),
                    e.getAddress().getStreet1(), 
                    e.getAddress().getVillage().getVillageName(), 
                    e.getAddress().getVillage().getZipCode(), 
                    e.getAddress().getVillage().getSubdistrict().getSubdistrictName(), 
                    e.getAddress().getVillage().getSubdistrict().getDistrict().getDistrictName(), 
                    e.getAddress().getVillage().getSubdistrict().getDistrict().getProvince().getProvinceName()
            );
            dts.add(dt);
        }
        return dts;
    }
}
