package api.application.controller;

import api.application.model.Conversation;
import api.application.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class ConversationController {

    @Autowired
    private ConversationService conversationService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("conversation", new Conversation());
        return "index";
    }

    @PostMapping("/sendMessage")
    public String sendMessage(@RequestParam String username, @RequestParam String message, Model model) {
        String quote = restTemplate.getForObject("http://localhost:8080/getQuote", String.class);
        conversationService.saveConversation(username, message, quote);
        model.addAttribute("quote", quote);
        return "index";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("usernames", conversationService.getDistinctUsernames());
        return "admin";
    }

    @GetMapping("/admin/conversation/{username}")
    public String viewConversation(@PathVariable String username, Model model) {
        model.addAttribute("conversations", conversationService.getConversationsByUsername(username));
        return "conversation";
    }
}