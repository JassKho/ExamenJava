package api.citation.controller;

import api.citation.model.Citation;
import api.citation.service.CitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CitationController {

    @Autowired
    private CitationService citationService;

    @GetMapping("/getQuote")
    public String getRandomCitation() {
        Citation citation = citationService.getRandomCitation();
        if (citation == null) {
            return "Aucune citation disponible.";
        }
        return citation.getAuteur() + " : " + citation.getTexte();
    }
}
