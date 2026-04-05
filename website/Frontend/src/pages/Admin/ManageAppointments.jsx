import React, { useState } from "react";
import axios from "axios";
import { useParams, useNavigate } from "react-router-dom";

const ManageAppointments = () => {

  const { id } = useParams();
  const navigate = useNavigate();

  const [time, setTime] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {

      const formattedTime = time + ":00";

      await axios.post(
        `http://localhost:8080/confirmed/${id}`,
      //  `http://localhost:8080/api/confirmed/${id}`,
        {
          appointmentTime: formattedTime
        }
      );

      alert("Appointment Confirmed Successfully");
      navigate("/admin/dashboard/requests");

    } catch (error) {
      console.error(error);
      alert("Failed to confirm appointment");
    }
  };

  return (
    <div className="bg-black-subtle">
      <h3>Fix Appointment</h3>

      <form className="mt-3" onSubmit={handleSubmit}>

        <input
          type="time"
          className="form-control mb-2"
          value={time}
          onChange={(e) => setTime(e.target.value)}
          required
        />

        <button className="btn btn-primary">
          Confirm Appointment
        </button>

      </form>
    </div>
  );
};

export default ManageAppointments;
