package pl.training.shop.users;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.training.shop.orders.OrderRepository;
import pl.training.shop.orders.OrderService;

@Configuration
public class UserConfig {


    @Bean(name = "userService")
    public UserService userService(UserRepository userRepository){
        return new UserService(userRepository);
    }


}
