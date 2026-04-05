package crud.healthcare.Service;

import crud.healthcare.Model.Admin;
import crud.healthcare.Repo.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class AdminDetailsService implements UserDetailsService{
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
