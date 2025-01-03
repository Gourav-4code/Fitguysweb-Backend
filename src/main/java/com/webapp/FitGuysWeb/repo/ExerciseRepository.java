package com.webapp.FitGuysWeb.repo;

import com.webapp.FitGuysWeb.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> findByWorkoutLevelId(Long workoutLevelId);
    List<Exercise> findByWorkoutDayId(Long workoutDayId);
    List<Exercise> findByWorkoutLevelIdAndWorkoutDayId(Long workoutLevelId, Long workoutDayId);
}

