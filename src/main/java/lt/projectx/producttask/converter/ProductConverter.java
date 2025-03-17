package lt.projectx.producttask.converter;

import lt.projectx.producttask.dto.CreateProductRequest;
import lt.projectx.producttask.dto.GetProductResponse;
import lt.projectx.producttask.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductConverter {

    public GetProductResponse entityToDto(Product product) {
        GetProductResponse response = new GetProductResponse();
        response.setId(product.getId());
        response.setDescription(product.getDescription());
        response.setName(product.getName());
        return response;
    }

    public List<GetProductResponse> entityListToDto(List<Product> products) {
        List<GetProductResponse> responseList = new ArrayList<>();
        for (Product product : products) {
            responseList.add(entityToDto(product));
        }
        return responseList;
    }

    public Product toEntity(CreateProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        return product;
    }

    public List<Product> toEntityList(List<CreateProductRequest> requests) {
        List<Product> products = new ArrayList<>();
        for (CreateProductRequest request : requests){
            products.add(toEntity(request));
        }
        return products;
    }

}
