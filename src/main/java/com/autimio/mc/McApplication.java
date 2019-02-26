package com.autimio.mc;

import com.autimio.mc.domain.*;
import com.autimio.mc.domain.enums.TipoCliente;
import com.autimio.mc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class McApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public static void main(String[] args) {
        SpringApplication.run(McApplication.class, args);
    }

    @Override
    public void run(String... args) {

        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");

        Produto p1 = new Produto(null, "Computador", 5000.00);
        Produto p2 = new Produto(null, "Impressora", 1000.00);
        Produto p3 = new Produto(null, "Mouse", 50.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p3));
        cat2.getProdutos().addAll(Arrays.asList(p1, p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade c1 = new Cidade(null,"Uberlância", est1);
        Cidade c2 = new Cidade(null,"São Paulo", est2);
        Cidade c3 = new Cidade(null,"Campinas", est2);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));

        categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
        produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));

        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "12345678911", TipoCliente.PESSOAFISICA);

        cli1.getTelefones().addAll(Arrays.asList("32995069","32992506"));

        Endereco e1 = new Endereco(null, "Rua flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
        Endereco e2 = new Endereco(null, "Av. Matos", "105", "Sala 800", "Centro", "38220835", cli1, c2);

        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

        clienteRepository.saveAll(Arrays.asList(cli1));
        enderecoRepository.saveAll(Arrays.asList(e1, e2));


    }
}

