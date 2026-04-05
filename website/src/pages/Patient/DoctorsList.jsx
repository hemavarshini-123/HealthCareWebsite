import React, { useEffect, useState } from "react";
import axios from "axios";

const DoctorsList = () => {

  const [doctors, setDoctors] = useState([]);

  useEffect(() => {
    fetchDoctors();
  }, []);

  const fetchDoctors = async () => {
    try {
      const res = await axios.get("http://localhost:8080/doctors");
      setDoctors(res.data);
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div>
      <h3>Available Doctors</h3>

      {doctors.map((doc) => (
        <div className="card mt-3" key={doc.id}>
          <div className="card-body">
            <h5>{doc.name}</h5>
            <p>Specialization: {doc.specialization}</p>
          </div>
        </div>
      ))}

    </div>
  );
};

export default DoctorsList;
