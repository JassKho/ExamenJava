package api.application.repository;

import api.application.model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {
    List<Conversation> findByUsername(String username);

    @Query("SELECT DISTINCT c.username FROM Conversation c")
    List<String> findDistinctUsernames();
}