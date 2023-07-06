package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.busieness.abstarcts.BrandService;
import kodlama.io.rentACar.busieness.requests.CreateBrandsRequest;
import kodlama.io.rentACar.busieness.requests.UpdateBrandRequest;
import kodlama.io.rentACar.busieness.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.busieness.responses.GetByIdBrandsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //annotation
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;

    @GetMapping()
    public List<GetAllBrandsResponse> getAll() {
        return brandService.getAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody() CreateBrandsRequest createBrandsRequest) {
        this.brandService.add(createBrandsRequest);
    }
    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }
    @GetMapping("/{id}")
    public GetByIdBrandsResponse getById(@PathVariable int id){
        return this.brandService.getById(id);
    }

}
