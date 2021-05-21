package botscrew.testtask.university.repository;

import botscrew.testtask.university.model.Department;
import botscrew.testtask.university.model.DepartmentStatistics;
import botscrew.testtask.university.model.Lector;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("select d.head from Department d where d.name =?1")
    Optional<Lector> findHeadOfDepartment(String departmentName);

    @Query("select avg(e.salary) from Department d join  d.employees e where d.name=?1")
    Double countAverageSalary(String departmentName);

    @Query("select count (e) from Department d join d.employees e where d.name=?1")
    Long countEmployee(String departmentName);

    @Query("select new botscrew.testtask.university.model.DepartmentStatistics(e.degree, count (e))"
            + " from Department d JOIN d.employees e where d.name = ?1 GROUP BY d, e.degree")
    List<DepartmentStatistics> calculateStatistics(String departmentName);
}
