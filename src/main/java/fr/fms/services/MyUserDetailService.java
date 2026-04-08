package fr.fms.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;

import fr.fms.dao.MyUserRepository;
import fr.fms.entities.MyUser;

import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    private final MyUserRepository myUserRepository;

    // Constructor injection for MyUserRepository
    public MyUserDetailService(MyUserRepository myUserRepository) {
        this.myUserRepository = myUserRepository;
    }

    /**
     * Loads the user by username.
     * 
     * @param username the username to search for
     * @return the UserDetails object
     * @throws UsernameNotFoundException if the username is not found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> myUserOptional = myUserRepository.findByUsername(username);
        if (myUserOptional.isPresent()) {
            MyUser myUser = myUserOptional.get();
            return User.builder()
                    .username(myUser.getUsername())
                    .password(myUser.getPassword())
                    .roles(myUser.getRoles().split(","))
                    .build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}
