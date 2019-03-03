package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Admin;
import com.example.Service.AdminService;

@Service(value="com.example.Service")
@RestController
public class AdminController {
 @Autowired 
 AdminService adminService;
 
 @PostMapping("/saveAdmin")
 public Admin saveAdmin(@RequestBody Admin admin)
 {
	 return adminService.save(admin);
 }
 
 
 
 
}
