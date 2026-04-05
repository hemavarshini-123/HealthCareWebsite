import { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function AppointmentRequests() {

  const [appointments, setAppointments] = useState([]);
  const navigate = useNavigate();

  const fetchPending = async () => {
    const res = await axios.get(
      "http://localhost:8080/appointments/pending"
      // "http://localhost:8080/api/appointments/pending"
    );
    setAppointments(res.data);
  };

  useEffect(() => {
    fetchPending();
  }, []);

  // ⭐ Instead of approving, redirect to Manage page
  const approve = (id) => {
    navigate(`/admin/dashboard/manage/${id}`);
  };

  const reject = async (id) => {
    await axios.put(`http://localhost:8080/appointments/${id}/reject`);
    // await axios.put(`http://localhost:8080/api/appointments/${id}/reject`);
    fetchPending();
  };

  return (
    <div>
      <h2>Pending Appointments</h2>

      {appointments.map((a) => (
        <div key={a.id}>
          <p>{a.patientName}</p>
          <p>{a.doctorName}</p>

          <button onClick={() => approve(a.id)}>Approve</button>
          <button onClick={() => reject(a.id)}>Reject</button>
        </div>
      ))}
    </div>
  );
}

export default AppointmentRequests;
