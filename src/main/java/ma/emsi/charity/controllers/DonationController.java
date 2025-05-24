package ma.emsi.charity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ma.emsi.charity.entities.Donation;
import ma.emsi.charity.services.DonationService;
import java.util.Date;
import java.util.List;

@Controller
public class DonationController {

    @Autowired
    private DonationService donationService;

    @GetMapping("/donate")
    public String showDonationForm(Model model) {
        model.addAttribute("donation", new Donation());
        List<Donation> donations = (List<Donation>) donationService.getAllDonations();
        model.addAttribute("donations", donations);
        return "donation";
    }

    @PostMapping("/donate")
    public String processDonation(@RequestParam("amount") double amount,
                                @RequestParam("name") String name,
                                @RequestParam("email") String email,
                                @RequestParam("message") String message) {
        Donation donation = new Donation();
        donation.setAmount(amount);
        donation.setDate(new Date());
        donation.setName(name);
        donation.setEmail(email);
        donation.setMessage(message);
        
        donationService.saveDonation(donation);
        return "redirect:/donation-success";
    }

    @GetMapping("/donation-success")
    public String showSuccessPage() {
        return "donation-success";
    }
} 