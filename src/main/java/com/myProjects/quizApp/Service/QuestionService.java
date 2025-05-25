package com.myProjects.quizApp.Service;
import com.myProjects.quizApp.Dao.QuestionDao;
import com.myProjects.quizApp.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestion(){
         return questionDao.findAll();
    }

    public List<Question> getQuestionByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "Successfully Added !!";
    }

    public String removeQuestionById(Integer id) {
        questionDao.deleteById(id);
        return "Successfully Removed !!";
    }
}
