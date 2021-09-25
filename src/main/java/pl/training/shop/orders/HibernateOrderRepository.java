package pl.training.shop.orders;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Optional;

@AllArgsConstructor
public class HibernateOrderRepository{

    private final SessionFactory sessionFactory;

    //@Override
    public Order save(Order order) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(order); //zwracamy klientowi jest to obiekt serializable
        order.setId(id);
        return order;
    }

    //@Override
    public Optional<Order> findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Order order = session.find(Order.class, id);
        return Optional.ofNullable(order);
    }

    //@Override
    public void update(Order order) {
        Session session = sessionFactory.getCurrentSession();
        if(session.load(Order.class, order.getId()) != null) {
            session.update(order);
        }

    }
}
