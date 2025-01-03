package com.webapp.FitGuysWeb.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user_workouts")
public class UserWorkout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @Column(nullable = false)
    private boolean completed; // Tracks if the user completed the exercise
}
