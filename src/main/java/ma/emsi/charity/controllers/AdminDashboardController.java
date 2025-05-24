package ma.emsi.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import ma.emsi.charity.services.AdminDashboardService;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {

    @Autowired
    private AdminDashboardService adminDashboardService;

    @GetMapping("/") // Mapping for /admin
    public String redirectToDashboard() {
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Ajouter les données nécessaires au modèle en utilisant adminDashboardService
        model.addAttribute("totalUsers", adminDashboardService.getTotalUsers());
        model.addAttribute("totalDonations", adminDashboardService.getTotalDonations());
        model.addAttribute("totalAmount", adminDashboardService.getTotalDonationAmount());
        model.addAttribute("recentDonations", adminDashboardService.getRecentDonations(10)); // Get latest 10 donations
        return "admin/dashboard";
    }

    @GetMapping("/users")
    public String users(Model model) {
        return "admin/users";
    }

    @GetMapping("/donations")
    public String donations(Model model) {
        List<ma.emsi.charity.entities.Donation> allDonations = (List<ma.emsi.charity.entities.Donation>) adminDashboardService.getAllDonations();
        model.addAttribute("allDonations", allDonations);
        return "admin/donations";
    }

    @GetMapping("/reports")
    public String reports(Model model) {
        return "admin/reports";
    }
} 