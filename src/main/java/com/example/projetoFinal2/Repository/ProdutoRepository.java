package com.example.projetoFinal2.Repository;

import com.example.projetoFinal2.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> findByCodigo(int codigo);
    List<Produto> findByMarca (String marca);

    @Query("select a from Produto a where a.descricao like %?1%")
    List<Produto> findByParteDesc (String parteDesc);

    @Query ("select a from Produto a where a.preco like <?1")
    List<Produto> findByPreco (double preco);

    @Query ("select a from Produto a where a.marca like %?1% and preco like <?2")
    List<Produto> findByMarcaPreco (String marca, double preco);

}
