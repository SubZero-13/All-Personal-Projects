import React from "react";
import { Link } from "react-router-dom";
import "./layout.css"; 
const Footer = () => {
  return (
    <footer
      className="footer text-center p-2"
    >
      © 2023 Copyright:
      <Link className="text-primary text-decoration-none" to="https://www.nagarro.com/en" target="_blank">
        Nagarro.com
      </Link>
    </footer>
  );
};

export default Footer;
