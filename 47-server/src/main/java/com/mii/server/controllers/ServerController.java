/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.entities.Provinces;
import com.mii.server.services.ServerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/province")
public class ServerController {
    @Autowired
    ServerService serverService;
    
    @Autowired
    public ServerController(ServerService serverService) {
        this.serverService = serverService;
    }
    
    /*@GetMapping("")
    public String index (){
        return "hai";
    }*/
    
    @GetMapping("")
    public List<Provinces> readProvince(){
        return serverService.getAll();
        
    }
    
    /*@PostMapping("")
    public List<Provinces> insertProvince(){
        return serverService.insertData();
    }*/
    @PostMapping("/insert")
    public String insertProvince(@RequestBody Provinces provinces){
        serverService.insertData(provinces);
        return "insert";
    }
    
    /*@GetMapping("/update")
    public String updateProvince(Integer id,String name){
        serverService.update(id, name);
        return "berhasil update";
    }*/
    
    /*@PatchMapping("/update/{id}")
    public String updateProvince(@RequestBody Provinces provinces,@PathVariable("id") Integer id, String name){
        serverService.update( id,name);
        return "updated";
    }*/
    
     @PutMapping("/update/{id}")
    public String updateProvince(@PathVariable Integer id,@RequestBody Provinces provinces){
        serverService.getById(id);
        serverService.update(id,provinces);
        return "updated";
    }
    
    
    @DeleteMapping("/{id}")
    public String deleteProvince(@PathVariable Integer id){
        serverService.delete(id);
        return "berhasil hapus";
    }
            
            
   
    
    
    
    
}
