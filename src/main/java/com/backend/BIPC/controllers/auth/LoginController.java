package com.backend.BIPC.controllers.auth;

import com.backend.BIPC.entities.auth.RequestLogin;
import com.backend.BIPC.entities.auth.ResponseLogin;
import com.backend.BIPC.entities.auth.User;
import com.backend.BIPC.repositories.UserRepository;
import com.backend.BIPC.services.auth.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("getData")
    public List<User> login(){
        System.out.println(userRepository.findAll());
        return userRepository.findAll();
    }

    @CrossOrigin
    @PostMapping("signing")
    public ResponseEntity<?> login2(@Valid @RequestBody RequestLogin requestLogin) throws Exception {

        System.out.println("Request Login"+requestLogin);
      try{
          requestLogin.setPassword(bCryptPasswordEncoder.encode(requestLogin.getPassword()));
          this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                          (requestLogin.getEmail(), requestLogin.getPassword()));
      }catch (UsernameNotFoundException e){
          e.printStackTrace();
          throw new Exception("User Not Found");
      }catch (BadCredentialsException e) {
          e.printStackTrace();
//          throw new Exception("BAD CREDENTIALS");
      }

       // UserDetails user = this.customUserDetailsService.loadUserByUsername(requestLogin.getEmail());

        //JWT token generate here.... with the help og user type UserDetails which is written above line;


        //fetch only required data of user
        User user1 = userRepository.findByUsername(requestLogin.getEmail());
        ResponseLogin responseLogin = new ResponseLogin(user1.getId(),user1.getFirstName(),user1.getLastName(),user1.getUsername(),user1.getGender());
        return ResponseEntity.ok(responseLogin);
    }
}
