package com.bla.entrega.service;

import com.bla.entrega.model.Pessoa;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PessoaService
{
    Pessoa createPessoa(Pessoa pessoa);
    Pessoa findPessoaById(Integer id);
    List<Pessoa> findAllPessoas();
    Pessoa updatePessoa(Pessoa pessoa);
    List<Pessoa> deletePessoaById(Integer id);
    List<Pessoa> deletePessoa(Pessoa pessoa);
}