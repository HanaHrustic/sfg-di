package ag04.course.project2.controllers;

import ag04.course.project2.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LanguageController {
    private final GreetingService greetingService;

    @Autowired
    public LanguageController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
