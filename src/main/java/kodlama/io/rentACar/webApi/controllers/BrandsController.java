package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.busieness.abstarcts.BrandService;
import kodlama.io.rentACar.busieness.requests.CreateBrandsRequest;
import kodlama.io.rentACar.busieness.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //annotation
@RequestMapping("/api/brands")
public class BrandsController {
    private BrandService brandService;

    @Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }
    @GetMapping("/getall")
    public List<GetAllBrandsResponse> getAll(){

        return brandService.getAll();
    }
    @PostMapping("/add")
    public void add(@RequestBody() CreateBrandsRequest createBrandsRequest){
        this.brandService.add(createBrandsRequest);
    }
}
