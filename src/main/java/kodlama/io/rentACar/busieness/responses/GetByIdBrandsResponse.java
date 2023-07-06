package kodlama.io.rentACar.busieness.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdBrandsResponse {
    private int id;
    private String name;
}
