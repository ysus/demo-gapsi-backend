package com.gapsi.repository;

import com.gapsi.model.UserPreference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPreferenceRepository extends JpaRepository<UserPreference, Long> {
    UserPreference findUserPreferenceByUsername(String username);
}
