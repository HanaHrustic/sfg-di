package ag04.course.project2.services;

import org.springframework.stereotype.Service;


public class PropertyInjectedGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello World - Property";
    }
}
