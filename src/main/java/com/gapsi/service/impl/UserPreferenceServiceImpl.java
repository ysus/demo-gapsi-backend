package com.gapsi.service.impl;

import com.gapsi.model.UserPreference;
import com.gapsi.repository.UserPreferenceRepository;
import com.gapsi.service.UserPreferenceService;
import org.springframework.stereotype.Service;

@Service
public class UserPreferenceServiceImpl implements UserPreferenceService {
    UserPreferenceRepository userPreferenceRepository;

    public UserPreferenceServiceImpl(UserPreferenceRepository userPreferenceRepository) {
        this.userPreferenceRepository = userPreferenceRepository;
    }

    @Override
    public UserPreference getUserPreference(String username) {
        return userPreferenceRepository.findUserPreferenceByUsername(username);
    }
}
