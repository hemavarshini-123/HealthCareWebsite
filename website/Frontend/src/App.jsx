import React from "react";
import { BrowserRouter } from "react-router-dom";
import AppRoutes from "./routes";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";

const App = () => {
  return (
    <BrowserRouter>
      <div className="app-container">

        <Navbar />

        <div className="main-content">
          <AppRoutes />
        </div>

        <Footer />

      </div>
    </BrowserRouter>
  );
};

export default App;
