# 📚 Quizee - Quiz Management Backend API

Quizee is a lightweight and modular **Spring Boot** REST API that enables the management of quiz questions categorized by topic and difficulty level. It uses **MySQL** as the database for storing questions and supports full **CRUD** functionality.

> 💡 Currently backend-only. You can test the API using Postman, Swagger, or connect it to your own frontend.

---

## 🚀 Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Maven**

---

## ✨ Features

- Add new quiz questions
- Fetch questions by ID or all questions
- Delete questions
- Categorize by category (Java, Python etc.)

---

## 🧠 Sample Schema

### MySQL Table Creation

```sql
CREATE TABLE questions (
  id INT AUTO_INCREMENT PRIMARY KEY,
  category VARCHAR(50),
  correct_option VARCHAR(100),
  difficulty_level VARCHAR(20),
  option1 VARCHAR(100),
  option2 VARCHAR(100),
  option3 VARCHAR(100),
  option4 VARCHAR(100),
  question_title VARCHAR(255)
);

## 🧪 API Endpoints

Method	Endpoint	Description
GET	/api/question/allQuestions	Get all questions
GET	/api/question/category/{category}	Get a question by categroy
POST	/api/question/add	Create a new question
DELETE	/api/question/remove/{id}	Delete a question by ID

🔮 Future Enhancements
Add user authentication

Implement quiz-taking logic

Track scores and analytics

Frontend integration (React/Next.js/Angular)

🤝 Contributing
Contributions are welcome! Please fork the repo and open a pull request.

📫 Contact
Made with ❤️ by Your Name
🔗 www.linkedin.com/in/amandhasmanaa
