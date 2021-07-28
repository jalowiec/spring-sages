package pl.training.shop.orders;

import lombok.RequiredArgsConstructor;
import pl.training.shop.common.retryer.Retry;
import pl.training.shop.common.validator.Validate;


@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @Retry(retryNumber = 2)
    public Order add(@Validate(exception = InvalidOrderException.class) Order order){
        return orderRepository.save(order);
    }

    public Order getById(Long orderId){
        return orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);
    }

    public void update(Order order){
        orderRepository.update(order);
    }

}
