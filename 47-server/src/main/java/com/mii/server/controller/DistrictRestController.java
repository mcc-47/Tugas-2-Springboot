///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mii.server.controller;
//
//import com.mii.server.entity.Districts;
//import com.mii.server.entity.Provinces;
//import com.mii.server.repositories.DistrictRepository;
//import com.mii.server.repositories.ProvinceRepository;
//import com.mii.server.service.DistrictService;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// *
// * @author MyLaptop
// */
//   @RestController 
//public class DistrictRestController {
//    DistrictService districtService;
//
//    DistrictRepository districtRepository;
//    ProvinceRepository provinceRepository;
//    
//    
//   @Autowired
//   public DistrictRestController(DistrictService districtService){
//       this.districtService = districtService;
//   }
//
//   @PostMapping("/insert")
//   public String saveDistrict(@RequestBody Districts district){
//       if(!provinceRepository.existsById(district.getProvinceId().getProvinceId())){
//           Provinces newProvince = provinceRepository.save(district.getProvinceId());
//           district.setProvinceId(newProvince);
//           return"new province id unfound";
//       }
//       
//     //  districtRepository.findById(district.getDistrictId().
//       
//        Districts newDistrict = districtService.insert(district);
//        System.out.println("");
//        return "insert_district";
//   }
//   
//   @GetMapping("")
//   public String halo(){
//       return"Hello Selamat Malam";
//   }
//   @GetMapping("insert_district")
//   public List<Districts >Districts(){
//       return districtService.insertData();
//   }
//   @GetMapping("update_district")
//    public String updateDistrictName (Integer id, String name){
//        districtService.updateDistrictName(id, name);
//    return "redirect:/";
//    }
//    @GetMapping("/delete")
//    public String deleteDistrictById (Integer id){
//        System.out.println(districtService.deleteDistrictById(id));
//        return "redirect:/"; //localhost:8081/
//    } 
//}
