package in.project.jsonlogin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

//@RestController //데이터를 리턴
@Controller //view를 리턴
public class HomeController {



        @RequestMapping("/")
        //@GetMapping("/")
        public String home(Model model, Locale locale) {

            Date date = new Date();
            DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

            String formattedDate = dateFormat.format(date);

            model.addAttribute("serverTime", formattedDate );

            System.out.println("Gogogogo");
            return "index";
        }

}
