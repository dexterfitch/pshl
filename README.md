# 🎃 Pumpkin Spice Hit List (PSHL)

**Pumpkin Spice Hit List** is a playful, seasonal-themed project built to demonstrate best practices in React form handling using [React Hook Form](https://react-hook-form.com/). It was created as a teaching tool for students learning to build and validate dynamic forms with clean UX/UI design. Despite the light-hearted concept, the app models production-quality practices around accessibility, layout, and component structure.

---

## Features

- Submit and review pumpkin spice products
- Filter and sort product entries
- Form validation using React Hook Form
- Fully functional REST API built with Spring Boot
- Responsive UI with Bootstrap and custom styles
- Reusable, modular component structure
- Cleanly separated frontend and backend codebases

---

## Tech Stack

### Frontend
- **React**
- **React Hook Form**
- **React-Bootstrap**
- **JavaScript (ES6+)**
- **HTML / CSS**

### Backend
- **Java 17**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **MySQL**
- **Hibernate**

---

## Getting Started

### Prerequisites

Make sure you have the following installed:

- Node.js (v14+)
- npm or yarn
- Java 17+
- MySQL or a compatible database
- Maven

### Running the Frontend

```bash
git clone https://github.com/dexterfitch/pshl.git
cd pshl
npm install
npm start
```

Visit `http://localhost:3000` in your browser to view the app.

---

### Running the Backend

1. Ensure your MySQL database is running and the schema is created.

2. Configure your application.properties file (or use application-dev.properties) to match your DB settings.

3. Run the app:

```bash
cd backend
./mvnw spring-boot:run
```

The API will be available at http://localhost:8080/api.

---

## Project Structure

```
pshl/
├── frontend/                   # React app
│   ├── src/
│   │   ├── components/         # Reusable UI elements
│   │   ├── pages/              # App views (home, form, modal)
│   │   ├── App.js
│   │   └── index.js
├── src/main/java/ce/pshl/      # Spring Boot backend
│   ├── controllers/            # API endpoints
│   ├── data/                   # Repositories
│   ├── domain/                 # Business logic
│   ├── models/                 # Entity definitions
│   └── App.java                # Spring Boot entry point
├── src/main/resources/
│   └── application.properties  # DB and app config
```

---

## Screenshots

**Homepage**  
![PSHL Screenshot 1](https://www.dexfitch.com/media/media/PSHL_1.png)

**Product Grid and Filter**  
![PSHL Screenshot 2](https://www.dexfitch.com/media/media/PSHL_2.png)

**Product Modal**  
![PSHL Screenshot 3](https://www.dexfitch.com/media/media/PSHL_3.png)

**Add New Product Form**  
![PSHL Screenshot 4](https://www.dexfitch.com/media/media/PSHL_4.png)

---

## Educational Goals

This project was built to teach:
- React Hook Form and frontend form validation
- API integration and state management
- Java Spring Boot REST APIs
- Full-stack architecture principles
- Component-based frontend design
- Data modeling with JPA and MySQL

---

## Acknowledgments

Created by me, [Dexter Fitch](https://www.dexfitch.com), with input from [James Churchill](https://smashdev.com/), as a student-facing example app while teaching full-stack development at Dev10. Designed to make learning React forms fun, effective, and memorable.

---

## License

This project is licensed under the [Creative Commons Attribution-NonCommercial 4.0 International License](https://creativecommons.org/licenses/by-nc/4.0/).
