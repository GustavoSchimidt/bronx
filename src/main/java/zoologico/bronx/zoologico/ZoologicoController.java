package zoologico.bronx.zoologico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/zoologico", produces = MediaType.APPLICATION_JSON_VALUE)
public class ZoologicoController {
    @Autowired
    private ZoologicoFacade zoologicoFacade;

    @PostMapping
    @ResponseBody
    public ZoologicoDTO criar(@RequestBody ZoologicoDTO zoologioDTO) {
        return zoologicoFacade.criar(zoologioDTO);
    }

    @PutMapping("/{zoologicoId}")
    @ResponseBody
    public ZoologicoDTO atualizar(@PathVariable("zoologicoId") Long zoologicoId,
                                  @RequestBody ZoologicoDTO zoologioDTO) {
        return zoologicoFacade.atualizar(zoologioDTO, zoologicoId);
    }

    @GetMapping
    @ResponseBody
    public List<ZoologicoDTO> getAll() {
        return zoologicoFacade.getAll();
    }

    @DeleteMapping("/{zoologicoId}")
    @ResponseBody
    public String deletar(@PathVariable("zoologicoId") Long zoologicoId) {
        return zoologicoFacade.delete(zoologicoId);
    }
}


