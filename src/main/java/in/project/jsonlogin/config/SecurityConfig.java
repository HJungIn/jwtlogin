//package in.project.jsonlogin.config;
//
//import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
//                .antMatchers("/css/**").permitAll()
//                .anyRequest().fullyAuthenticated()
//                .and()
//                .formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
//                .and()
//                .logout().permitAll();
//
//
//
//
//        http.authorizeRequests()
//                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//                .requestMatchers(new AntPathRequestMatcher("*.html")).permitAll() //주소에 .html 안쓰고 이름으로만 써도 연결되게 하는거
//                .anyRequest().fullyAuthenticated()
//                .and()
//                // .formLogin().loginPage("/login").failureUrl("/login?error").permitAll() // login.html 있을 때
//                .formLogin().permitAll()
//                .and()
//                .logout().permitAll();
//    }
//}
