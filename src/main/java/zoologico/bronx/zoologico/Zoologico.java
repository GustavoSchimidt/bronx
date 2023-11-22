package zoologico.bronx.zoologico;

import javax.persistence.*;

@Entity
@Table(name = "zoologico")
public class Zoologico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long ID_Zoologico;

    private String Nome;
    private String Localizacao;
    private int Capacidade;

    public Long getID_Zoologico() {
        return ID_Zoologico;
    }

    public void setID_Zoologico(Long ID_Zoologico) {
        this.ID_Zoologico = ID_Zoologico;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getLocalizacao() {
        return Localizacao;
    }

    public void setLocalizacao(String Localizacao) {
        this.Localizacao = Localizacao;
    }

    public int getCapacidade() {
        return Capacidade;
    }

    public void setCapacidade(int Capacidade) {
        this.Capacidade = Capacidade;
    }
}


