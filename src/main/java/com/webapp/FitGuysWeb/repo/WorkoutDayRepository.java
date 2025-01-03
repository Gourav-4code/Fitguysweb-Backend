package com.webapp.FitGuysWeb.repo;

import com.webapp.FitGuysWeb.model.WorkoutDay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutDayRepository extends JpaRepository<WorkoutDay, Long> {
}

