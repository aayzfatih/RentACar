package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstarcts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModesRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstarcts.ModelRepositorty;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepositorty modelRepositorty;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = this.modelRepositorty.findAll();
        List<GetAllModelsResponse> responses = models.stream()
                .map(model -> this.modelMapperService.forResponse().map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
        return responses;
    }
    public void add(CreateModesRequest createModesRequest) {
        Model model=this.modelMapperService.forRequest().map(createModesRequest,Model.class);
        this.modelRepositorty.save(model);
    }
}
