import React, { useState } from "react";
import axios from "axios";

const ManageDoctors = () => {

  const [doctor, setDoctor] = useState({
    name: "",
    specialization: ""
  });

  const handleChange = (e) => {
    setDoctor({
      ...doctor,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await axios.post("http://localhost:8080/doctors", doctor);
      alert("Doctor Added");

      setDoctor({ name: "", specialization: "" });

    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div>
      <h3>Manage Doctors</h3>

      <form onSubmit={handleSubmit} className="mt-3">

        <input
          name="name"
          value={doctor.name}
          onChange={handleChange}
          className="form-control mb-2"
          placeholder="Doctor Name"
        />

        <input
          name="specialization"
          value={doctor.specialization}
          onChange={handleChange}
          className="form-control mb-2"
          placeholder="Specialization"
        />

        <button className="btn btn-success">
          Add Doctor
        </button>

      </form>
    </div>
  );
};

export default ManageDoctors;
