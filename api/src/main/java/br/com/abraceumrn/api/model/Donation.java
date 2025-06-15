package br.com.abraceumrn.api.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Donation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private LocalDate dataDoacao;
    private Boolean retirada;
    private LocalDate dataRetirada;

    @ManyToOne
    private DonationTemplate templateUsado;    

    public Donation(String desc, DonationTemplate templateU){
        if (templateU == null) {
            throw new IllegalArgumentException("Template usado não pode ser nulo.");
        }
        this.descricao = desc;
        this.dataDoacao = LocalDate.now(); //ano-mes-dia
        this.retirada = false;
        this.dataRetirada = null;
        this.templateUsado = templateU;
    }
}