package com.webapp.FitGuysWeb.repo;

import com.webapp.FitGuysWeb.model.UserWorkout;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserWorkoutRepository extends JpaRepository<UserWorkout, Long> {
    List<UserWorkout> findByUserId(Long userId);
    List<UserWorkout> findByUserIdAndExerciseId(Long userId, Long exerciseId);
}

