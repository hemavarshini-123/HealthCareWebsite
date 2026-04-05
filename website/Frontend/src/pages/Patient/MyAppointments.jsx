import React, { useState } from "react";
import axios from "axios";

const MyAppointments = ({ patientEmail }) => {

  const [email, setEmail] = useState(patientEmail || "");
  const [appointments, setAppointments] = useState([]);
  const [error, setError] = useState("");
  const fetchAppointments = async () => {

    if (!email) {
      alert("Please enter email");
      return;
    }

    try {
      const requestRes = await axios.get(
        `http://localhost:8080/appointments/patient?email=${email}`
        // `http://localhost:8080/api/appointments/patient?email=${email}`
      );
      const confirmedRes = await axios.get(
        `http://localhost:8080/confirmed?email=${email}`
      //  `http://localhost:8080/api/confirmed?email=${email}`
      );
      const combined = [
        ...requestRes.data,
        ...confirmedRes.data
      ];

      setAppointments(combined);
      setError("");

    } catch (err) {
      console.error(err);
      setError("Failed to fetch appointments");
    }
  };
  // Delete from UI only
  const removeAppointment = (id) => {
    const updatedAppointments = appointments.filter((a) => a.id !== id);
    setAppointments(updatedAppointments);
  };
  return (
    <div className="container mt-4">

      <h3>My Appointments</h3>
      <input
        className="form-control mb-3"
        placeholder="Enter Email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />
      <button
        className="btn btn-primary mb-3"
        onClick={fetchAppointments}
      >
        Fetch
      </button>

      {error && <p style={{ color: "red" }}>{error}</p>}
      <ul className="list-group">

        {appointments.length === 0 && (
          <li className="list-group-item">
            No appointments found
          </li>
        )}

        {appointments.map((a) => (
          <li key={a.id} className="list-group-item">
           <div>
            <b>Doctor:</b> {a.doctorName} <br />

            <b>Date:</b> {a.appointmentDate} <br />

            <b>Time:</b> {a.appointmentTime || "Not fixed"} <br />

            <b>Status:</b>
            <span
              className={
                a.status ? "text-warning" : "text-success"
              }
            >
              {" "}
              {a.status || "Confirmed"}
            </span>
             </div>
             <button
              className="btn btn-sm btn-danger"
              onClick={() => removeAppointment(a.id)}
            >
              &#x2715; 
            </button>
          </li>
        ))}

      </ul>

    </div>
  );
};

export default MyAppointments;
