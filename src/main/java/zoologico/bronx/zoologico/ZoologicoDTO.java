package zoologico.bronx.zoologico;

public class ZoologicoDTO {
    private Long id;
    private String nome;
    private String localizacao;
    private int capacidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getCapacidade() { return capacidade; }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

}

