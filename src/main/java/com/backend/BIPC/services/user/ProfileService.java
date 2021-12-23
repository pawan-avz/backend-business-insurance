package com.backend.BIPC.services.user;

import com.backend.BIPC.entities.user.Profile;
import com.backend.BIPC.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }
}
