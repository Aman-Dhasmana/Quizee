package com.myProjects.quizApp.Controller;

import com.myProjects.quizApp.Model.Question;
import com.myProjects.quizApp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionControler {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestion();
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("add")
    public String addQuestion(@RequestBody Question question){
        return  questionService.addQuestion(question);
    }

    @DeleteMapping("remove/{id}")
    public String removeQuestionById(@PathVariable Integer id){
        return questionService.removeQuestionById(id);
    }

}
