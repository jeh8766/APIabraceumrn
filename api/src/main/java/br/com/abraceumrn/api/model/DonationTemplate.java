package br.com.abraceumrn.api.model;

import java.util.List;

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
public class DonationTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome; // Ex: "Cesta Básica"

    @OneToMany(mappedBy="donationTemplate")
    private List<TemplateItem> templateItem; //5 unidades de arroz //5 unidades 
    
    @OneToMany(mappedBy = "templateUsado")
    private List<Donation> doacoes;
}
