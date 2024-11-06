package org.tutor.tutorspringboot.users.service;

import org.tutor.tutorspringboot.users.entity.User;

import java.util.List;

public interface UserService {
    User createUser(String fullName, String email);
    List<User> findAllUsers();
    User findById(Long id);
    User findByEmail(String email);
    void deleteUser(Long id);
}
