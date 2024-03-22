const mongoose = require("mongoose");

const teacherSchema = mongoose.Schema(
  {
    email: {
      type: String,
      required: [true, "Please add the teacher's email address"],
      unique: true, // Ensures that each email address is unique
    },
    firstName: {
      type: String,
      required: [true, "Please add the teacher's first name"],
    },
    lastName: {
      type: String,
      required: [true, "Please add the teacher's last name"],
    },
    password: {
      type: String,
      required: [true, "Please add a password"],
    },
  },
  {
    timestamps: true,
  }
);

module.exports = mongoose.model("Teacher", teacherSchema);
