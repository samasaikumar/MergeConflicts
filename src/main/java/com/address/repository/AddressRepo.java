package com.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.address.entity.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

    @Query(value = "SELECT * FROM employeemanagement.address ea JOIN employeemanagement.employee_data ee ON ea.emp_id = ee.employee_id where ea.emp_id=:employeeId", nativeQuery = true)
    Address findByEmpId(@Param("employeeId") int employeeId);
}

