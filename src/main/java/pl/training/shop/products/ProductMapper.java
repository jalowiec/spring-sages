package pl.training.shop.products;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import pl.training.shop.common.PagedResult;
import pl.training.shop.common.web.FastMoneyMapper;
import pl.training.shop.common.web.PagedResultTransferObject;


import java.util.List;

@Mapper(componentModel = "spring", uses = FastMoneyMapper.class)
public interface ProductMapper {


    ProductTransferObject toProductTransferObject(Product product);

    Product toProduct(ProductTransferObject productTransferObject);

    @IterableMapping(elementTargetType = ProductTransferObject.class)
    List<ProductTransferObject> toProductTransferObjectList(List<Product> products);

    PagedResultTransferObject<ProductTransferObject> toProductTransferObjectsPage(PagedResult<Product> pagedResult );



}
