package kodlama.io.rentACar.business.abstarcts;

import kodlama.io.rentACar.business.requests.CreateModesRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse>getAll();
    void add(CreateModesRequest createModesRequest);
}
