package ag04.course.project2.services;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    public SingletonBean(){
        System.out.println("Creating a Singleton bean.");
    }

    public String getMyScope(){
        return "I'm a Singeton";
    }
}