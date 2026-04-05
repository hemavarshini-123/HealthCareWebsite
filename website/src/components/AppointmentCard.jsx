import React from "react";

function AppointmentCard({ patient, doctor, date, status }) {
  return (
    <div className="card shadow-sm mb-3">
      <div className="card-body">
        <h5>{doctor}</h5>
        <p>Patient: {patient}</p>
        <p>Date: {date}</p>
        <span className="badge bg-primary">{status}</span>
      </div>
    </div>
  );
}

export default AppointmentCard;
