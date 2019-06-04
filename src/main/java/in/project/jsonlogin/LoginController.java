package in.project.jsonlogin;


import in.project.jsonlogin.user.User;
import in.project.jsonlogin.user.UserController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class LoginController {

    @Autowired
    UserController userController;
    ArrayList<User> users = new ArrayList<>();


    @GetMapping("/login")
   // @RequestMapping("/login.html")
    public String loginform(Model model){

        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");

        users = userController.usersAll();
        //System.out.println(users.size());

        return "login";
    }


    @PostMapping("/loginok")
    public String loginok(Model model, HttpServletRequest request){

//        @GetMapping("/hello")
//        public String hello(Model model, @RequestParam(defaultValue = "jjj") String name){
//            model.addAttribute("name", name);
//            return "hello";
//        }

        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");


        User user = new User();
        for(User u : users){
            System.out.println(u.getUsername() +",  "+u.getPassword() );
           if(u.getUsername().equals(uname) && u.getPassword().equals(pwd)) {
               user = u;
               break;
           }
        }


        if(!uname.equals(user.getUsername()) || !pwd.equals(user.getPassword())){
            System.out.println(uname +",  "+pwd +" xx ");
            return "login";
        }

        model.addAttribute("user", user );
        System.out.println("okokookok");
        return "loginok";
    }




    ///jwt

    @GetMapping("/loginjwt")
    // @RequestMapping("/login.html")
    public String loginjwtform(Model model) throws UnsupportedEncodingException {

        System.out.println("jwt~~~~~~~~~~~~~~~");

        users = userController.usersJwtAll();

        return "loginjwt";
    }



}
