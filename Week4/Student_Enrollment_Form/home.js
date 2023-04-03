var row = 1; // Create row Element which increase by one when a user Enrolled .

// Create An event When A user Click on Enrolled Button and Call Function DisplayDeatils
var Entry = document.getElementById("entry");

Entry.addEventListener("click", DisplayDetails);

//Defination of DisplayDetails Function

function DisplayDetails() {

  // Get all Entry From Form Using Their ID's

  var name = document.getElementById("name").value;
  var email = document.getElementById("email").value;
  var website = document.getElementById("website").value;
  var link = document.getElementById("link").value;

  var skills = document.querySelectorAll('input[type="checkbox"]');


  //Regular Expression From Validation of Website

  var WebLinkRegExp = /^(http[s]?:\/\/){0,1}(www\.){0,1}[a-zA-Z0-9\.\-]+\.[a-zA-Z]{2,5}[\.]{0,1}/;

  var mailformat = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

  // Check validations of Input and Show error messages on validation failure.
  var nameError = document.getElementById("name-error");

  var emailError = document.getElementById("email-error");

  var websiteError = document.getElementById("website-error");

  var linkError = document.getElementById("link-error");

  let isValidName = true;
  let isValidEmail = true;
  let isValidWeb = true;
  let isValidLink = true;

  if (name === "") {
    nameError.textContent = "*Please fill Valid Name";
    event.preventDefault();
    isValidName = false;
  }
  else {
    nameError.textContent = "";
    isValidName = true;
  }
  if (email === "" || !email.match(mailformat)) {
    emailError.textContent = "*Please fill Valid Email Id";
    event.preventDefault();
    isValidEmail = false;
  }
  else {
    emailError.textContent = "";
    isValidEmail = true;
  }

  if (!website || !WebLinkRegExp.test(website)) {
    websiteError.innerHTML = "*Please fill the Valid Website Address";
    event.preventDefault();
    isValidWeb = false;
  }
  else {
    websiteError.textContent = "";
    isValidWeb = true;
  }
  if (!link || !WebLinkRegExp.test(link)) {
    linkError.textContent = "*Please fill the Valid Website Address";
    event.preventDefault();
    isValidLink = false;
  }
  else {
    linkError.textContent = "";
    isValidLink = true;
  }
  if (!isValidName || !isValidEmail || !isValidWeb || !isValidLink) return false;

  var display = document.getElementById("display");

  var newRow = display.insertRow(row); // Create a row Dynamically in Table Which Has Id is display

  fadeIn(newRow);

  var cell1 = newRow.insertCell(0); // Create a column Dynamically in that row  

  var cell2 = newRow.insertCell(1); // Create a column Dynamically in that row

  // GenderDescription is describe User is male or Female (Radio Format)

  // Set default values for male radio button and Java checkbox

  var GenderDescription = "";

  if (document.getElementById("male").checked == true) {

    GenderDescription += "Male";

  } else {

    GenderDescription += "Female";

  }

  // SkillString is Describe All the Skills of User

  var skillString = "";

  for (let i = 0; i < skills.length; i++) {
    if (skills[i].checked) {
      skillString += skills[i].value + ", ";
    }
  }
  // Remove the last comma and space

  skillString = skillString.slice(0, -2);

  //the slice() method is used to remove the last comma and space from the string before it is returned or used further.


  //Create Image Element and Set Attribute Source to Link

  var x = document.createElement("IMG");

  x.setAttribute("src", link);

  name = "<b>" + name + "</b>"; //Bold The Name

  cell1.innerHTML = name + "<br>" + GenderDescription + '<br>' + email + '<br><a href="' + website + '" target="' + website + '">' + website + '</a><br>' + skillString;
  cell2.appendChild(x);
  row++;
  ResetAllDetails();
}

// Clear All The Value From the Input Form

function ResetAllDetails() {
  document.getElementById("name").value = "";
  document.getElementById("email").value = "";
  document.getElementById("website").value = "";
  document.getElementById("link").value = "";
  var radio = document.querySelector('input[type=radio][name=gender]:checked');
  if (radio.checked) {
    radio.checked = false;
    document.getElementById("male").checked = true
  }
  var skills = document.querySelectorAll('input[type="checkbox"]');
  skills[0].checked = true;
  for (var i = 1; i < skills.length; i++) {
    if (skills[i].checked) {
      skills[i].checked = false;
    }
  }
}
//For Fade-In Transition

function fadeIn(el) {
  el.classList.add('show');
  el.classList.remove('hide');
}