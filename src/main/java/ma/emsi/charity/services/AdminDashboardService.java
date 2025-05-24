package ma.emsi.charity.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import ma.emsi.charity.repositories.UserRepository;
import ma.emsi.charity.repositories.DonationRepository;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Service
public class AdminDashboardService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DonationRepository donationRepository;

    public long getTotalUsers() {
        // Implémenter la logique pour compter les utilisateurs
        if (userRepository != null) {
            return userRepository.count();
        } else {
            return 0;
        }
    }

    public long getTotalDonations() {
        // Implémenter la logique pour compter les dons
         if (donationRepository != null) {
            return donationRepository.count();
        } else {
            return 0;
        }
    }

    public double getTotalDonationAmount() {
        // Implémenter la logique pour calculer le montant total des dons
         if (donationRepository != null) {
            return donationRepository.findAll().stream()
                    .mapToDouble(donation -> donation.getAmount())
                    .sum();
        } else {
            return 0.0;
        }
    }

    public List<ma.emsi.charity.entities.Donation> getRecentDonations(int limit) {
        if (donationRepository != null) {
            // Assuming your Donation entity has a 'date' field and DonationRepository extends JpaRepository
            // You might need to add a method like 'findAllByOrderByDateDesc' to your DonationRepository
            // For now, let's assume findAll() and sort in service, or you have a custom method
            // A better approach would be to add a method to the repository for efficient fetching
            // Example (requires method in repository): return donationRepository.findTop10ByOrderByDateDesc();
            // Or using PagingAndSortingRepository:
             return donationRepository.findAll(PageRequest.of(0, limit, Sort.by("date").descending())).getContent();

        } else {
            return List.of(); // Return empty list if repository is null
        }
    }

    public List<ma.emsi.charity.entities.Donation> getAllDonations() {
        if (donationRepository != null) {
            return donationRepository.findAll();
        } else {
            return List.of(); // Return empty list if repository is null
        }
    }
} 