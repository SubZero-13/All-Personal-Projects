const asyncHandler = require('express-async-handler');
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');
const Teacher = require('../model/teacher');
const cookie = require('cookie');

//@desc Register a new teacher
//@route POST /api/teacher/register
//@access Public
const registerTeacher = asyncHandler(async (req, res) => {
    const { email, firstName, lastName, password } = req.body;
    if (!firstName || !lastName || !email || !password) {
        res.status(400);
        throw new Error('All fields are mandatory!');
    }

    const teacherAvailable = await Teacher.findOne({ email });
    if (teacherAvailable) {
        res.status(403);
        throw new Error('Teacher already registered!');
    }

    // Hash the password
    const hashedPassword = await bcrypt.hash(password, 10);

    // Create the teacher record with hashed password
    const teacher = await Teacher.create({
        email,
        firstName,
        lastName,
        password: hashedPassword, // Store the hashed password in the database
    });

    if (teacher) {
        res.status(201).json({ _id: teacher.id, email: teacher.email });
    } else {
        res.status(400);
        throw new Error('Teacher data is not valid');
    }
});


//@desc Login as a teacher
//@route POST /api/teacher/login
//@access Public
const loginTeacher = asyncHandler(async (req, res) => {
    const { email, password } = req.body;
    if (!email || !password) {
        res.status(400);
        throw new Error('All fields are mandatory!');
    }

    const teacher = await Teacher.findOne({ email });

    if (teacher) {
        const isPasswordValid = await bcrypt.compare(password, teacher.password);
        if (isPasswordValid) {
            const accessToken = jwt.sign(
                {
                    teacher: {
                        email: teacher.email,
                    },
                },
                process.env.ACCESS_TOKEN_SECRET,
                { expiresIn: '1h' }
            );
            // console.log(accessToken);
            res.cookie('token', accessToken);
            res.status(200).json({
                accessToken,
                name: teacher.firstName + ' ' + teacher.lastName,
                email: teacher.email,
            });
        } else {
            res.status(401);
            throw new Error('Email or password is not valid');
        }
    } else {
        res.status(401);
        throw new Error('Email or password is not valid');
    }
});



//@desc Get current teacher's details
//@route GET /api/teacher/current
//@access Private
const currentTeacher = asyncHandler(async (req, res) => {
    const email = req.teacher.email;
    // Fetch teacher details based on the email
    const teacher = await Teacher.findOne({ email });

    if (teacher) {
        res.json({
            firstName: teacher.firstName,
            lastName: teacher.lastName,
            email: teacher.email,
        });
    } else {
        res.status(404);
        throw new Error("Teacher not found");
    }
});

module.exports = { registerTeacher, loginTeacher, currentTeacher };
