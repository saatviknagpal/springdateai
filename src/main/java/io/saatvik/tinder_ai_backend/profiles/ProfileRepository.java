/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.saatvik.tinder_ai_backend.profiles;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author saatv
 */
public interface ProfileRepository extends MongoRepository<Profile, String> {
    
}
