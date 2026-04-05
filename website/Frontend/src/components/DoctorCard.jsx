import React from "react";

function DoctorCard({ name, specialization, experience }) {
  return (
    <div className="card shadow-sm mb-3">
      <div className="card-body">
        <h5>{name}</h5>
        <p>Specialization: {specialization}</p>
        <p>Experience: {experience} years</p>
      </div>
    </div>
  );
}

export default DoctorCard;
