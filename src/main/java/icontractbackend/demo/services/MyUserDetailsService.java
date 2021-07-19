package icontractbackend.demo.services;

/*
    This service will be called everytime someone tries to
    authenication as a user

*/
import icontractbackend.demo.model.MyUserDetails;
import icontractbackend.demo.model.User;
import icontractbackend.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

     @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
      Optional<User> user = userRepository.findByUsername(userName);

      user.orElseThrow(() -> new UsernameNotFoundException("Not Found" + userName));

      return user.map(MyUserDetails::new).get();
    }
}
