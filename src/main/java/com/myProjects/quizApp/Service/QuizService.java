package com.myProjects.quizApp.Service;

import com.myProjects.quizApp.Dao.QuestionDao;
import com.myProjects.quizApp.Dao.QuizDao;
import com.myProjects.quizApp.Model.Question;
import com.myProjects.quizApp.Model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(String category, int noQ, String title) {
      List<Question> questions = questionDao.findQuestionByCategory(category,noQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

       return new ResponseEntity<>("Success !!", HttpStatus.CREATED);
    }
}
