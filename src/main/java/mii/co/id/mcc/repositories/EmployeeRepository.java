/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.mcc.repositories;

import mii.co.id.mcc.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ROG
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer>{
    
}