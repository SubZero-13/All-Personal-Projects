const express = require('express');
const route = express.Router()
const services = require("../services/render");

route.get('/', services.homeRoutes);
route.get('/login', services.loginPage);
route.get('/thome', services.teacherHome);
route.get('/update-student', services.updateStudent);
route.get('/student-login', services.studentLogin);
route.get('/student-detail', services.studentResult);
route.post('/edit', services.editStudent);
route.get('/delete/:rollNo', services.deleteStudent);
route.get('/add-student', services.addStudentRedirect);
route.post('/add-student', services.addStudent);
route.get('/student-not-found', services.studentNotFound);
route.get('/500', services.error500);
route.get('/logout', services.logout);
module.exports = route