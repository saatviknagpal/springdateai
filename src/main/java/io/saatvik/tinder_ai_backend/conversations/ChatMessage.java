/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.saatvik.tinder_ai_backend.conversations;

import java.time.LocalDateTime;

import org.springframework.cglib.core.Local;

/**
 *
 * @author saatv
 */
public record ChatMessage(
    String messageText,
    String profileId,
    LocalDateTime messageTime
) {
    
}
