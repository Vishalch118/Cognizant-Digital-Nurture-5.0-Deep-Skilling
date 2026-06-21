package com.cognizant.tdd;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getUserById(Long id) {
    return repository.findById(id)
            .orElseThrow(() ->
                    new java.util.NoSuchElementException("User not found"));
}

    public User saveUser(User user) {
        return repository.save(user);
    }
}