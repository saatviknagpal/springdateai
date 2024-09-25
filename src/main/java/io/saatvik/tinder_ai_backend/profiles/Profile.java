/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.saatvik.tinder_ai_backend.profiles;

/**
 *
 * @author saatv
 */
public record Profile(String id, String firstName, String lastName, int age, String bio, String imageUrl, String ethnicity, Gender gender, String myersBriggsPersonalityType ) {
}
