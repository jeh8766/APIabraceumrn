package br.com.abraceumrn.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.abraceumrn.api.model.DonationTemplate;

public interface DonationTemplateRepository extends JpaRepository<DonationTemplate, Long>{

}
