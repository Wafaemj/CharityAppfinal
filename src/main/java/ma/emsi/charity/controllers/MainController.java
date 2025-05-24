package ma.emsi.charity.controllers;

import ma.emsi.charity.repositories.DonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final DonRepository donRepository;

    public MainController(DonRepository donRepository) {
        this.donRepository = donRepository;
    }

    // Afficher la page d'accueil
    @GetMapping("/")
    public String accueil() {
        return "index";  // Page d'accueil
    }

    // Afficher la liste des dons (changer l'URL pour éviter le conflit)
    @GetMapping("/accueil/dons")
    public String afficherDons(Model model) {
        model.addAttribute("dons", donRepository.findAll());  // Récupère tous les dons
        return "liste";  // Affiche la liste des dons
    }

    // Afficher la liste des médias (exemple)
    @GetMapping("/accueil/medias")
    public String afficherMedias() {
        // Ajouter la logique pour afficher les médias ici
        return "medias";  // Nom de la page pour afficher les médias (à créer)
    }

    // Afficher la liste des organisations (exemple)
    @GetMapping("/accueil/organisations")
    public String afficherOrganisations() {
        // Ajouter la logique pour afficher les organisations ici
        return "organisations";  // Nom de la page pour afficher les organisations (à créer)
    }
}