package botscrew.testtask.university.controller;

import botscrew.testtask.university.model.DepartmentStatistics;
import botscrew.testtask.university.model.Lector;
import botscrew.testtask.university.service.DepartmentService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Controller {
    private final DepartmentService departmentService;

    public String getHeadOfDepartment(String departmentName) {
        Optional<Lector> lector = departmentService.getDepartmentHead(departmentName);
        return lector.map(value -> (value.getFirstName() + " " + value.getLastName()))
            .orElse("not found");
    }

    public String getStatistics(String departmentName) {
        StringBuilder builder = new StringBuilder();
        List<DepartmentStatistics> statistics = departmentService.getStatistics(departmentName);
        for (DepartmentStatistics statistic : statistics) {
            builder.append(statistic.getDegree())
                    .append(" - ")
                    .append(statistic.getCount())
                    .append("\n");
        }
        return builder.toString();
    }

    public String getAverageSalary(String departmentName) {
        return String.valueOf(departmentService.getAverageSalary(departmentName));
    }

    public String getEmployeeCount(String departmentName) {
        return String.valueOf(departmentService.getEmployeeCount(departmentName));
    }

    public String getByTemplate(String template) {
        return departmentService.getByTemplate(template).stream()
            .map(value -> (value.getFirstName() + " " + value.getLastName()))
            .collect(Collectors.joining("\n"));
    }
}
