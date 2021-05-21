package botscrew.testtask.university.service;

import botscrew.testtask.university.model.Department;
import botscrew.testtask.university.model.DepartmentStatistics;
import botscrew.testtask.university.model.Lector;
import botscrew.testtask.university.repository.DepartmentRepository;
import botscrew.testtask.university.repository.LectorRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final LectorRepository lectorRepository;

    @Override
    public void save(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public Optional<Lector> getDepartmentHead(String departmentName) {
        return departmentRepository.findHeadOfDepartment(departmentName);
    }

    @Override
    public List<DepartmentStatistics> getStatistics(String departmentName) {
        return departmentRepository.calculateStatistics(departmentName);
    }

    @Override
    public Double getAverageSalary(String departmentName) {
        return departmentRepository.countAverageSalary(departmentName);
    }

    @Override
    public Long getEmployeeCount(String departmentName) {
        return departmentRepository.countEmployee(departmentName);
    }

    @Override
    public List<Lector> getByTemplate(String template) {
        return lectorRepository.searchByTemplate(template);
    }
}
