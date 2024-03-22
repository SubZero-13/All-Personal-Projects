const axios = require('axios');
const asyncHandler = require('express-async-handler');
const cookie = require('cookie');
const Student = require('../model/student');

// Renders the index page
exports.homeRoutes = (req, res) => {
    res.render('index');
}

// Renders the teacher login page
exports.loginPage = (req, res) => {
    let errorMessage = req.query.errorMessage || '';
    res.render('teacherLogin', { errorMessage });
}

// Handles teacher's home page
exports.teacherHome = asyncHandler(async (req, res) => {
    let token = req.cookies.token;
    let students = [];
    let name;
    let errorMessage = '';
    if (token) {
        try {
            const response = await axios.get('http://localhost:8081/api/students', {
                headers: {
                    Authorization: `Bearer ${token}`,
                },
            });
            students = response.data;
            const teacher = await axios.get('http://localhost:8081/api/teacher/current', {
                headers: {
                    Authorization: `Bearer ${token}`,
                },
            });

            name = teacher.data.firstName;

            res.render('thome', { students, name });
        } catch (error) {
            if (error.response.status === 401) {
                errorMessage = 'Session Expired, Please Login Again';
                res.render('teacherLogin', { errorMessage });
            } else {
                res.redirect('/500');
            }
        }

    } else {
        errorMessage = 'Please Login';
        res.render('teacherLogin', { errorMessage });
    }
});

// Handles updating student details page
exports.updateStudent = asyncHandler(async (req, res) => {
    let token = req.cookies.token;
    let errorMessage = '';
    if (token) {
        try {
            const rollNo = req.query.rollNo;
            const response = await axios.get(`http://localhost:8081/api/students/${rollNo}`, {
                headers: {
                    Authorization: `Bearer ${token}`,
                }
            });
            const student = response.data;
            res.render("update_student", { student });
            return;
        } catch (err) {
            if (err.response.status === 401) {
                errorMessage = 'Session Expired, Login Again';
                res.render('teacherLogin', { errorMessage });
                return;
            } else if (err.response.status === 404) {
                res.redirect('/student-not-found');
                return;
            } else {
                res.redirect('/500');
                return;
            }
        }
    }

    errorMessage = 'Please Login';
    res.render('teacherLogin', { errorMessage });
});

// Handles student login page
exports.studentLogin = asyncHandler(async (req, res) => {
    res.render('studentLogin');
});

// Handles student result page
exports.studentResult = asyncHandler(async (req, res) => {
    let errorMessage = '';
    let student = null;
    try {
        const rollno = req.query.rollno;
        const dob = req.query.dob;

        // Fetch student data using the provided rollno and dob
        student = await Student.findOne({ rollNo: rollno, dateOfBirth: dob });

        if (student) {
            res.render('student_detail', { student });
        } else {
            res.render('student-not-found');
        }
    } catch (error) {
        res.redirect('/500');
    }
});

// Handles editing student details
exports.editStudent = asyncHandler(async (req, res) => {
    const { rollNo, name, dateOfBirth, score } = req.body;
    let token = req.cookies.token;
    let errorMessage = '';
    if (token) {
        try {
            const response = await axios.put(`http://localhost:8081/api/students/${rollNo}`, {
                name,
                dateOfBirth,
                score
            }, {
                headers: {
                    Authorization: `Bearer ${token}`
                }
            });

            if (response.status === 200) {
                res.redirect('/thome');
            } else {
                errorMessage = 'Failed to update student information';
                res.render('update_student', { errorMessage });
            }
        } catch (err) {
            if (err.response.status === 401) {
                errorMessage = 'Session Expired, Please Login Again';
                res.render('teacherLogin', { errorMessage });
            } else {
                errorMessage = 'Failed to update student information, try again with Valid Information';
                res.render('update_student', { errorMessage });
            }
        }
    } else {
        errorMessage = 'Please Login';
        res.render('teacherLogin', { errorMessage });
    }
});

// Handles add student page redirection
exports.addStudentRedirect = asyncHandler(async (req, res) => {
    let token = req.cookies.token;
    let errorMessage = req.query.errorMessage || '';
    if (token) {
        errorMessage = '';
        res.render('add-student', {errorMessage});
    } else {
        errorMessage = 'Please Login'
        res.render('teacherLogin', { errorMessage });
    }
});

// Handles adding a new student
exports.addStudent = asyncHandler(async (req, res) => {
    let token = req.cookies.token;
    let errorMessage = '';
    if (token) {
        try {
            const response = await axios.post(`http://localhost:8081/api/students`, req.body, {
                headers: {
                    Authorization: `Bearer ${token}`
                }
            });
            if (response.status === 201) {
                res.redirect('/thome');
            }
        } catch (err) {
            if (err.response.status === 403) {
                errorMessage = 'Student Already Exists!';
                res.render('add-student', { errorMessage });
            } else if (err.response.status === 401) {
                errorMessage = 'Session Expired, Please Login Again';
                res.render('teacherLogin', { errorMessage });
            } else {
                res.redirect('/500');
            }
        }
    } else {
        errorMessage = 'Please Login';
        res.render('teacherLogin', { errorMessage });
    }
});

// Handles deleting a student
exports.deleteStudent = asyncHandler(async (req, res) => {
    const rollNo = req.params.rollNo;
    let token = req.cookies.token;
    let errorMessage = '';
    if (token) {
        try {
            const response = await axios.delete(`http://localhost:8081/api/students/${rollNo}`, {
                headers: {
                    Authorization: `Bearer ${token}`
                }
            });
            if (response.status === 200) {
                res.redirect('/thome');
            } else {
                res.status(response.status).json({ error: 'Failed to update student information' });
            }
        } catch (err) {
            if (err.response.status === 401) {
                errorMessage = 'Session Expired, Please Login Again';
                res.render('teacherLogin', { errorMessage });
            } else if (err.response.status === 500) {
                res.redirect('/500');
            } else {
                errorMessage = 'Failed to delete student information, Please try again';
                res.render('thome', { errorMessage });
            }
        }
    } else {
        errorMessage = 'Please Login';
        res.render('teacherLogin', { errorMessage });
    }
});

// Handles student not found page
exports.studentNotFound = asyncHandler(async (req, res) => {
    res.render('student-not-found');
});

// Handles error 500 page
exports.error500 = asyncHandler(async (req, res) => {
    res.render('error500');
});

// Handles teacher logout
exports.logout = asyncHandler(async (req, res) => {
    res.clearCookie('token'); 
    res.redirect('/login');
});
