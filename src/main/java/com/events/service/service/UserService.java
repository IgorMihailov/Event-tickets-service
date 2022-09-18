package com.events.service.service;

import com.events.service.dao.UserRepository;
import com.events.service.entity.User;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User findOne(Long id) {
       Optional<User> user = userRepository.findById(id);
       user.orElseThrow(() -> new EntityNotFoundException("User not found"));
       return user.get();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User update(Long id, User user) {
        User oldUser = findOne(id);
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        return userRepository.save(oldUser);
    }

    public User delete(Long id) {
        User user = findOne(id);
        user.setDeleted(true);
        userRepository.save(user);
        return user;
    }

}
