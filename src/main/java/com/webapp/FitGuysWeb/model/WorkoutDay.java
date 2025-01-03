package com.webapp.FitGuysWeb.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "workout_days")
public class WorkoutDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String day; // Monday, Tuesday, etc.

    @Column(nullable = false)
    private String bodyPart; // Chest, Back, etc.
}

