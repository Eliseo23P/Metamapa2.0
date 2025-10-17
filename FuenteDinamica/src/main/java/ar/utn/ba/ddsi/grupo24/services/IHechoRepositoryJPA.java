package ar.utn.ba.ddsi.grupo24.services;


import ar.utn.ba.ddsi.grupo24.models.entities.Hecho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface IHechoRepositoryJPA extends JpaRepository<Hecho, Long> {



}
