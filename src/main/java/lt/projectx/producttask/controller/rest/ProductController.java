package lt.projectx.producttask.controller.rest;

import lombok.RequiredArgsConstructor;
import lt.projectx.producttask.converter.ProductConverter;
import lt.projectx.producttask.dto.CreateProductRequest;
import lt.projectx.producttask.dto.GetProductResponse;
import lt.projectx.producttask.entity.Product;
import lt.projectx.producttask.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/products")
@RestController
public class ProductController {

    private final ProductService productService;
    private final ProductConverter converter;

    @GetMapping
    public List<GetProductResponse> getProductList(@RequestParam(required = false) Long productID) {
        return converter.entityListToDto(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public GetProductResponse getProductById(@PathVariable Long id){
        return converter.entityToDto(productService.findProductById(id));
    }

    @PostMapping
    public GetProductResponse createProduct(@RequestBody CreateProductRequest request){
        Product product = converter.toEntity(request);
        GetProductResponse response = converter.entityToDto(productService.addProduct(product));
        return response;
    }

    @PatchMapping("/{id}")
    public GetProductResponse patchProductById(@PathVariable Long id, @RequestBody CreateProductRequest request){
        Product product = converter.toEntity(request);
        return converter.entityToDto(productService.patchProductById(id, product));
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }
}
