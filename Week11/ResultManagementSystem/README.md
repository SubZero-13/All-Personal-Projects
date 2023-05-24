# Result Management System

The Result Management System is a web application developed using Angular and JSON Server. It provides a platform for teachers to manage and upload student results, as well as for students to view their own results by searching through their roll number or name.

## Features

- Teacher login: Teachers can log in to the system using their credentials to access the result management features.

- Upload Result: Teachers can upload student results by entering the necessary details such as roll number, name, and marks obtained.

- Edit Result: Teachers have the ability to edit existing student results by selecting the result and updating the marks obtained.

- Delete Result: Teachers can delete student results from the system by selecting the result and confirming the deletion.

- Student Result Search: Students can search for their results by entering their roll number or name in the search bar. The system will display the corresponding result if found.

## Prerequisites

Before running the Result Management System, ensure you have the following software installed:

- Node.js
- Angular CLI
- JSON Server

## Installation

1. Clone the repository:

```bash
git clone https://github.com/your-username/result-management-system.git
```

2. Navigate to the project directory:

```bash
cd result-management-system
```

3. Install the dependencies:

```bash
npm install
```

## Configuration

1. Open the `src/environments/environment.ts` file.

2. Modify the `apiUrl` property to the appropriate API URL where the JSON Server is running. For example:

```typescript
export const environment = {
  production: false,
  apiUrl: 'http://localhost:3000'
};
```

## Running the Application

1. Start the JSON Server:

```bash
json-server --watch db.json
```

2. In a separate terminal window, run the Angular application:

```bash
ng serve
```

3. Open your browser and navigate to `http://localhost:4200` to access the Result Management System.

## Usage

1. As a teacher, navigate to the login page and enter your credentials to log in.

2. Once logged in, you will be redirected to the dashboard where you can perform various result management tasks.

3. To upload a result, click on the "Upload Result" button and fill in the required details in the form.

4. To edit a result, select the result from the list and click on the "Edit" button. Update the marks obtained and click "Save" to apply the changes.

5. To delete a result, select the result from the list and click on the "Delete" button. Confirm the deletion when prompted.

6. As a student, use the search bar on the dashboard to search for your result by entering your roll number or name.

## Contributing

Contributions to the Result Management System are welcome. If you encounter any issues or have suggestions for improvement, please open an issue or submit a pull request on the GitHub repository.

## License

The Result Management System is open-source software licensed under the [MIT license](https://opensource.org/licenses/MIT).

## Acknowledgements

- Angular: https://angular.io
- JSON Server: https://github.com/typicode/json-server

## Contact

For any questions or inquiries, please contact the project maintainers:

- Aniket Kumar (aniket.kumar01@nagarro.com)
