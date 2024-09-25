/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package io.saatvik.tinder_ai_backend.conversations;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author saatv
 */
public interface ConversationRepository extends MongoRepository<Conversation, String> {

}
