package in.project.jsonlogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;



@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class JsonloginApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsonloginApplication.class, args);
    }

  /*  @Autowired
    JdbcTemplate jdbcTemplate;

    @Bean
    public ApplicationRunner runner (){
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM Customers", Integer.class);

                System.out.println("count : "+count);
            }
        };
    }*/
}
