package io.saatvik.tinder_ai_backend;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.saatvik.tinder_ai_backend.conversations.ChatMessage;
import io.saatvik.tinder_ai_backend.conversations.Conversation;
import io.saatvik.tinder_ai_backend.conversations.ConversationRepository;
import io.saatvik.tinder_ai_backend.profiles.Gender;
import io.saatvik.tinder_ai_backend.profiles.Profile;
import io.saatvik.tinder_ai_backend.profiles.ProfileRepository;

@SpringBootApplication
public class TinderAiBackendApplication implements CommandLineRunner {

	@Autowired
	private ProfileRepository profileRepository;
	public static void main(String[] args) {
		SpringApplication.run(TinderAiBackendApplication.class, args);
	}

	@Autowired
	private ConversationRepository conversationRepository;

	@Override
	public void run(String... args) {
		Profile profile = new Profile("1", "Saatvik", "Nagpal", 40, "Software Developer","foo.jpg", "Indian",Gender.MALE, "INTP");
		profileRepository.save(profile);
		profileRepository.findAll().forEach(System.out::println);

		Conversation conversation = new Conversation("1", 
			profile.id(), 
			List.of
			(new ChatMessage("Hello", profile.id(), LocalDateTime.now())));
			
		conversationRepository.save(conversation);

		conversationRepository.findAll().forEach(System.out::println);
	}

	

}
