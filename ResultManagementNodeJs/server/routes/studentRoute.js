const express = require("express");
const studentrouter = express.Router();
const studentController = require("../controller/studentController");
const validateToken = require("../middleware/validateTokenHander");


studentrouter.get("/students", validateToken, studentController.getStudents);
studentrouter.get("/students/:rollNo", studentController.getStudent);
studentrouter.post("/students", validateToken, studentController.createStudent);
studentrouter.put("/students/:rollNo", validateToken, studentController.updateStudent);
studentrouter.delete("/students/:rollNo", validateToken, studentController.deleteStudent);

module.exports = studentrouter;
