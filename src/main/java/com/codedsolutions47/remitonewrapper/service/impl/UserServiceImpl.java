package com.codedsolutions47.remitonewrapper.service.impl;

//import com.codedsolutions47.remitonewrapper.model.entity.User;
//import com.codedsolutions47.remitonewrapper.model.enums.Role;
//import com.codedsolutions47.remitonewrapper.model.repository.UserRepository;
import com.codedsolutions47.remitonewrapper.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class UserServiceImpl implements UserService {


//    @Value("${auth.user}")
//    private String username;
//
//    @Value("${auth.password}")
//    private String password;

//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;

//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }


//    @PostConstruct
//    private void init() {
//        createDefaultAdmin();
//    }

//    private void createDefaultAdmin() {
//        log.info("Creating default admin {} {}", username, password);
//        User admin = userRepository.findByUsernameAndRole(username, Role.ADMIN);
//        if (admin == null) {
//            admin = new User();
//            admin.setUsername(username);
//            //admin.setPassword(passwordEncoder.encode(password));
//            admin.setRole(Role.ADMIN);
//            admin.setPartnerId("1");
//            admin.setIsEnabled(true);
//            userRepository.save(admin);
//        }
//    }

//    @Override
//    public org.springframework.security.core.userdetails.User loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
//    }

//    @Override
//    public User createUser(User user) {
//        user.setUsername(user.getUsername());
//        //user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setRole(user.getRole());
//        user.setIsEnabled(user.getIsEnabled());
//        user.setPartnerId(user.getPartnerId());
//        return userRepository.save(user);
//    }

//    @Override
//    public void resetPassword(String username, String newPassword) {
//        User user = userRepository.findByUsername(username);
//        if (user != null) {
//            user.setPassword(passwordEncoder.encode(newPassword));
//            userRepository.save(user);
//        } else {
//            throw new RuntimeException("User not found");
//        }
//    }

//    @Override
//    public String getPartnerIdFromAuthentication() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
//        return userDetails.getPartnerId();
//    }
}
