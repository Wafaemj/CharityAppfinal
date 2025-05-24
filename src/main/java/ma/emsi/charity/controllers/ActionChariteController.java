package ma.emsi.charity.controllers;

import  ma.emsi.charity.dto.ActionChariteDTO;
import ma.emsi.charity.entities.Organization;
import ma.emsi.charity.repositories.OrganisationRepository;
import ma.emsi.charity.services.ActionChariteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/actions")
public class ActionChariteController {

    @Autowired
    private ActionChariteService service;

    @Autowired
    private OrganisationRepository orgRepo;

    // 🌐 Formulaire d'ajout (interface HTML)
    @GetMapping("/ajouter")
    public String showForm(Model model) {
        model.addAttribute("action", new ActionChariteDTO());
        List<Organization> orgs = orgRepo.findAll();
        model.addAttribute("organisations", orgs);
        return "ajouter-action";
    }

    // 📥 Enregistrement de l'action (formulaire)
    @PostMapping("/save")
    public String saveAction(@ModelAttribute("action") ActionChariteDTO dto) {
        service.createAction(dto);
        return "redirect:/actions/liste?success";
    }

    // 📋 Affichage de la liste des actions (HTML)
    @GetMapping("/liste")
    public String afficherListe(Model model) {
        List<ActionChariteDTO> actions = service.getAllActions();
        model.addAttribute("actions", actions);
        return "liste-actions";
    }

    // 🔁 Modifier une action (REST)
    @ResponseBody
    @PutMapping("/api/{id}")
    public ActionChariteDTO updateAction(@PathVariable Long id, @RequestBody ActionChariteDTO dto) {
        return service.updateAction(id, dto);
    }

    // ❌ Supprimer une action (REST)
    @ResponseBody
    @DeleteMapping("/api/{id}")
    public void deleteAction(@PathVariable Long id) {
        service.deleteAction(id);
    }

    // 🔄 Obtenir toutes les actions (REST - JSON)
    @ResponseBody
    @GetMapping("/api")
    public List<ActionChariteDTO> getAllActions() {
        return service.getAllActions();
    }

    // 🔍 Obtenir une action spécifique (REST - JSON)
    @ResponseBody
    @GetMapping("/api/{id}")
    public ActionChariteDTO getActionById(@PathVariable Long id) {
        return service.getById(id);
    }
}
