package br.comau;

import br.comau.model.ClienteFisica;
import br.comau.model.ClienteJuridica;
import br.comau.repository.ClienteFisicaRepository;
import br.comau.repository.ClienteJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private ClienteFisicaRepository clienteFisicaRepositor;

    @Autowired
    private ClienteJuridicaRepository clienteJuridicaRepositor;

    @Override
    public void run(String... arg0) throws Exception {

       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        //ClienteFisica herick = new ClienteFisica(null,"Herick Marques", "64525430249", "Aluno", "Rua dos Java Lang", "+55 91254360", "web2ajax@gmail.com", "Ativo", "Goolgolplex", sdf.parse("21/06/2020"));
        ClienteFisica lourranio = new ClienteFisica(1,"Lourranio Simoes Marques", "64525430249", "Aluno", "Rua dos Java Lang", "+55 91254360", "web2ajax@gmail.com", "Ativo", "Goolgolplex", "21/06/2020");
        ClienteFisica fred = new ClienteFisica(2,"Fred Marques", "64525430249", "Aluno", "Rua dos Java Lang", "+55 91254360", "web2ajax@gmail.com", "Ativo", "Goolgolplex",  "21/06/2020");
        ClienteFisica maria = new ClienteFisica(3,"Maria Avila Toledo", "64525430249", "Aluno", "Rua dos Java Lang", "+55 91254360", "web2ajax@gmail.com", "Ativo", "Goolgolplex",  "21/06/2020");
        ClienteFisica pedro = new ClienteFisica(4,"Pedro Marques", "64525430249", "Aluno", "Rua dos Java Lang", "+55 91254360", "web2ajax@gmail.com", "Ativo", "Goolgolplex",  "21/06/2020");
        ClienteFisica joao = new ClienteFisica(5,"Joao Simoes Marques", "64525430249", "Aluno", "Rua dos Java Lang", "+55 91254360", "web2ajax@gmail.com", "Ativo", "Goolgolplex",  "21/06/2020");
        ClienteFisica ze = new ClienteFisica(6,"Ze Marques", "64525430249", "Aluno", "Rua dos Java Lang", "+55 91254360", "web2ajax@gmail.com", "Ativo", "Goolgolplex",  "21/06/2020");
        ClienteFisica fernandes = new ClienteFisica(7,"Fred Avila Toledo", "64525430249", "Aluno", "Rua dos Java Lang", "+55 91254360", "web2ajax@gmail.com", "Ativo", "Goolgolplex",  "21/06/2020");

        ClienteJuridica googolplex = new ClienteJuridica(1,"googolplex","googolplex","645254602499","START UP", "+56 921555888","googolplex@gmail.com","TI", "Ativa","http://googolplex.com");
        ClienteJuridica googole = new ClienteJuridica(1,"google","google","645254602499","START UP", "+56 921555888","googolplex@gmail.com","TI", "Ativa","http://google.com");

        clienteFisicaRepositor.saveAll(Arrays.asList(lourranio,fred,maria,pedro,joao,ze,fernandes));
        clienteJuridicaRepositor.saveAll(Arrays.asList(googolplex,googole));

    }
}