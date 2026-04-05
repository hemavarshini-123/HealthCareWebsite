package com.example.DoctorService.Service;

import com.example.DoctorService.Model.Doctor;
import com.example.DoctorService.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorService {
    @Autowired
    private DoctorRepository dr;
    public Doctor addDoctor(Doctor doctor) {
        return dr.save(doctor);
    }

    public List<Doctor> getDoctors() {
        return dr.findAll();
    }
}
