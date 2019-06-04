package in.project.jsonlogin.user;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.omg.CORBA.ServerRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.awt.print.Book;
import java.io.UnsupportedEncodingException;
import java.util.*;

@RestController // json으로 보려고 restcontroller
public class UserController {

    @GetMapping("/user")
    public User currentUser(){
        User user = new User();
        user.setUsername("aa");
        user.setPassword("aa");

        return user;
    }

    @GetMapping("/users")
    public ArrayList<User> usersAll(){

        ArrayList<User> users = new ArrayList<>();

        User user1 = new User();
        user1.setUsername("aa");
        user1.setPassword("aa");
        users.add(user1);

        User user2 = new User();
        user2.setUsername("bb");
        user2.setPassword("bb");
        users.add(user2);

        return users;
    }

    //jwt

    public String createUserJwt(String uname, String pwd) throws UnsupportedEncodingException {
        String jwtString = Jwts.builder()
                .setSubject("users/TzMUocMF4p")
               // .setExpiration(new Date(1300819380))
                .claim("name", uname)
                .claim("password", pwd)
                .signWith(
                        SignatureAlgorithm.HS256,
                        "user".getBytes("UTF-8")
                )
                .compact();

        return jwtString;
    }


    @GetMapping("/userjwt")
    //public Map<String, Object> usersJwtAll() throws UnsupportedEncodingException {
    public ArrayList<User> usersJwtAll() throws UnsupportedEncodingException {

        ArrayList<User> users = new ArrayList<>();

        ArrayList<String> jwts = new ArrayList<>();
        String jwt = createUserJwt("cc", "cc");
        jwts.add(jwt);

        jwt = createUserJwt("dd", "dd");
        jwts.add(jwt);

        System.out.println("1 : " + jwts.size());


        for (String j : jwts) {

            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey("user".getBytes("UTF-8"))
                    .parseClaimsJws(j);

            String uname = claims.getBody().get("name").toString();
            String pwd = claims.getBody().get("password").toString();
            System.out.println("2 : " + uname+", "+pwd);

            User user = new User();
            user.setUsername(uname);
            user.setPassword(pwd);
            users.add(user);
            System.out.println("3 : "+users.size());
        }
       // assertEquals(uname, "aa");




        return users;

    }
}
