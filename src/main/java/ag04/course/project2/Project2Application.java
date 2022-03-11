package ag04.course.project2;

import ag04.course.project2.config.SfgConfiguration;
import ag04.course.project2.config.SfgConstructorConfig;
import ag04.course.project2.controllers.LanguageController;
import ag04.course.project2.controllers.*;
import ag04.course.project2.datasource.FakeDataSource;
import ag04.course.project2.services.PrototypeBean;
import ag04.course.project2.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"ag04.course.project2", "ag04.course.language"})
@SpringBootApplication
public class Project2Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Project2Application.class, args);

		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayGreetingI18n());

		System.out.println("------Primary Bean-------");
		LanguageController languageController = (LanguageController) ctx.getBean("languageController");
		System.out.println(languageController.getGreeting());

		System.out.println("------Property-------");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("------Setter-------");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("------Contructor-------");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());


		System.out.println("_________Bean Scopes_________");
		SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getMyScope());
		SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getMyScope());

		PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getMyScope());
		PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean2.getMyScope());

		System.out.println("--------------Fake Data Source-----------------");
		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcurl());


		System.out.println("--------------------Config Props Bean-------------------");
		SfgConfiguration sfgConfiguration = ctx.getBean(SfgConfiguration.class);
		System.out.println(sfgConfiguration.getUsername());
		System.out.println(sfgConfiguration.getPassword());
		System.out.println(sfgConfiguration.getJdbcurl());

		System.out.println("--------------Constructor Binding---------------------");
		SfgConstructorConfig sfgConstructorConfig = ctx.getBean(SfgConstructorConfig.class);
		System.out.println(sfgConstructorConfig.getUsername());
		System.out.println(sfgConstructorConfig.getPassword());
		System.out.println(sfgConstructorConfig.getJdbcurl());
	}

}