package com.example.projetoFinal2.Controller;

import com.example.projetoFinal2.Model.Produto;
import com.example.projetoFinal2.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ProdutoController {
    @Autowired
    ProdutoRepository prRepo;

    @PostMapping("/inserirProduto")
    public void inserirProduto(@RequestBody Produto pr){
        prRepo.save(pr);
    }

    @GetMapping("/todosProduto")
    public List<Produto> buscarTodosProdutos(){
        return prRepo.findAll();
    }

    @GetMapping("todosProdutos/codigo/{codigo}")
    public List<Produto> buscarProdutoPorCodigo(@PathVariable("codigo") int codigo){
        return prRepo.findByCodigo(codigo);
    }

    @GetMapping("todosProdutos/partedesc/{parteDesc}")
    public List<Produto> buscarPorParteDesc(@PathVariable("parteDesc") String parteDesc){
        return prRepo.findByParteDesc(parteDesc);
    }

    @GetMapping("todosProdutos/preco/{preco}")
    public List<Produto> buscarPorMenorPreco(@PathVariable("preco") double preco){
        return prRepo.findByPreco(preco);
    }

    @GetMapping("/todosProdutos/marca/{marca}")
    public List<Produto> buscarPorMarca(@PathVariable("marca") String marca)
    {
        return prRepo.findByMarca(marca);
    }

    @GetMapping("/todosProdutos/marcapreco/{marca}/{preco}")
    public List<Produto> buscarPorMarcaPreco(@PathVariable("marca") String marca, @PathVariable("marca") double preco)
    {
        return prRepo.findByMarcaPreco(marca,preco);
    }

    @DeleteMapping("/removerProduto")
    public void removerProduto(@RequestBody Produto pr){
        prRepo.delete(pr);
    }

    @DeleteMapping("/removerProdutoCodigo/{codigo}")
    public void removerPorID(@PathVariable("codigo") int codigo){
        prRepo.deleteById(codigo);
    }

    @PutMapping("/atualizarProduto")
    public void atualizarProduto(@RequestBody Produto pr){
        prRepo.save(pr);
    }
}
