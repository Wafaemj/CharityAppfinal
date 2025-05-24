package ma.emsi.charity.repositories;


import ma.emsi.charity.entities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationRepository extends JpaRepository<Organization, Long> {
    // Custom query methods can be added here if needed
}