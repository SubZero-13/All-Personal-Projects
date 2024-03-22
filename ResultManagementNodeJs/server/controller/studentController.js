const asyncHandler = require("express-async-handler");
const Student = require("../model/student");

//@desc Get all students
//@route GET /api/students
//@access private
const getStudents = asyncHandler(async (req, res) => {
  const students = await Student.find({}, "rollNo name dateOfBirth score -_id");
  res.status(200).json(students);
});


//@desc Create a new student
//@route POST /api/students
//@access private
const createStudent = asyncHandler(async (req, res) => {
  const { rollNo, name, dateOfBirth, score } = req.body;

  if (!rollNo || !name || !dateOfBirth || !score) {
    res.status(400);
    throw new Error("All fields are mandatory !");
  }

  // Check if a student with the same roll number already exists
  const existingStudent = await Student.findOne({ rollNo });

  if (existingStudent) {
    res.status(403);
    throw new Error("Student already exists with the same roll number");
  }

  const student = await Student.create({
    rollNo,
    name,
    dateOfBirth,
    score
  });

  res.status(201).json(student);
});

//@desc Get a student
//@route GET /api/students/:id
//@access private
const getStudent = asyncHandler(async (req, res) => {
  const rollNo = req.params.rollNo;
  const student = await Student.findOne({ rollNo }, "rollNo name dateOfBirth score -_id");
  if (!student) {
    res.status(404);
    throw new Error("Student not found");
  }
  res.status(200).json(student);
});

//@desc Update a student
//@route PUT /api/students/:id
//@access private
const updateStudent = asyncHandler(async (req, res) => {
  const rollNo = req.params.rollNo;
  const updatedStudent = await Student.findOneAndUpdate(
    { rollNo },
    req.body,
    { new: true }
  );

  if (!updatedStudent) {
    res.status(404);
    throw new Error("Student not found");
  }
  res.status(200).json(updatedStudent);
});


//@desc Delete a student
//@route DELETE /api/students/:id
//@access private
const deleteStudent = asyncHandler(async (req, res) => {
  const rollNo = req.params.rollNo;
  const deletedStudent = await Student.findOneAndDelete({ rollNo });

  if (!deletedStudent) {
    res.status(404);
    throw new Error("Student not found");
  }
  res.status(200).json(deletedStudent);
});

module.exports = {
  getStudents,
  createStudent,
  getStudent,
  updateStudent,
  deleteStudent,
};
