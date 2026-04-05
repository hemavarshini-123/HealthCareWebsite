package com.example.AdminService.Service;





import com.example.AdminService.Model.Admin;
import com.example.AdminService.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class AdminDetailsService implements UserDetailsService {
    @Autowired
    private AdminRepository adminRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Admin admin =  adminRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Admin not found"));

        return new org.springframework.security.core.userdetails.User(
                admin.getEmail(),
                admin.getPassword(),
                new ArrayList<>()
        );
    }
}
