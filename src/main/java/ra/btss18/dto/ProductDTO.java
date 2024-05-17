package ra.btss18.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private Integer proId;
    @NotEmpty(message = "Name is Empty!")
    private String proName;
    @NotNull(message = "Price is Null!")
    private Double price;
    @NotNull(message = "Stock is Null!")
    private Integer stock;
    @NotNull(message = "Status is Null!")
    private Boolean proStatus;
    @NotNull(message = "Category is Null!")
    private Integer catId;
}
