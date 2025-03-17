package lt.projectx.producttask.dto;

import lombok.Data;

@Data
public class GetProductResponse {
    private Long id;
    private String name;
    //private Integer price;
    //private Integer quantity;
    private String description;
}
