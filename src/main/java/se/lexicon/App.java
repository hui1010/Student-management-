package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.data_access.StudentDAO;
import se.lexicon.models.Student;
import se.lexicon.service.StudentManagement;
import se.lexicon.util.UserInputService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);

//        StudentDAO studentDAO = context.getBean(StudentDAO.class);
//        System.out.println(studentDAO.save(new Student("tom")));

//        UserInputService userInputService = context.getBean(UserInputService.class);
//        System.out.println(userInputService.getString());

        StudentManagement studentManagement = context.getBean(StudentManagement.class);
        Student created = studentManagement.create();
        System.out.println(created);
        context.close();

    }
}
