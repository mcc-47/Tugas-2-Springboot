/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dto.CobaDTO;
import com.mii.server.dto.ProvDisDTO;
import com.mii.server.dto.RegisterDTO;
import com.mii.server.dto.UserDTO;
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
import com.mii.server.repositories.ContactRepository;
import com.mii.server.repositories.DistrictRepository;
import com.mii.server.repositories.EducationRepository;
import com.mii.server.repositories.EmployeeRepository;
import com.mii.server.repositories.MajorRepository;
import com.mii.server.repositories.ProvinceRepository;
import com.mii.server.repositories.SubdistrictRepository;
import com.mii.server.repositories.UniversitiyRepository;
import com.mii.server.repositories.VillageRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Zahra
 */
@Service
public class UserService {
    
    EmployeeRepository employeeRepository;
    ProvinceRepository provinceRepository;
    DistrictRepository districtRepository;
    SubdistrictRepository subdistrictRepository;
    VillageRepository villagerepository;
    AddressRepository addressRepository;
    ContactRepository contactRepository;
    EducationRepository educationRepository;
    MajorRepository majorRepository;
    UniversitiyRepository universityRepository;
    
    @Autowired
    public UserService(EmployeeRepository employeeRepository, ProvinceRepository provinceRepository, DistrictRepository districtRepository, SubdistrictRepository subdistrictRepository, VillageRepository villagerepository, AddressRepository addressRepository, ContactRepository contactRepository, EducationRepository educationRepository, MajorRepository majorRepository, UniversitiyRepository universityRepository) {
        this.employeeRepository = employeeRepository;
        this.provinceRepository = provinceRepository;
        this.districtRepository = districtRepository;
        this.subdistrictRepository = subdistrictRepository;
        this.villagerepository = villagerepository;
        this.addressRepository = addressRepository;
        this.contactRepository = contactRepository;
        this.educationRepository = educationRepository;
        this.majorRepository = majorRepository;
        this.universityRepository = universityRepository;
    }
    
    
    public List<UserDTO> getUser(){
        List<UserDTO> user = new ArrayList<>();
        for (Employees e : employeeRepository.findAll()){
            user.add(new UserDTO(
                    e.getEmployeeId(),
                    e.getEmployeeName(),
                    e.getBirthDate(),
                    e.getGender(),
                    e.getEmail(),
                    e.getEducations().getDegree(),
                    e.getEducations().getMajorId().getMajorName(),
                    e.getEducations().getUniversityId().getUniversityName(),
                    e.getContacts().getPhone(),
                    e.getContacts().getLinkedin(),
                    e.getAddresses().getStreet1(),
                    e.getAddresses().getStreet2(),
                    e.getAddresses().getVillageId().getVillageName(),
                    e.getAddresses().getVillageId().getZipCode(),
                    e.getAddresses().getVillageId().getSubdistrictId().getSubdistrictName(),
                    e.getAddresses().getVillageId().getSubdistrictId().getDistrictId().getKab(),
                    e.getAddresses().getVillageId().getSubdistrictId().getDistrictId().getDistrictName(),
                    e.getAddresses().getVillageId().getSubdistrictId().getDistrictId().getProvinceId().getProvinceName()
            ));
        }
        return user;
    }


    public List<UserDTO> getAllUser(){
        List<UserDTO> user = new ArrayList<>();
        for (Employees e : employeeRepository.findAll()){
            UserDTO u = new UserDTO(
                    e.getEmployeeId(),
                    e.getEmployeeName(),
                    e.getBirthDate(),
                    e.getGender(),
                    e.getEmail(),
                    e.getEducations().getDegree(),
                    e.getEducations().getMajorId().getMajorName(),
                    e.getEducations().getUniversityId().getUniversityName(),
                    e.getContacts().getPhone(),
                    e.getContacts().getLinkedin(),
                    e.getAddresses().getStreet1(),
                    e.getAddresses().getStreet2(),
                    e.getAddresses().getVillageId().getVillageName(),
                    e.getAddresses().getVillageId().getZipCode(),
                    e.getAddresses().getVillageId().getSubdistrictId().getSubdistrictName(),
                    e.getAddresses().getVillageId().getSubdistrictId().getDistrictId().getKab(),
                    e.getAddresses().getVillageId().getSubdistrictId().getDistrictId().getDistrictName(),
                    e.getAddresses().getVillageId().getSubdistrictId().getDistrictId().getProvinceId().getProvinceName()
            );
            user.add(u);
        }
        return user;
    }
    
    public List<ProvDisDTO> getProvDisName(){
        List<ProvDisDTO> pds = new ArrayList<>();        
        for(Districts d : districtRepository.findAll()){
            ProvDisDTO pd= new ProvDisDTO(
                   d.getProvinceId().getProvinceName(),
                   d.getDistrictName()            
            );
            pds.add(pd);
        }
        return pds;
    }


     public List<CobaDTO> getAllCoba(){
        List<CobaDTO> user = new ArrayList<>();
        for (Employees e : employeeRepository.findAll()){
            CobaDTO u = new CobaDTO(
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
            user.add(u);
        }
        return user;
    }
     

    public String register (RegisterDTO registerDTO){
        employeeRepository.save(new Employees(
                "MCC",
                registerDTO.getEmployeeId(), 
                registerDTO.getEmployeeName(), 
                registerDTO.getEmployeeBirthdate(),
                registerDTO.getEmployeeGender(), 
                registerDTO.getEmployeeEmail(),
                new Addresses("MCC",registerDTO.getEmployeeId(),registerDTO.getStreet1(),registerDTO.getStreet2(), new Villages(registerDTO.getVillageId())),
                new Educations("MCC", registerDTO.getEmployeeId(), registerDTO.getDegree(),new Majors(registerDTO.getMajor()), new Universities(registerDTO.getUniversity())),
                new Contacts("MCC",registerDTO.getEmployeeId(),registerDTO.getPhone(),registerDTO.getLinkedin())
        ));
        

        return "registrasi berhasil";
    }
    



}
