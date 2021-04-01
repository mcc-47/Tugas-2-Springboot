/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dto.UserManagementDTO;
import com.mii.server.entities.Addresses;
import com.mii.server.entities.Contacts;
import com.mii.server.entities.Districts;
import com.mii.server.entities.Educations;
import com.mii.server.entities.Employees;
import com.mii.server.entities.Majors;
import com.mii.server.entities.Provinces;
import com.mii.server.entities.Subdistricts;
import com.mii.server.entities.Universities;
import com.mii.server.entities.Villages;
import com.mii.server.repositories.AddressRepository;
import com.mii.server.repositories.DistrictRepository;
import com.mii.server.repositories.EmployeeRepository;
import com.mii.server.repositories.ProvinceRepository;
import com.mii.server.repositories.SubdistrictRepository;
import com.mii.server.repositories.VillageRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO-KL
 */
@Service
public class UserManagementService {
    EmployeeRepository employeeRepository;
    AddressRepository addressRepository;
    VillageRepository villageRepository;
    SubdistrictRepository subdistrictRepository;
    DistrictRepository districtRepository;
    ProvinceRepository provinceRepository;
    @Autowired
    EmployeeService employeeService;

    public UserManagementService(EmployeeRepository employeeRepository, AddressRepository addressRepository, VillageRepository villageRepository, SubdistrictRepository subdistrictRepository, DistrictRepository districtRepository, ProvinceRepository provinceRepository) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
        this.villageRepository = villageRepository;
        this.subdistrictRepository = subdistrictRepository;
        this.districtRepository = districtRepository;
        this.provinceRepository = provinceRepository;
    }


    
    public List<UserManagementDTO> getUserManagementDTOs(){
        employeeRepository.findAll();
        List<UserManagementDTO> coba = new ArrayList<>();
        for (Employees e : employeeRepository.findAll()){
            UserManagementDTO ada = new UserManagementDTO(
            e.getPrefix(), 
            e.getEmployeeId(),
            e.getEmployeeName(),
            e.getBirthDate(), 
            e.getGender(),
            e.getEmail(),
            e.getAddresses().getStreet1(),
            e.getAddresses().getStreet2(),
            e.getAddresses().getVillageId().getVillageName(),
            e.getAddresses().getVillageId().getZipCode(),
            e.getAddresses().getVillageId().getSubdistrictId().getSubdistrictName(),
            e.getAddresses().getVillageId().getSubdistrictId().getDistrictId().getKab(),
            e.getAddresses().getVillageId().getSubdistrictId().getDistrictId().getDistrictName(),
            e.getAddresses().getVillageId().getSubdistrictId().getDistrictId().getProvinceId().getProvinceName()
            );
            coba.add(ada);
        }
    return coba;
    }
    public List<UserManagementDTO> getAlluser(){
        return ((List<Employees>) employeeRepository.findAll())
                .stream().map(this::convertToUserManagementDTO).collect(Collectors.toList());
    }
    private UserManagementDTO convertToUserManagementDTO(Employees employees){
        UserManagementDTO userManagementDTO = new UserManagementDTO();
        userManagementDTO.setPrefix(employees.getPrefix());
        userManagementDTO.setEmployeeId(employees.getEmployeeId());
        userManagementDTO.setEmployeeName(employees.getEmployeeName());
        userManagementDTO.setBirthDate(employees.getBirthDate());
        userManagementDTO.setGender(employees.getGender());
        userManagementDTO.setEmail(employees.getEmail());
        userManagementDTO.setStreet1(employees.getAddresses().getStreet1());
        userManagementDTO.setStreet2(employees.getAddresses().getStreet2());
        userManagementDTO.setVillageName(employees.getAddresses().getVillageId().getVillageName());
        userManagementDTO.setZipCode(employees.getAddresses().getVillageId().getZipCode());
        userManagementDTO.setSubdistrictName(employees.getAddresses().getVillageId().getSubdistrictId().getSubdistrictName());
        userManagementDTO.setDistrictName(employees.getAddresses().getVillageId().getSubdistrictId().getDistrictId().getDistrictName());
        userManagementDTO.setProvinceName(employees.getAddresses().getVillageId().getSubdistrictId().getDistrictId().getProvinceId().getProvinceName());
        return userManagementDTO;
    }
    
        public Employees saveUser(UserManagementDTO userManagementDTO){
        Employees employees = new Employees();
        Addresses addresses = new Addresses();
        Villages villages = new Villages();
        Subdistricts subdistricts = new  Subdistricts();
        Districts districts = new Districts();
        Provinces provinces = new Provinces();
        employees.setPrefix(userManagementDTO.getPrefix());
        employees.setEmployeeId(userManagementDTO.getEmployeeId());
        employees.setEmployeeName(userManagementDTO.getEmployeeName());
        employees.setBirthDate(userManagementDTO.getBirthDate());
        employees.setGender(userManagementDTO.getGender());
        employees.setEmail(userManagementDTO.getEmail());
        employees.setAddresses(addresses);
        addresses.setAddressId(userManagementDTO.getAddressId());
        addresses.setStreet1(userManagementDTO.getStreet1());
        addresses.setStreet2(userManagementDTO.getStreet2());
        addresses.setVillageId(villages);
        villages.setVillageId(userManagementDTO.getVillageId());
        villages.setVillageName(userManagementDTO.getVillageName());
        villages.setZipCode(userManagementDTO.getZipCode());
        villages.setSubdistrictId(subdistricts);
        subdistricts.setSubdistrictId(userManagementDTO.getSubdistrictId());
        subdistricts.setSubdistrictName(userManagementDTO.getSubdistrictName());
        subdistricts.setDistrictId(districts);
        districts.setDistrictId(userManagementDTO.getDistrictId());
        districts.setKab(userManagementDTO.getKab());
        districts.setDistrictName(userManagementDTO.getDistrictName());
        districts.setProvinceId(provinces);
        provinces.setProvinceId(userManagementDTO.getProvinceId());
        provinces.setProvinceName(userManagementDTO.getProvinceName());
        return employees;
    }

    public Employees saveEmployee(UserManagementDTO userManagementDTO){
        Employees employee = new Employees( 
                userManagementDTO.getPrefix(),
                userManagementDTO.getEmployeeId(),
                userManagementDTO.getEmployeeName(),
                userManagementDTO.getBirthDate(),
                userManagementDTO.getGender(),
                userManagementDTO.getEmail(),
                new Addresses(userManagementDTO.getPrefix(),userManagementDTO.getEmployeeId(),
                        new Villages(userManagementDTO.getVillageId())),
                new Educations(userManagementDTO.getPrefix(),userManagementDTO.getEmployeeId(), 
                        new Majors(userManagementDTO.getMajorId()), new Universities(userManagementDTO.getUniversityId())),
                new Contacts(userManagementDTO.getEmployeeId(),userManagementDTO.getPrefix(), userManagementDTO.getPhone(),
                        userManagementDTO.getLinkedin()));
        employeeRepository.save(employee);
        return employee;
                
                
 }
}