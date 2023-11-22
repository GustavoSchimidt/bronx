package zoologico.bronx.zoologico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoologicoRepository extends JpaRepository<Zoologico, Long> {
}

