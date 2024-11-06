package org.tutor.tutorspringboot.users.service.impl;

import org.springframework.stereotype.Service;
import org.tutor.tutorspringboot.users.entity.User;
import org.tutor.tutorspringboot.users.repository.UserRepository;
import org.tutor.tutorspringboot.users.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(String fullName, String email) {
        User user = new User();
        user.setFullName(fullName);
        user.setEmail(email);

        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        return user.get();
    }

    @Override
    public User findByEmail(String username) {
        return userRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {
        User user = findById(id);
        userRepository.delete(user);
    }
}
