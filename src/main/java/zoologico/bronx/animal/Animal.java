package zoologico.bronx.animal;

import zoologico.bronx.zoologico.Zoologico;

import javax.persistence.*;

@Entity
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigserial")
    private Long ID_Animal;

    @Column(length = 50, nullable = false)
    private String Nome;

    @Column(length = 50, nullable = false)
    private String Especie;

    private Integer Idade;
    private Double Peso;

    @Column(columnDefinition = "TEXT")
    private String Informacoes_Adicionais;

    @ManyToOne
    @JoinColumn(name = "ID_Zoologico", nullable = false)
    private Zoologico zoologico;

    public Long getID_Animal() {
        return ID_Animal;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEspecie() {
        return Especie;
    }

    public void setEspecie(String Especie) {
        this.Especie = Especie;
    }

    public Integer getIdade() {
        return Idade;
    }

    public void setIdade(Integer Idade) {
        this.Idade = Idade;
    }

    public Double getPeso() {
        return Peso;
    }

    public void setPeso(Double Peso) {
        this.Peso = Peso;
    }

    public String getInformacoes_Adicionais() {
        return Informacoes_Adicionais;
    }

    public void setInformacoes_Adicionais(String Informacoes_Adicionais) {
        this.Informacoes_Adicionais = Informacoes_Adicionais;
    }

    public Zoologico getZoologico() {
        return zoologico;
    }

    public void setZoologico(Zoologico zoologico) {
        this.zoologico = zoologico;
    }
}
