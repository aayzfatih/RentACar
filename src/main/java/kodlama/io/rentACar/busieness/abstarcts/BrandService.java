package kodlama.io.rentACar.busieness.abstarcts;

import kodlama.io.rentACar.busieness.requests.CreateBrandsRequest;
import kodlama.io.rentACar.busieness.requests.UpdateBrandRequest;
import kodlama.io.rentACar.busieness.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.busieness.responses.GetByIdBrandsResponse;

import java.util.List;


public interface BrandService {
    List<GetAllBrandsResponse>getAll();
    void add(CreateBrandsRequest createBrandsRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
    GetByIdBrandsResponse getById(int id);
}
