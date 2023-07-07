package kodlama.io.rentACar.webApi.controllers;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstarcts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModesRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/model")
@AllArgsConstructor
public class ModelsController {
    private ModelService modelService;

    @GetMapping("/getall")
    public List<GetAllModelsResponse> getAll() {
        return this.modelService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody() @Valid()  CreateModesRequest createModesRequest) {
        this.modelService.add(createModesRequest);
    }
}
