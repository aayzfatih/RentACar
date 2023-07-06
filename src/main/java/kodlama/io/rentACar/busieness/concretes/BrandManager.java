package kodlama.io.rentACar.busieness.concretes;

import kodlama.io.rentACar.busieness.abstarcts.BrandService;
import kodlama.io.rentACar.busieness.requests.CreateBrandsRequest;
import kodlama.io.rentACar.busieness.requests.UpdateBrandRequest;
import kodlama.io.rentACar.busieness.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.busieness.responses.GetByIdBrandsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstarcts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service //Bu sinif bir busieness nesnesidir
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponse=brands.stream()
                .map(brand -> this.modelMapperService.forResponse().map(brand,GetAllBrandsResponse.class)).
                collect(Collectors.toList());

        return brandsResponse;

    }

    @Override
    public void add(CreateBrandsRequest createBrandsRequest) {

        Brand brand=this.modelMapperService.forRequest().map(createBrandsRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand=this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }

    @Override
    public GetByIdBrandsResponse getById(int id) {
        Brand brand=this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandsResponse response=this.modelMapperService.forResponse().map(brand,GetByIdBrandsResponse.class);
        return response;
    }
}
