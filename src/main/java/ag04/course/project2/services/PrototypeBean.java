package ag04.course.project2.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class PrototypeBean {

    public PrototypeBean(){
        System.out.println("_________Creating a Prototype bean._____________");
    }

    public String getMyScope(){
        return "I'm a Singeton";
    }
}
