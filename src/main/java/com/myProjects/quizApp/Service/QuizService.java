package com.myProjects.quizApp.Service;

import com.myProjects.quizApp.Dao.QuestionDao;
import com.myProjects.quizApp.Dao.QuizDao;
import com.myProjects.quizApp.Model.Question;
import com.myProjects.quizApp.Model.QuestionWrapper;
import com.myProjects.quizApp.Model.Quiz;
import com.myProjects.quizApp.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
         Optional<Quiz> quiz= quizDao.findById(id);
         List<Question> questionsFroomDB = quiz.get().getQuestions();
         List<QuestionWrapper> questionForUser = new ArrayList<>();

         for(Question q : questionsFroomDB){
             QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
             questionForUser.add(qw);
         }

          return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int result = 0;
        int i=0;

        for (Response response : responses){
            if (response.getResponse().equals(questions.get(i).getCorrectOption()))
                result++;

            i++;
        }
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
