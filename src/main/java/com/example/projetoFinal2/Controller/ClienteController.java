package com.example.projetoFinal2.Controller;

import com.example.projetoFinal2.Model.Cliente;
import com.example.projetoFinal2.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ApiCliente")
public class ClienteController {
    @Autowired
    ClienteRepository clRepo;

    @PostMapping("/inserirCliente")
    public void inserirCliente(@RequestBody Cliente al){
        clRepo.save(al);
    }

    @GetMapping("/todosClientes")
    public List<Cliente> buscarTodosClientes(){
        return clRepo.findAll();
    }

    @GetMapping("todosClientes/codigo/{codigo}")
    public List<Cliente> buscarPorCodigo(@PathVariable("codigo") int codigo){
       return clRepo.findByCodigo(codigo);
    }

   @GetMapping("todosClientes/partenome/{parteNome}")
   public List<Cliente> buscarPorParteNome(@PathVariable("parteNome") String parteNome){
    return clRepo.findByParteNome(parteNome);
   }

    @GetMapping("todosClientes/email/{email}")
    public List<Cliente> buscarPorEmail(@PathVariable("email") String email){
        return clRepo.findByEmail(email);
    }
}
