package zoologico.bronx.zoologico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZoologicoFacade {
    @Autowired
    private ZoologicoRepository repository;

    public ZoologicoDTO criar(ZoologicoDTO zoologicoDTO) {
        Zoologico zoologico = new Zoologico();
        zoologico.setNome(zoologicoDTO.getNome());
        zoologico.setLocalizacao(zoologicoDTO.getLocalizacao());
        zoologico.setCapacidade(zoologicoDTO.getCapacidade());
        repository.save(zoologico);
        zoologicoDTO.setId(zoologico.getID_Zoologico());
        return  zoologicoDTO;
    }

    public ZoologicoDTO atualizar(ZoologicoDTO zoologicoDTO, Long zoologicoId) {
        Zoologico zoologicoDatabase = repository.findById(zoologicoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Zoológico não encontrado"));

        zoologicoDatabase.setNome(zoologicoDTO.getNome());
        zoologicoDatabase.setLocalizacao(zoologicoDTO.getLocalizacao());
        zoologicoDatabase.setCapacidade(zoologicoDTO.getCapacidade());

        repository.save(zoologicoDatabase);
        return zoologicoDTO;
    }

    private ZoologicoDTO converter (Zoologico zoologico) {
        ZoologicoDTO result = new ZoologicoDTO();
        result.setId(zoologico.getID_Zoologico());
        result.setNome(zoologico.getNome());
        result.setCapacidade(zoologico.getCapacidade());
        result.setLocalizacao(zoologico.getLocalizacao());
        return result;
    }

    public List<ZoologicoDTO> getAll () {
        return repository
                .findAll()
                .stream()
                .map(this::converter).collect(Collectors.toList());
    }

    public String delete (Long zoologicoId) {
        Zoologico zoologicoDatabase = repository.findById(zoologicoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Zoológico não encontrado"));
        repository.deleteById(zoologicoDatabase.getID_Zoologico());
        return "DELETED";
    }
}

