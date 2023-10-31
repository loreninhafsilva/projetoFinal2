package com.example.projetoFinal2.Repository;

import com.example.projetoFinal2.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByCodigo(int codigo);
    List<Cliente> findByEmail(String email);

    @Query("select a from Cliente a where a.nome like %?1%")
    List<Cliente> findByParteNome (String parteNome);
}