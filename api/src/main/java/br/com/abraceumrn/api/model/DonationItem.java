package br.com.abraceumrn.api.model;

import java.util.List;

import br.com.abraceumrn.utils.Metrics;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DonationItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;          // Ex: "Arroz", "Feijão"
    private String descricao;     // Ex: "pacote de 500gramas" //EX: "pacote de 1000gramas"
    private Metrics unidadeMedida; //Enum // gramas ou mililitros
    private double quantidade;    // Ex: Quantas gramas ou ML's

    @OneToMany(mappedBy = "donationItem")
    private List<TemplateItem> templateItem;
}