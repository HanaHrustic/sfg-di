package ag04.course.project2.config;

import ag04.course.language.I18nEnglishGreetingService;
import ag04.course.language.I18nSpanishGreetingService;
import ag04.course.pets.PetService;
import ag04.course.pets.PetServiceFactory;
import ag04.course.project2.datasource.FakeDataSource;
import ag04.course.project2.repositories.EnglishGreetingRepository;
import ag04.course.project2.repositories.EnglishGreetingRepositoryImpl;
import ag04.course.project2.services.ConstructorInjectedGreetingService;
import ag04.course.project2.services.PrimaryGreetingService;
import ag04.course.project2.services.PropertyInjectedGreetingService;
import ag04.course.project2.services.SetterInjectedGreetingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:stgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

     @Bean
    FakeDataSource fakeDataSource(@Value("${guru.username}")String username,
                                  @Value("${guru.password}")String password,
                                  @Value("${guru.jdbcurl}")String jdbcurl){
         FakeDataSource fakeDataSource = new FakeDataSource();
         fakeDataSource.setUsername(username);
         fakeDataSource.setPassword(password);
         fakeDataSource.setJdbcurl(jdbcurl);
         return fakeDataSource;
     }

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService(){
        return new I18nSpanishGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

    //defined inside xml file
    //@Bean
    /*ConstructorInjectedGreetingService constructorInjectedGreetingService(){
        return new ConstructorInjectedGreetingService();
    }*/

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }
}
