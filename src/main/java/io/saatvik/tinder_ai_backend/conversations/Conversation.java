package io.saatvik.tinder_ai_backend.conversations;

import java.util.List;


public record Conversation(
    String id, 
    String profile, 
    List<ChatMessage> messages
    ) {
    
}
