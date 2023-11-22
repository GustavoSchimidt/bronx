package zoologico.bronx.animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zoologico.bronx.animal.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
}

