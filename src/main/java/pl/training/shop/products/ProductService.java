package pl.training.shop.products;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import pl.training.shop.common.PagedResult;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


//    @Retry
    public Product add(Product product){
        System.out.println("#################zapisywanie produktow");
        return productRepository.save(product);
  //      System.out.println("###############ADD");
    //    throw new RuntimeException();
    }

    public PagedResult<Product> getAll(int pageNumber, int pageSize){
        Page<Product> productPage = productRepository.findAll(PageRequest.of(pageNumber, pageSize));
        return new PagedResult<>(productPage.getContent(), pageNumber, productPage.getTotalPages());
    }


    public List<Product> getByName(String name){
        return productRepository.findByNameContaining(name);
    }


}
