package botscrew.testtask.university.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepartmentStatistics {
    private Degree degree;
    private Long count;
}
