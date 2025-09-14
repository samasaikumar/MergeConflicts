package com.address.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.address.entity.Address;
import com.address.repository.AddressRepo;
import com.address.response.AddressRequest;
import com.address.response.ResponseAddress;


@Service
public class EmployeeAddressService {
	@Autowired
	private AddressRepo addressRepo;
	
	//private Model 
	public ResponseAddress getAddress(final int id)
	{
		Address byEmployeeId = addressRepo.findByEmpId(id);
		ResponseAddress rs = new ResponseAddress();
		BeanUtils.copyProperties(byEmployeeId, rs);
		return rs;
	
	}
	
	public boolean saveAddress(AddressRequest addressRequest)
	{
		Address a = new Address();
		BeanUtils.copyProperties(addressRequest, a);
		addressRepo.save(a);
	    return true;
				
	}

}
