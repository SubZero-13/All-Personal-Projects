const mongoose = require("mongoose");

const studentSchema = mongoose.Schema(
  {
    rollNo: {
      type: String,
      required: true,
      unique: true, // Ensures that each roll number is unique
    },
    name: {
      type: String,
      required: [true, "Please add the student's name"],
    },
    dateOfBirth: {
      type: Date,
      required: [true, "Please add the student's date of birth"],
    },
    score: {
      type: Number,
      required: [true, "Please add the student's score"],
      min: 0, // Minimum value for the score
      max: 100, // Maximum value for the score
    },
  },
  {
    timestamps: true,
  }
);

module.exports = mongoose.model("Student", studentSchema);
