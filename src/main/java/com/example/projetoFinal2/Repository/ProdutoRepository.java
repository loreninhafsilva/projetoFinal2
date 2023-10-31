package com.example.projetoFinal2.Repository;

import com.example.projetoFinal2.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
