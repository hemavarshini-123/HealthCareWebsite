import { NavLink } from "react-router-dom";

const AdminSidebar = () => {
  return (
    <div className="bg-secondary text-white p-3 vh-100" style={{ width: "220px" }}>
      <h5 className="mb-4">Admin Menu</h5>

      <NavLink to="requests" className="d-block text-white mb-3">
        Appointment Requests
      </NavLink>

      <NavLink to="manage" className="d-block text-white mb-3">
        Manage Appointments
      </NavLink>

      <NavLink to="doctors" className="d-block text-white">
        Manage Doctors
      </NavLink>
    </div>
  );
};

export default AdminSidebar;
