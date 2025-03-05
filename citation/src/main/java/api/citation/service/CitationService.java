package api.citation.service;

import api.citation.model.Citation;
import api.citation.repository.CitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CitationService {

    @Autowired
    private CitationRepository citationRepository;

    private final Random random = new Random();

    public Citation getRandomCitation() {
        List<Citation> citations = citationRepository.findAll();
        if (citations.isEmpty()) {
            return null;
        }
        return citations.get(random.nextInt(citations.size()));
    }
}
