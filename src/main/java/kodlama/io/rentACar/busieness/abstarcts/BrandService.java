package kodlama.io.rentACar.busieness.abstarcts;

import kodlama.io.rentACar.busieness.requests.CreateBrandsRequest;
import kodlama.io.rentACar.busieness.responses.GetAllBrandsResponse;

import java.util.List;


public interface BrandService {
    List<GetAllBrandsResponse>getAll();
    void add(CreateBrandsRequest createBrandsRequest);
}
