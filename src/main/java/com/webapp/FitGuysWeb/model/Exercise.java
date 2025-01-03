package com.webapp.FitGuysWeb.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "workout_level_id", nullable = false)
    private WorkoutLevel workoutLevel;

    @ManyToOne
    @JoinColumn(name = "workout_day_id", nullable = false)
    private WorkoutDay workoutDay;
}

