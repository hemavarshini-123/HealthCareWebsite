package crud.healthcare.Controller;
import crud.healthcare.Model.Doctor;
import crud.healthcare.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:5173")
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
