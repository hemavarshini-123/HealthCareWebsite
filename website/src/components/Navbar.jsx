import React from "react";
import { Link } from "react-router-dom";

function Navbar() {
  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-secondary">
      <div className="container">

        <Link className="navbar-brand" to="/">
          HealthCare
        </Link>

        <div>
          <Link className="btn btn-light me-2" to="/login">
            Patient Login
          </Link>

          <Link className="btn btn-light" to="/admin-login">
            Admin Login
          </Link>
        </div>

      </div>
    </nav>
  );
}

export default Navbar;
