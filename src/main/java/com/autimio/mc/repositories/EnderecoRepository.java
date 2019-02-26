package com.autimio.mc.repositories;

import com.autimio.mc.domain.Categoria;
import com.autimio.mc.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
