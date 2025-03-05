package api.application.service;

import api.application.model.Conversation;
import api.application.repository.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class ConversationService {

    @Autowired
    private ConversationRepository conversationRepository;

    public Conversation saveConversation(String username, String message, String quote) {
        Conversation conversation = new Conversation();
        conversation.setUsername(username);
        conversation.setMessage(message);
        conversation.setQuote(quote);
        conversation.setTimestamp(new Date());
        return conversationRepository.save(conversation);
    }

    public List<Conversation> getConversationsByUsername(String username) {
        return conversationRepository.findByUsername(username);
    }

    public List<String> getDistinctUsernames() {
        return conversationRepository.findDistinctUsernames();
    }
}