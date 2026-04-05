import React from "react";
import homeImg from "../assets/home.jpg";
import './Home.css';
function Home() {
  return (
   <div className="home-image-container ">
  <img
    src={homeImg}
    alt="Healthcare"
    className="home-image"
  />
 <h1 className="home-title">
    Welcome to Healthcare Website
  </h1>
</div>


  );
}

export default Home;
