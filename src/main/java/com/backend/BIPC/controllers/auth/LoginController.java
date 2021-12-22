package com.backend.BIPC.controllers.auth;

//import com.backend.BIPC.JwtToken.JwtUtil;
import com.backend.BIPC.form.RequestLogin;
import com.backend.BIPC.form.ResponseLogin;
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

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@CrossOrigin
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


    @PostMapping("signing")
    public ResponseEntity<?> login(@Valid @RequestBody RequestLogin requestLogin, HttpServletResponse response) throws Exception {
        System.out.println("Request Login"+requestLogin);
      try{
          this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                          (requestLogin.getEmail(), requestLogin.getPassword()));
      }catch (UsernameNotFoundException e){
          e.printStackTrace();
          throw new Exception("User Not Found");
      }catch (BadCredentialsException e) {
          e.printStackTrace();
          throw new Exception("BAD CREDENTIALS");
      }

        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(requestLogin.getEmail());

        //JWT token generate here.... with the help og user type UserDetails which is written above line;
        //generate jwt token
//        String token = jwtUtil.generateToken(userDetails);

        //creating the new cookie
//        Cookie cookie = new Cookie("token",token);
        //setting the cookie
//        response.addCookie(cookie);

        //get all user details
        User user1 = userRepository.findByUsername(requestLogin.getEmail());

        //get only required information n of user
        ResponseLogin responseLogin = new ResponseLogin(user1.getId(),user1.getFirstName(),user1.getLastName(),user1.getUsername(),user1.getGender());
        return ResponseEntity.ok(responseLogin);
    }
}
