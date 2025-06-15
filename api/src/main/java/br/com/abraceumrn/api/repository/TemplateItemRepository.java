package br.com.abraceumrn.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.abraceumrn.api.model.TemplateItem;

public interface TemplateItemRepository extends JpaRepository <TemplateItem, Long>{

} 