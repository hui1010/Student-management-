package se.lexicon.data_access;

import org.springframework.stereotype.Component;
import se.lexicon.models.Student;

import java.util.ArrayList;
import java.util.List;


@Component
public class StudentDAOListImpl implements StudentDAO {


    List<Student> students = new ArrayList<>();
    @Override
    public Student save(Student student) {

        if (!students.contains(student))
            students.add(student);


        return student;
    }

//    @Override
//    public Student edit(Student student) {
//        Student original = find(student.getId());
//        original.setName(student.getName());
//        return student;
//    }

    @Override
    public Student find(int id) {
        if (id == 0) throw new IllegalArgumentException();
        Student result = null;
        for (Student s : students){
            if (s.getId() == id){
                result = s;
            }else{
                throw new RuntimeException("student doesn't exist");
            }
        }
        return result;

    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void delete(int id) {
        Student student = find(id);
        students.remove(student);
    }
}
