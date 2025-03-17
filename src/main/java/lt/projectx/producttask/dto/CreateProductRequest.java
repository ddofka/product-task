package lt.projectx.producttask.dto;

import lombok.Data;

@Data
public class CreateProductRequest {
    private String name;
    private Integer price;
    private String description;
}
