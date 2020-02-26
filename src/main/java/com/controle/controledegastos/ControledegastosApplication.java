package com.controle.controledegastos;

import com.controle.controledegastos.domain.Categoria;
import com.controle.controledegastos.domain.Produto;
import com.controle.controledegastos.repositories.CategoriaRepository;
import com.controle.controledegastos.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ControledegastosApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
    private ProdutoRepository produtoRepository;

    public static void main(String[] args) {
        SpringApplication.run(ControledegastosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");

        Produto produto1 = new Produto(null, "Computador", 2000.00);
        Produto produto2 = new Produto(null, "Impressora", 800.00);
        Produto produto3 = new Produto(null, "Impressora", 30.00);

        cat1.getProdutos().addAll(Arrays.asList(produto1,produto2, produto3));
        cat2.getProdutos().addAll(Arrays.asList(produto2));
        produto1.getCategorias().addAll(Arrays.asList(cat1));
        produto2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        produto3.getCategorias().addAll(Arrays.asList(cat1));


        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));

    }
}
