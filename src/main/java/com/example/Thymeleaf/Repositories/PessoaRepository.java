package com.example.Thymeleaf.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Thymeleaf.Model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>
{
    
}