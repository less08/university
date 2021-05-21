package botscrew.testtask.university.service;

import botscrew.testtask.university.model.Lector;
import botscrew.testtask.university.repository.LectorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LectorServiceImpl implements LectorService {
    private final LectorRepository lectorRepository;

    @Override
    public void save(Lector lector) {
        lectorRepository.save(lector);
    }
}
