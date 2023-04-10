package com.example.icare.controller;

import com.example.icare.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //is used in REST Web services & mark class as Controller Class
@RequestMapping(path ="api/admin") //is used at the class level while
public class AdminController {
    private final AdminService adminService;
@Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
}
