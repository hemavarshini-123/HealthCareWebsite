package com.example.DoctorService.Controller;

import com.example.DoctorService.Model.Doctor;
import com.example.DoctorService.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService ds;

    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor){
        return ds.addDoctor(doctor);
    }

    @GetMapping
    public List<Doctor> getDoctors(){
        return ds.getDoctors();
    }
}
