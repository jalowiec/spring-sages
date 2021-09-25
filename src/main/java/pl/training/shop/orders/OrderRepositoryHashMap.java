package pl.training.shop.orders;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OrderRepositoryHashMap {

    private Map<Long, Order> orderMap = new HashMap<>();
    private long index = 0;


    //@Override
    public Order save(Order order) {
        order.setId(++index);
        orderMap.put(index, order);
        return order;
    }

    //@Override
    public Optional<Order> findById(Long id) {
        return Optional.ofNullable(orderMap.get(id));
    }

    //@Override
    public void update(Order order) {
        orderMap.replace(order.getId(), order);
    }
}
