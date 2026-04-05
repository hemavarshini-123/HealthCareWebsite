import { Outlet } from "react-router-dom";
import AdminSidebar from "../../components/AdminSidebar";

const AdminDashboard = () => {
  return (
    <div className="d-flex bg-dark-subtle">
      <AdminSidebar />

      <div className="flex-grow-1 p-4">
        <Outlet />
      </div>
    </div>
  );
};

export default AdminDashboard;
