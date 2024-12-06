package com.app.tankesv.repo;

import com.app.tankesv.model.Empresario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresarioRepository extends JpaRepository<Empresario, Integer> {
}
