package pl.training.shop.users;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import pl.training.shop.common.PagedResult;
import pl.training.shop.common.validator.Validate;
import pl.training.shop.orders.InvalidOrderException;
import pl.training.shop.orders.Order;
import pl.training.shop.orders.OrderNotFoundException;
import pl.training.shop.orders.OrderRepository;

import javax.transaction.Transactional;

@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User add(User user){
        return userRepository.save(user);
    }

    public User getById(Long orderId){
        return userRepository.findById(orderId).orElseThrow(UserNotFoundException::new);
    }

    public PagedResult<User> getByLastName(String lastNameFragment, int pageNumber, int pageSize) {
        var userPage = userRepository.findByLastNameContaining(lastNameFragment, PageRequest.of(pageNumber, pageSize));
        return new PagedResult<>(userPage.getContent(), pageNumber, userPage.getTotalPages());
    }

    public PagedResult<User> getAll(int pageNumber, int pageSize) {
        var userPage = userRepository.findAll(PageRequest.of(pageNumber, pageSize));
        return new PagedResult<>(userPage.getContent(), pageNumber, userPage.getTotalPages());
    }


}
