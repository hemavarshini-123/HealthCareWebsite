import React from "react";
import { NavLink } from "react-router-dom";

const PatientSidebar = () => {
  return (
    <div className="bg-dark text-white p-3 vh-100" style={{ width: "220px" }}>
      <h5 className="mb-4">Patient Menu</h5>

      <NavLink
        to="book"
        className="d-block text-white text-decoration-none mb-3"
      >
        Book Appointment
      </NavLink>

      <NavLink
        to="appointments"
        className="d-block text-white text-decoration-none mb-3"
      >
        My Appointments
      </NavLink>

      <NavLink
        to="doctors"
        className="d-block text-white text-decoration-none"
      >
        Available Doctors
      </NavLink>
    </div>
  );
};

export default PatientSidebar;
