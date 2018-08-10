package base.students.repositories;

import base.students.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE LOWER(s.firstName) = LOWER(:firstName)")
    public List<Student> find(@Param("firstName") String firstName);
}
