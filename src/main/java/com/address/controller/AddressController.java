package com.address.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.address.response.AddressRequest;
import com.address.response.ResponseAddress;
import com.address.service.EmployeeAddressService;

@RestController
public class AddressController {
	@Autowired
	private EmployeeAddressService employeeAddressService;
	
	@GetMapping("/get/address/{id}")
    public ResponseEntity<ResponseAddress>	getEmployeeAddressController(@PathVariable int id)
    {
		ResponseAddress address = employeeAddressService.getAddress(id);
		System.out.println("merge conflicts");
		return ResponseEntity.status(HttpStatus.OK).body(address);
		
	
    	
    }
	
	@PostMapping("/address")
	public ResponseEntity<String> saveRecord(@RequestBody AddressRequest addressRequest)
	{
		boolean saveAddress = employeeAddressService.saveAddress(addressRequest);
		return new ResponseEntity<String>("data saved",HttpStatus.CREATED);
	}
	

}
