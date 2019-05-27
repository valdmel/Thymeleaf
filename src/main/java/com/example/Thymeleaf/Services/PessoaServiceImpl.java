package com.example.Thymeleaf.Services;

import com.example.Thymeleaf.Model.Pessoa;
import com.example.Thymeleaf.Repositories.PessoaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImpl implements PessoaService
{
    @Autowired
    private PessoaRepository pessoaRepository;
    
    @Override
    public Pessoa createPessoa(Pessoa pessoa)
    {
        return pessoaRepository.saveAndFlush(pessoa);
    }

    @Override
    public Pessoa findPessoaById(Integer id)
    {
        return pessoaRepository.getOne(id);
    }

    @Override
    public List<Pessoa> findAllPessoas()
    {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa updatePessoa(Pessoa pessoa)
    {
        pessoaRepository.save(pessoa);
        
        return pessoaRepository.findById(pessoa.getId()).get();
    }

    @Override
    public List<Pessoa> deletePessoaById(Integer id)
    {
        pessoaRepository.deleteById(id);
        
        return pessoaRepository.findAll();
    }

    @Override
    public List<Pessoa> deletePessoa(Pessoa pessoa)
    {
        pessoaRepository.delete(pessoa);
        
        return pessoaRepository.findAll();
    }
}