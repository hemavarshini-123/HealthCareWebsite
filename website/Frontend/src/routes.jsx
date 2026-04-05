import React from "react";
import { Routes, Route } from "react-router-dom";

import Home from "./pages/Home";

// Patient
import PatientDashboard from "./pages/Patient/PatientDashboard";
import BookAppointment from "./pages/Patient/BookAppointment";
import MyAppointments from "./pages/Patient/MyAppointments";
import DoctorsList from "./pages/Patient/DoctorsList";

// Admin
import AdminDashboard from "./pages/Admin/AdminDashboard";
import AppointmentRequests from "./pages/Admin/AppointmentRequests";
import ManageAppointments from "./pages/Admin/ManageAppointments";
import ManageDoctors from "./pages/Admin/ManageDoctors";

// Auth
import Login from "./pages/Auth/Login";
import Register from "./pages/Auth/Register";
import AdminLogin from "./pages/Auth/AdminLogin";

function AppRoutes() {
  return (
    <Routes>
      {/* Public Routes */}
      <Route path="/" element={<Home />} />
      <Route path="/login" element={<Login />} />
      <Route path="/register" element={<Register />} />
      <Route path="/admin-login" element={<AdminLogin />} />

      {/* Patient Routes */}
      <Route path="/patient/dashboard" element={<PatientDashboard />}>
        <Route index element={<BookAppointment />} />  {/* /patient */}
        <Route path="book" element={<BookAppointment />} />  {/* /patient/book */}
        <Route path="appointments" element={<MyAppointments />} />  {/* /patient/appointments */}
        <Route path="doctors" element={<DoctorsList />} />  {/* /patient/doctors */}
      </Route>

      {/* Admin Routes */}
      <Route path="/admin/dashboard" element={<AdminDashboard />}>
        <Route index element={<AppointmentRequests />} />  {/* /admin */}
        <Route path="requests" element={<AppointmentRequests />} />  {/* /admin/requests */}
        <Route path="manage/:id" element={<ManageAppointments />} />  {/* /admin/manage */}
        <Route path="doctors" element={<ManageDoctors />} />  {/* /admin/doctors */}
      </Route>
    </Routes>
  );
}

export default AppRoutes;
