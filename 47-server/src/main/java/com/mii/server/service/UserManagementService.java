/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.service;
import com.mii.server.dtos.UserManagementDTO;
import com.mii.server.entity.Addresses;
import com.mii.server.entity.Contacts;
import com.mii.server.entity.Districts;
import com.mii.server.entity.Educations;
import com.mii.server.entity.Employees;
import com.mii.server.entity.Majors;
import com.mii.server.entity.Provinces;
import com.mii.server.entity.Subdistricts;
import com.mii.server.entity.Universities;
import com.mii.server.entity.Villages;
import com.mii.server.repositories.AddresessRepository;
import com.mii.server.repositories.DistrictRepository;
import com.mii.server.repositories.EmployeeRepository;
import com.mii.server.repositories.ProvinceRepository;
import com.mii.server.repositories.SubdistrictRepository;
import com.mii.server.repositories.VillagesRepository;
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
    AddresessRepository addressRepository;
    VillagesRepository villageRepository;
    SubdistrictRepository subdistrictRepository;
    DistrictRepository districtRepository;
    ProvinceRepository provinceRepository;
    @Autowired
    EmpService employeeService;

    public UserManagementService(EmployeeRepository employeeRepository, AddresessRepository addressRepository, VillagesRepository villageRepository, SubdistrictRepository subdistrictRepository, DistrictRepository districtRepository, ProvinceRepository provinceRepository) {
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
            e.getAddresses().getVillageId().getSubdistrictId().getDistrictId().getKotakab(),
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
        districts.setKotakab(userManagementDTO.getKab());
        districts.setDistrictName(userManagementDTO.getDistrictName());
        districts.setProvinceId(provinces);
        provinces.setProvinceId(userManagementDTO.getProvinceId());
        provinces.setProvinceName(userManagementDTO.getProvinceName());
        return employees;
    }

//    public Employees saveEmployee(UserManagementDTO userManagementDTO){
//        Employees employee = new Employees( 
//                userManagementDTO.getPrefix(),
//                userManagementDTO.getEmployeeId(),
//                userManagementDTO.getEmployeeName(),
//                userManagementDTO.getBirthDate(),
//                userManagementDTO.getGender(),
//                userManagementDTO.getEmail(),
//                new Addresses(userManagementDTO.getPrefix(),userManagementDTO.getEmployeeId(),
//                        new Villages(userManagementDTO.getVillageId())),
//                new Educations(userManagementDTO.getPrefix(),userManagementDTO.getEmployeeId(), 
//                        new Majors(userManagementDTO.getMajorId()), new Universities(userManagementDTO.getUniversityId())),
//                new Contacts(userManagementDTO.getEmployeeId(),userManagementDTO.getPrefix(), userManagementDTO.getPhone(),
//                        userManagementDTO.getLinkedin()));
//        employeeRepository.save(employee);
//        return employee;
//                
//                
// }
}

