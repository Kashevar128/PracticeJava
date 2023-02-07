package homeWork_05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentApplication {

    public static void main(String[] args) {

        StudentDao studentDao = new StudentDao();

        Student student = new Student("Stark", 5);
        studentDao.save(student);

        Student student1 = new Student("Stark2", 5);
        studentDao.save(student1);

        Student student2 = new Student("Stark3", 5);
        studentDao.save(student2);

        Student student4 = studentDao.getById(3);
        System.out.println(student4);

        studentDao.delete(student4);
        List<Student> all = studentDao.getAll();
        System.out.println(Collections.singletonList(all));

        Student student5 = studentDao.getById(2);
        studentDao.update(student5, "Martin", 3);
        System.out.println(student5);

        List<Student> newStudents = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            int markStud = MyRandom.getIntRand(1, 5);
            Student student6 = new Student("Student" + i, markStud);
            newStudents.add(student6);
        }

        studentDao.saveAll(newStudents);
        System.out.println(Collections.singletonList(studentDao.getAll()));

        MySessionFactory.closeManager();
    }
}
