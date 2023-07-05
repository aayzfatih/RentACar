package kodlama.io.rentACar.busieness.concretes;

import kodlama.io.rentACar.busieness.abstarcts.BrandService;
import kodlama.io.rentACar.busieness.requests.CreateBrandsRequest;
import kodlama.io.rentACar.busieness.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.dataAccess.abstarcts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //Bu sinif bir busieness nesnesidir
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;

    @Autowired
    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand>brands=brandRepository.findAll();
        List<GetAllBrandsResponse>brandsResponse=new ArrayList<GetAllBrandsResponse>();
        for (Brand brand:brands){
            GetAllBrandsResponse responseItem=new GetAllBrandsResponse();
            responseItem.setId(brand.getId());
            responseItem.setName(brand.getName());
            brandsResponse.add(responseItem);
        }
        //is kurallari
        return brandsResponse ;

    }

    @Override
    public void add(CreateBrandsRequest createBrandsRequest) {
        Brand brand=new Brand();
        brand.setName(createBrandsRequest.getName());
        this.brandRepository.save(brand);
    }
}
