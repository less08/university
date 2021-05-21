package botscrew.testtask.university.repository;

import botscrew.testtask.university.model.Lector;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LectorRepository extends JpaRepository<Lector, Long> {
    @Query("select l from Lector l where lower(l.lastName) like lower(concat('%', ?1,'%'))"
            + " or lower(l.firstName) like lower(concat('%', ?1,'%'))")
    List<Lector> searchByTemplate(String template);
}
