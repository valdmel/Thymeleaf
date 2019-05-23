package com.bla.entrega.controller;

import com.bla.entrega.model.Pessoa;
import com.bla.entrega.service.PessoaService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PessoaController
{
    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/add")
    public ModelAndView createPessoa(Pessoa pessoa)
    {
        ModelAndView mv = new ModelAndView("/pessoaADD");
        mv.addObject("pessoa", pessoa);
        
        return mv;
    }
    
    @GetMapping("/")
    public ModelAndView findAllPessoas()
    {
        ModelAndView mv = new ModelAndView("/pessoa");
        mv.addObject("pessoas", pessoaService.findAllPessoas());
        
        return mv;
    }
	
    @GetMapping("/update/{id}")
    public ModelAndView updatePessoa(@PathVariable("id") Integer id)
    {
        return createPessoa(pessoaService.findPessoaById(id));
    }
	
    @GetMapping("/delete/{id}")
    public ModelAndView deletePessoa(@PathVariable("id") Integer id)
    {
        pessoaService.deletePessoaById(id);
        
        return findAllPessoas();
    }

    @PostMapping("/save")
    public ModelAndView savePessoa(@Valid Pessoa pessoa, BindingResult result)
    {
        if (result.hasErrors())
        {
            return createPessoa(pessoa);
        }

        pessoaService.createPessoa(pessoa);

        return findAllPessoas();
    }
}