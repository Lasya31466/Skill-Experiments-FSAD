package com.klu;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class App 
{
public static void main(String[] args) 
{
   @SuppressWarnings("resource")
   ApplicationContext context =
                new ClassPathXmlApplicationContext("beanconfig.xml");
	 Student s1=context.getBean("student",Student.class);
	 
        s1.display();
    }
}
