package com.example.AdminService.Controller;


import com.example.AdminService.Model.Admin;
import com.example.AdminService.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public Admin register(@RequestBody Admin admin) {
        return adminService.registerAdmin(admin);
    }
}
