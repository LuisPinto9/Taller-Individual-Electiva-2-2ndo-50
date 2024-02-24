package uptc.edu.co.tallerindividualspringbootluispinto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uptc.edu.co.tallerindividualspringbootluispinto.entities.Office;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Integer> {
}
