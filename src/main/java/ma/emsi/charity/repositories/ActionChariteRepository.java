package ma.emsi.charity.repositories;
import ma.emsi.charity.entities.ActionCharite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActionChariteRepository extends JpaRepository<ActionCharite, Long> {
    List<ActionCharite> findByOrganizationId(Long organizationId);
    List<ActionCharite> findByEstArchiveeFalse();
}
