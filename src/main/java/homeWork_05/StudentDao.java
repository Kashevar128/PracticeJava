package homeWork_05;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class StudentDao implements Dao<Student> {

    private EntityManager entityManager;

    public StudentDao() {
        entityManager = MySessionFactory.getEntityManager();
    }

    @Override
    public Student getById(long id) {
        Optional<Student> student = Optional.ofNullable(entityManager.find(Student.class, id));
        if (student.isPresent()) return student.get();
        else throw new RuntimeException("Такого пользователя нет");
    }

    @Override
    public List<Student> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM Student e");
        List<?> resultList = query.getResultList();
        Object o = resultList.get(0);
        if (o instanceof Student) return (List<Student>) resultList;
        else throw new RuntimeException("Ошибка вывода списка");
    }

    @Override
    public void save(Student student) {
        executeInsideTransaction(() -> entityManager.persist(student));
    }

    @Override
    @Transactional
    public void saveAll(List<Student> list) {
        for (int i = 0; i < list.size(); i++) {
            save(list.get(i));
        }
    }

    @Override
    public void update(Student student, Object... params) {
        String name = (String) params[0];
        Integer mark = (Integer) params[1];
        student.setName(Objects.requireNonNull(name, "Name cannot be null"));
        student.setMark(Objects.requireNonNull(mark, "Email cannot be null"));
        executeInsideTransaction(() -> entityManager.merge(student));
    }

    @Override
    public void delete(Student student) {
        executeInsideTransaction(() -> entityManager.remove(student));
    }

    @Override
    public void deleteById(long id) {
        Student student = getById(id);
        delete(student);
    }



    private void executeInsideTransaction(Runnable action) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.run();
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
}
