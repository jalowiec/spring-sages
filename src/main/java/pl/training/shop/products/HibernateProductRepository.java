package pl.training.shop.products;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.training.shop.common.PagedResult;

import java.util.List;

@RequiredArgsConstructor
public class HibernateProductRepository {

    private final SessionFactory sessionFactory;


    public Product save(Product product) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(product); //zwracamy klientowi jest to obiekt serializable
        product.setId(id);
        return product;
    }


    public PagedResult<Product> findAll(int pageNumber, int pageSize) {
        Session session = sessionFactory.getCurrentSession();
        List<Product> products =  sessionFactory.getCurrentSession()
                .createNamedQuery(Product.SELECT_PRODUCTS, Product.class)
                .setFirstResult(pageNumber * pageSize)
                .getResultList();
        return new PagedResult<>(products, pageNumber, -1);
    }
}
