package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.service.QuestionServices;

@RestController
@RequestMapping("/exam")
public class ExamController {

//    /exam/get/{amount}
//    @GetMapping("/get")
//    QuestionServices addQuestion(@RequestParam("amount") Integer amount) {
//
//        return null;
//    }
}
