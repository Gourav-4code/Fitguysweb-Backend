package com.webapp.FitGuysWeb.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "workout_levels")
public class WorkoutLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name; // Beginner, Intermediate, Advanced
}

