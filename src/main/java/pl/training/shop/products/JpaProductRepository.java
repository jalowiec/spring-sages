package pl.training.shop.products;

import lombok.Setter;
import pl.training.shop.common.PagedResult;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class JpaProductRepository{

    @Setter
    @PersistenceContext
    private EntityManager entityManager;



    public Product save(Product product) {
        entityManager.persist(product);
        entityManager.flush();
        entityManager.refresh(product);
        return product;
    }


    public PagedResult<Product> findAll(int pageNumber, int pageSize) {
        List<Product> products =  entityManager
                .createNamedQuery(Product.SELECT_PRODUCTS, Product.class)
                .setFirstResult(pageNumber * pageSize)
                .getResultList();
        return new PagedResult<>(products, pageNumber, -1);
    }

}
