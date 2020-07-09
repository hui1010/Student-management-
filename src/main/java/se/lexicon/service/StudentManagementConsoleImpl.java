package se.lexicon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.data_access.StudentDAOListImpl;
import se.lexicon.exception.NotYetImplementedException;
import se.lexicon.models.Student;
import se.lexicon.util.ScannerInputService;
import sun.security.krb5.SCDynamicStoreConfig;

import java.util.List;

@Component//@Service // Do Not Forget!
public class StudentManagementConsoleImpl implements StudentManagement {

    private final StudentDAOListImpl studentDAOList;
    private final ScannerInputService scannerInputService;//NullPointerException if forget its constructor

    @Autowired
    public StudentManagementConsoleImpl(StudentDAOListImpl studentDAOList, ScannerInputService scannerInputService) {
        this.studentDAOList = studentDAOList;
        this.scannerInputService = scannerInputService;
    }


    @Override
    public Student create() {

        System.out.println("enter id: ");
        int id = scannerInputService.getInt();
        System.out.println("enter name: ");
        String name = scannerInputService.getString();
        return new Student(id, name);

    }

    @Override
    public Student save(Student student) {
        return studentDAOList.save(student);
    }

    @Override
    public Student find(int id) throws RuntimeException {

        return studentDAOList.find(id);
    }

    @Override
    public Student remove(int id) throws RuntimeException{
        Student student = studentDAOList.find(id);
        studentDAOList.delete(id);
        return student;
    }

    @Override
    public List<Student> findAll() {
        return studentDAOList.findAll();
    }

    @Override
    public Student edit(Student student) {
        throw new NotYetImplementedException("This method is not implemented yet");
    }
}
