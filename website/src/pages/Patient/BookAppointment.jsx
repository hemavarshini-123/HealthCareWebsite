import { useState } from "react";
import axios from "axios";

const BookAppointment = () => {

  const [formData, setFormData] = useState({
    patientName: "",
    email: "",
    doctorName: "",
    appointmentDate: ""
  });

  const [message, setMessage] = useState("");

  
  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {

      await axios.post(
      //  "http://localhost:8080/api/appointments"
         "http://localhost:8080/appointments",
        formData
      );

      setMessage("Appointment booked successfully!");

      // Reset form
      setFormData({
        patientName: "",
        email: "",
        doctorName: "",
        appointmentDate: ""
      });

    } catch (error) {
      console.error(error);
      setMessage("Failed to book appointment");
    }
  };

  return (

    <form onSubmit={handleSubmit} className="container mt-4">

      <h3 className="mb-4">Book Appointment</h3>

      {message && (
        <div className="alert alert-info">
          {message}
        </div>
      )}

      <input
        type="text"
        name="patientName"
        placeholder="Patient Name"
        className="form-control mb-3"
        value={formData.patientName}
        onChange={handleChange}
        required
      />

      <input
        type="email"
        name="email"
        placeholder="Registered Email"
        className="form-control mb-3"
        value={formData.email}
        onChange={handleChange}
        required
      />

      <input
        type="text"
        name="doctorName"
        placeholder="Doctor Name"
        className="form-control mb-3"
        value={formData.doctorName}
        onChange={handleChange}
        required
      />

      <input
        type="date"
        name="appointmentDate"
        className="form-control mb-3"
        value={formData.appointmentDate}
        onChange={handleChange}
        required
      />

      <button className="btn btn-success w-100">
        Book Appointment
      </button>

    </form>
   
  );
};

export default BookAppointment;
