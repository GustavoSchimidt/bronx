package zoologico.bronx.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import zoologico.bronx.zoologico.Zoologico;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalFacade {
    @Autowired
    private AnimalRepository repository;

    public AnimalDTO criar(AnimalDTO animalDTO) {
        Animal animal = new Animal();
        animal.setNome(animalDTO.getNome());
        animal.setEspecie(animalDTO.getEspecie());
        animal.setIdade(animalDTO.getIdade());
        animal.setPeso(animalDTO.getPeso());
        animal.setInformacoes_Adicionais(animalDTO.getInformacoesAdicionais());

        Zoologico zoologico = new Zoologico();
        zoologico.setID_Zoologico(animalDTO.getZoologicoId());
        animal.setZoologico(zoologico);

        repository.save(animal);
        animalDTO.setId(animal.getID_Animal());
        return animalDTO;
    }

    public AnimalDTO atualizar(AnimalDTO animalDTO, Long animalId) {
        Animal animalDatabase = repository.findById(animalId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Animal não encontrado"));

        animalDatabase.setNome(animalDTO.getNome());
        animalDatabase.setEspecie(animalDTO.getEspecie());
        animalDatabase.setIdade(animalDTO.getIdade());
        animalDatabase.setPeso(animalDTO.getPeso());
        animalDatabase.setInformacoes_Adicionais(animalDTO.getInformacoesAdicionais());

        Zoologico zoologico = new Zoologico();
        zoologico.setID_Zoologico(animalDTO.getZoologicoId());
        animalDatabase.setZoologico(zoologico);

        repository.save(animalDatabase);
        return animalDTO;
    }

    private AnimalDTO converter(Animal animal) {
        AnimalDTO result = new AnimalDTO();

        result.setId(animal.getID_Animal());
        result.setNome(animal.getNome());
        result.setEspecie(animal.getEspecie());
        result.setIdade(animal.getIdade());
        result.setPeso(animal.getPeso());
        result.setInformacoesAdicionais(animal.getInformacoes_Adicionais());

        Zoologico zoologico = animal.getZoologico();
        if (zoologico != null) {
            result.setLocalizacao(zoologico.getLocalizacao());
            result.setZoologicoId(animal.getZoologico().getID_Zoologico());
        }

        return result;
    }

    public List<AnimalDTO> getAll() {
        return repository
                .findAll()
                .stream()
                .map(this::converter)
                .collect(Collectors.toList());
    }

    public String delete(Long animalId) {
        Animal animalDatabase = repository.findById(animalId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Animal não encontrado"));
        repository.deleteById(animalDatabase.getID_Animal());
        return "DELETED";
    }
}
