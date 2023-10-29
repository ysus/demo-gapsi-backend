package com.gapsi.controller;

import com.gapsi.model.UserPreference;
import com.gapsi.service.UserPreferenceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/userPreference")
@CrossOrigin(origins = "*")
public class UserPreferenceController {

    private final UserPreferenceService userPreferenceService;

    public UserPreferenceController(UserPreferenceService userPreferenceService) {
        this.userPreferenceService = userPreferenceService;
    }

    @GetMapping()
    public ResponseEntity<UserPreference> getUserPreference(@RequestParam(defaultValue = "jpmorales") String username){
        return new ResponseEntity<>( userPreferenceService.getUserPreference(username), HttpStatus.OK);
    }

}
