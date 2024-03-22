const express = require("express");
const dotenv = require("dotenv");
const morgan = require("morgan");
const bodyparser = require("body-parser");
const path = require('path');
const errorHandler = require("./server/middleware/errorHandler");
const connectDb = require("./server/database/dbConnection");
const teacherRoutes = require("./server/routes/teacherRoutes");
const studentrouter = require("./server/routes/studentRoute"); 
const clientRouter = require("./server/routes/clientRoute");
const cookieParser = require('cookie-parser');

dotenv.config();

const app = express();
app.use(cookieParser());

const PORT = process.env.PORT || 8082

connectDb();

// parse request to body-parser
app.use(bodyparser.urlencoded({ extended : true}));

// set view engine
app.set("view engine", "ejs");
app.set("views", path.resolve(__dirname, "views"));

// load assets
app.use('/css', express.static(path.resolve(__dirname, "assets/css")));
app.use('/img', express.static(path.resolve(__dirname, "assets/img")));
app.use('/js', express.static(path.resolve(__dirname, "assets/js")));

app.use(express.json());

// Backend Routes
app.use("/api", studentrouter);
app.use("/api", teacherRoutes);

app.use(errorHandler);

//Frontend Routes
app.use("/", clientRouter);

app.listen(PORT, ()=> { console.log(`Server is running on http://localhost:${PORT}`)});