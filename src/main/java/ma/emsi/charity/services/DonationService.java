package ma.emsi.charity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.emsi.charity.entities.Donation;
import ma.emsi.charity.repositories.DonationRepository;

@Service
public class DonationService {

    @Autowired
    private DonationRepository donationRepository;

    public Donation saveDonation(Donation donation) {
        return donationRepository.save(donation);
    }

    public Iterable<Donation> getAllDonations() {
        return donationRepository.findAll();
    }

    public double getTotalDonationAmount() {
        return donationRepository.findAll().stream()
                .mapToDouble(Donation::getAmount)
                .sum();
    }
} 