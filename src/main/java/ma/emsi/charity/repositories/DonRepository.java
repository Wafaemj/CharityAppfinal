package ma.emsi.charity.repositories;

import ma.emsi.charity.entities.Don;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DonRepository extends JpaRepository<Don, Long> {

}