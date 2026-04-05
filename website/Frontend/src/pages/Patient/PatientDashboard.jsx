import React from "react";
import { Outlet } from "react-router-dom";
import PatientSidebar from "../../components/PatientSidebar";

const PatientDashboard = () => {
  return (
    <div className="d-flex bg-dark-subtle">
     
      <PatientSidebar />

      <div className="flex-grow-1 p-4">
        <Outlet />
      </div>

    </div>
  );
};

export default PatientDashboard;
