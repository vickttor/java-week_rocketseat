package app.vercel.victorhsdev.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import app.vercel.victorhsdev.todolist.repositories.UserRepository;
import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component // Will run everytime before the request in controllers
public class FilterTaskAuth extends OncePerRequestFilter {

  @Autowired
  private UserRepository repository;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
        
        // Take the authentication (user and password)

        var authorization = request.getHeader("Authorization");
        var parsedAuthorization = authorization.substring("Basic".length()).trim();

        // decode the authorization
        byte[] authInBytes = Base64.getDecoder().decode(parsedAuthorization);

        var authDecoded = new String(authInBytes);
        
        String[] credentials = authDecoded.split(":");

        String email = credentials[0];
        String password = credentials[1];

        // validate user
        var user = repository.findByEmail(email);

        if(user == null) {
          response.sendError(401);
        }else{
          // validate password
          var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());

          if(!passwordVerify.verified) {
            response.sendError(401);
          }

        }

        filterChain.doFilter(request, response); // next()
  }


  
}
