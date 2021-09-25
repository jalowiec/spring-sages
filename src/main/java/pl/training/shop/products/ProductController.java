package pl.training.shop.products;

import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Columns;
import org.javamoney.moneta.FastMoney;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.training.shop.common.web.PagedResultTransferObject;
import pl.training.shop.common.web.UriBuilder;
import pl.training.shop.users.UserTransferObject;


import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/products")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;


    private UriBuilder uriBuilder= new UriBuilder();


    @PostMapping
    public ResponseEntity<Product> addProduct(@Valid @RequestBody ProductTransferObject productTransferObject, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().build();
        }
        var product = productMapper.toProduct(productTransferObject);
        var productId = productService.add(product).getId();
        var locationUri = uriBuilder.requestUriWithId(productId);
        return ResponseEntity.created(locationUri).build();
    }

    @GetMapping
    public PagedResultTransferObject<ProductTransferObject> getAllProducts(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "5") int pageSize) {
        var products = productService.getAll(pageNumber, pageSize);
        return productMapper.toProductTransferObjectsPage(products);
    }



}
