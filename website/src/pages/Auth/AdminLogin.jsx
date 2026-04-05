/*import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

function AdminLogin() {

  const navigate = useNavigate();

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    // Dummy Admin Authentication
    if (email === "admin@gmail.com" && password === "admin123") {

      alert("Admin Login Successful");

      // ✅ Redirect to Admin Dashboard
      navigate("/admin/dashboard");

    } else {
      alert("Invalid Credentials");
    }
  };

  return (
    <div className="container mt-5" style={{ maxWidth: "400px" }}>
      <h3 className="text-center mb-4">Admin Login</h3>

      <form onSubmit={handleSubmit}>
        <input
          type="email"
          placeholder="Enter Email"
          className="form-control mb-3"
          onChange={(e) => setEmail(e.target.value)}
          required
        />

        <input
          type="password"
          placeholder="Enter Password"
          className="form-control mb-3"
          onChange={(e) => setPassword(e.target.value)}
          required
        />

        <button className="btn btn-warning w-100">
          Login
        </button>
      </form>
    </div>
  );
}

export default AdminLogin;*/

import React from "react";

const AdminLogin = () => {

  const handleAdminLogin = () => {
    window.location.href = "http://localhost:8084/login";
  };

  return (
    <div className=" container text-center mt-5 " style={{width:"400px"}} >
      <h2>Admin Login</h2>
      <button onClick={handleAdminLogin} className=' btn btn-success'>
        Go to Admin Authentication
      </button>
    </div>
  );
};

export default AdminLogin;
