package com.escuela.escuela.DAO;



import org.springframework.data.jpa.repository.JpaRepository;

import com.escuela.escuela.model.Salon;

public interface ISalonDao extends JpaRepository<Salon, Integer>{		
Salon   findByNumero(Integer numero);

}
