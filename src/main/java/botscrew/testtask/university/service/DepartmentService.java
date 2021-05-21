package botscrew.testtask.university.service;

import botscrew.testtask.university.model.Department;
import botscrew.testtask.university.model.DepartmentStatistics;
import botscrew.testtask.university.model.Lector;
import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    void save(Department department);

    Optional<Lector> getDepartmentHead(String departmentName);

    List<DepartmentStatistics> getStatistics(String departmentName);

    Double getAverageSalary(String departmentName);

    Long getEmployeeCount(String departmentName);

    List<Lector> getByTemplate(String template);

}
