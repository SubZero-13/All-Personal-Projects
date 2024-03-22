const express = require("express");
const router = express.Router();
const { registerTeacher, loginTeacher, currentTeacher }= require("../controller/teacherController");
const validateToken = require("../middleware/validateTokenHander");
// Teacher registration route
router.post("teacher/register", registerTeacher);

// Teacher login route
router.post("/teacher/login", loginTeacher);

// Protected route to get teacher data

router.get("/teacher/current", validateToken, currentTeacher);

module.exports = router;
