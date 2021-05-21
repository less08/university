package botscrew.testtask.university;

import botscrew.testtask.university.model.Degree;
import botscrew.testtask.university.model.Department;
import botscrew.testtask.university.model.Lector;
import botscrew.testtask.university.service.DepartmentService;
import botscrew.testtask.university.service.LectorService;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInitializer {
    private final DepartmentService departmentService;
    private final LectorService lectorService;

    @PostConstruct
    private void insertData() {
        Lector lector1 = new Lector();
        lector1.setFirstName("Ivan");
        lector1.setLastName("Petrenko");
        lector1.setSalary(15000D);
        lector1.setDegree(Degree.ASSISTANT);
        lectorService.save(lector1);

        Lector lector2 = new Lector();
        lector2.setFirstName("Oleksandr");
        lector2.setLastName("Pavlov");
        lector2.setSalary(17000D);
        lector2.setDegree(Degree.ASSOCIATE_PROFESSOR);
        lectorService.save(lector2);

        Lector lector3 = new Lector();
        lector3.setFirstName("Victor");
        lector3.setLastName("Zhuk");
        lector3.setSalary(23000D);
        lector3.setDegree(Degree.PROFESSOR);
        lectorService.save(lector3);

        Lector lector4 = new Lector();
        lector4.setFirstName("Oleksii");
        lector4.setLastName("Molchanivskyi");
        lector4.setSalary(20000D);
        lector4.setDegree(Degree.PROFESSOR);
        lectorService.save(lector4);

        Department department1 = new Department();
        department1.setName("FICT");
        department1.setHead(lector2);
        department1.setEmployees(List.of(lector3, lector4));
        departmentService.save(department1);

        Department department2 = new Department();
        department2.setName("FPM");
        department2.setHead(lector3);
        department2.setEmployees(List.of(lector1, lector2, lector3));
        departmentService.save(department2);
    }
}
