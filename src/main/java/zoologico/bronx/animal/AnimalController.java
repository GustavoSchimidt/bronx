package zoologico.bronx.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import zoologico.bronx.zoologico.ZoologicoDTO;
import zoologico.bronx.zoologico.ZoologicoFacade;

import java.util.List;

@RestController
@RequestMapping(value = "/animal", produces = MediaType.APPLICATION_JSON_VALUE)
public class AnimalController {
    @Autowired
    private AnimalFacade animalFacade;

    @PostMapping
    @ResponseBody
    public AnimalDTO criar(@RequestBody AnimalDTO animalDTO) {
        return animalFacade.criar(animalDTO);
    }

    @PutMapping("/{animalId}")
    @ResponseBody
    public AnimalDTO atualizar(@PathVariable("animalId") Long animalId,
                               @RequestBody AnimalDTO animalDTO) {
        return animalFacade.atualizar(animalDTO, animalId);
    }

    @GetMapping
    @ResponseBody
    public List<AnimalDTO> getAll() {
        return animalFacade.getAll();
    }

    @DeleteMapping("/{animalId}")
    @ResponseBody
    public String deletar(@PathVariable("animalId") Long animalId) {
        return animalFacade.delete(animalId);
    }
}
