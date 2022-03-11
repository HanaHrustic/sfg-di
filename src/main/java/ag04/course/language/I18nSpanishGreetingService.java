package ag04.course.language;

import ag04.course.project2.services.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

public class I18nSpanishGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hola Mondo - ES";
    }
}
