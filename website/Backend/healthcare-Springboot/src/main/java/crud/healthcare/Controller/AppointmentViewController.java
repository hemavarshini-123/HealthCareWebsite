package crud.healthcare.Controller;
import org.springframework.ui.Model;
import crud.healthcare.Repo.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class AppointmentViewController {

    @Autowired
    private AppointmentRepository repository;

    @GetMapping("/api/appointments/view")
    public String showAppointments(Model model) {
        model.addAttribute("appointments", repository.findAll());
        return "appointments";  // appointments.html
    }
}