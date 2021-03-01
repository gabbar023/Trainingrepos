package com.rakuten.training.dal;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.training.domain.Customer;
import com.rakuten.training.dal.CustomerDAO;

@RestController
public class CustomerController 
{
	 @Autowired
	    CustomerDAO service;
	    
	    @GetMapping("/customers")
	    public List<Customer> getAllCustomers(){
	        return service.findAll();
	    }
	    
	    @GetMapping("/customers/{id}")
	    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int pid) {
	        Customer c = service.findById(pid);
	        if(c != null) {
	            return new ResponseEntity<Customer>(c, HttpStatus.OK);
	        }else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    @GetMapping("/customers/{name}")
	    public ResponseEntity<List> getCustomerByName(@PathVariable("name") String pname) {
	        List<Customer> c = service.findByFirstName(pname);
	        if(c != null) {
	            return new ResponseEntity<>(c,HttpStatus.OK);
	        }else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    
	    @DeleteMapping("/customers/{id}")
	    public void removeExisting(@PathVariable("id") int pid)
	    {
	    	 service.deleteById(pid);
	    }
//	        {
//	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	        }
//
//	        return new ResponseEntity<>(HttpStatus.OK);
//	    }
	    
	    @PostMapping("/customers")
	    public ResponseEntity addNewProduct(@RequestBody Customer toBeAdded) {
	        try
	        {
	        	Customer c = service.save(toBeAdded);
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(URI.create("/customers/"+c.getId()));
	        return new ResponseEntity<>(headers,HttpStatus.CREATED);
	        }
	        catch(IllegalArgumentException e)
	        {
	        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
}
