/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.saatvik.tinder_ai_backend.conversations;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.saatvik.tinder_ai_backend.profiles.ProfileRepository;

/**
 *
 * @author saatv
 */
@RestController
public class ConversationController {

    private final ConversationRepository ConversationRepository;
    private final ProfileRepository ProfileRepository;

    public ConversationController(ConversationRepository ConversationRepository, ProfileRepository ProfileRepository) {
        this.ConversationRepository = ConversationRepository;
        this.ProfileRepository = ProfileRepository;
    }

    @PostMapping("/conversations")
    public Conversation createNewConversation(@RequestBody CreateConversationRequest request) {
        System.out.println("Received profileId: " + request.profileId());
    
        if (request.profileId() == null || request.profileId().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Profile ID must not be null or empty");
        }
    
        var profile = ProfileRepository.findById(request.profileId())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found"));
            
        System.out.println("Profile found: " + profile.id());
    
        Conversation conversation = new Conversation(
            UUID.randomUUID().toString(),
            request.profileId(), 
            new ArrayList<>()
        );
    
        ConversationRepository.save(conversation);
        return conversation;
    }

    @PostMapping("/conversations/{conversationId}")
    public Conversation addMessageToConversation(@PathVariable String conversationId, @RequestBody ChatMessage chatMessage){
        var conversation = ConversationRepository.findById(conversationId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conversation not found"));
        
        
        ProfileRepository.findById(chatMessage.authorId())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found"));
             
        ChatMessage messageWithTime = new ChatMessage(chatMessage.messageText(), chatMessage.authorId(), java.time.LocalDateTime.now());

        conversation.messages().add(messageWithTime);
        ConversationRepository.save(conversation);
        return conversation;
    }

    public record CreateConversationRequest(
        String profileId
    ){

        public String profileId() {
            return profileId;
        }}
}
