package com.example.Thymeleaf.Controller;

import com.example.Thymeleaf.Model.Pessoa;
import com.example.Thymeleaf.Services.PessoaService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    
    @GetMapping("/update/{id}")
    public ModelAndView updatePessoa(@PathVariable("id") Integer id)
    {
        ModelAndView mv = new ModelAndView("/pessoaUPD");
        mv.addObject("pessoa", pessoaService.findPessoaById(id));
        
        return mv;
    }
    
    @GetMapping("/")
    public ModelAndView findAllPessoas()
    {
        ModelAndView mv = new ModelAndView("/pessoa");
        mv.addObject("pessoas", pessoaService.findAllPessoas());
        
        return mv;
    }
	
    @GetMapping("/delete/{id}")
    public ModelAndView deletePessoa(@PathVariable("id") Integer id)
    {
        pessoaService.deletePessoaById(id);
        
        return findAllPessoas();
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid Pessoa pessoa, BindingResult result)
    {
        if (result.hasErrors())
        {
            return createPessoa(pessoa);
        }
        
        pessoaService.createPessoa(pessoa);

        return findAllPessoas();
    }
    
    @PostMapping("/update")
    public ModelAndView update(@Valid Pessoa pessoa, BindingResult result)
    {
        if (result.hasErrors())
        {
            return createPessoa(pessoa);
        }
        
        pessoaService.updatePessoa(pessoa);
        
        return findAllPessoas();
    }
}