import React from "react";
import { Link } from "react-router-dom";
const Navbar = () => {
  return (
    <nav
      className="navbar navbar-expand-lg d-flex justify-content-between align-items-center"
    >
      <Link className="navbar-logo m-2 font-weight-bolder" to="/">
        Nagarro Blog
      </Link>
      <div className="d-flex">
        <div className="ml-auto">
          <Link className="navbar-link m-2" to="/">
            Home
          </Link>
        </div>
        <div>
          <Link className="navbar-link m-2" to="/add-blog">
            Add Post
          </Link>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
