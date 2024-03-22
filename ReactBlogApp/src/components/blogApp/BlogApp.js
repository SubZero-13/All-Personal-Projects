import React from 'react'
import Navbar from '../blogApp/layout/Navbar'
import Footer from '../blogApp/layout/Footer'
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { Outlet } from 'react-router-dom'

const BlogApp = () => {
  return (
    <>
      <Navbar/>
      <Outlet/>
      <ToastContainer position="top-right" autoClose={3000} hideProgressBar />
      <Footer/>
    </>
  )
}

export default BlogApp