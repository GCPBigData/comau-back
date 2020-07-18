package br.comau;

import br.comau.domains.cliente.model.ClienteFisica;
import br.comau.domains.cliente.model.Status;
import br.comau.domains.cliente.model.TipoCliente;
import br.comau.domains.cliente.repository.ClienteFisicaRepository;
import br.comau.domains.cliente.repository.ClienteJuridicaRepository;
import br.comau.model.*;
import br.comau.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private ClienteFisicaRepository clienteFisicaRepositor;

    @Autowired
    private ClienteJuridicaRepository clienteJuridicaRepositor;

    @Autowired
    private CursoRepository cursoRepositor;

    @Override
    public void run(String... arg0) {

        DateTimeFormatter sdf = DateTimeFormatter.ofPattern ("dd/MM/yyyy");
        //sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        //ClienteFisica herick = new ClienteFisica(null,"Herick Marques", "64525430249", Tip, "Rua dos Java Lang", "+55 91254360", "web2ajax@gmail.com", "Ativo", "Goolgolplex", sdf.parse("21/06/2020"));
        ClienteFisica lourranio = new ClienteFisica(1,"Lourranio Simoes Marques", "64525430249", TipoCliente.PESSOAFISICA, "Rua dos Java Lang", "+55 91254360", "web2ajax@gmail.com", Status.ATIVO, "Goolgolplex", Perfil.ADMIN, LocalDateTime.now(), LocalDateTime.now().plusMonths(3));
        ClienteFisica fred = new ClienteFisica(2,"Fred Marques", "64525430249", TipoCliente.PESSOAFISICA, "Rua dos Java Lang", "+55 91254360", "web2ajax@gmail.com", Status.ATIVO, "Goolgolplex", Perfil.CLIENTE, LocalDateTime.now(), LocalDateTime.now().plusMonths(3));
        ClienteFisica maria = new ClienteFisica(3,"Maria Avila Toledo", "64525430249", TipoCliente.PESSOAFISICA, "Rua dos Java Lang", "+55 91254360", "web2ajax@gmail.com", Status.ATIVO, "Goolgolplex", Perfil.CLIENTE, LocalDateTime.now(), LocalDateTime.now().plusMonths(3));
        ClienteFisica pedro = new ClienteFisica(4,"Pedro Marques", "64525430249", TipoCliente.PESSOAFISICA, "Rua dos Java Lang", "+55 91254360", "web2ajax@gmail.com", Status.ATIVO, "Goolgolplex", Perfil.CLIENTE, LocalDateTime.now(), LocalDateTime.now().plusMonths(3));
        ClienteFisica joao = new ClienteFisica(5,"Joao Simoes Marques", "64525430249", TipoCliente.PESSOAFISICA, "Rua dos Java Lang", "+55 91254360", "web2ajax@gmail.com", Status.ATIVO, "Goolgolplex", Perfil.CLIENTE, LocalDateTime.now(), LocalDateTime.now().plusMonths(3));
        ClienteFisica ze = new ClienteFisica(6,"Ze Marques", "64525430249", TipoCliente.PESSOAFISICA, "Rua dos Java Lang", "+55 91254360", "web2ajax@gmail.com", Status.ATIVO, "Goolgolplex" ,Perfil.CLIENTE, LocalDateTime.now(), LocalDateTime.now().plusMonths(3));
        ClienteFisica fernandes = new ClienteFisica(7,"Fred Avila Toledo", "64525430249", TipoCliente.PESSOAFISICA, "Rua dos Java Lang", "+55 91254360", "web2ajax@gmail.com", Status.ATIVO, "Goolgolplex",  Perfil.ADMIN, LocalDateTime.now(), LocalDateTime.now().plusMonths(3));

        //ClienteJuridica googolplex = new ClienteJuridica(1,"googolplex","googolplex","645254602499",TipoCliente.PESSOAJURIDICA, "+56 921555888","googolplex@gmail.com","TI", "Ativa","http://googolplex.com");
        //ClienteJuridica googole = new ClienteJuridica(2,"google","google","645254602499",TipoCliente.PESSOAJURIDICA, "+56 921555888","googolplex@gmail.com","TI", "Ativa","http://google.com");

        clienteFisicaRepositor.saveAll(Arrays.asList(lourranio,fred,maria,pedro,joao,ze,fernandes));
        //clienteJuridicaRepositor.saveAll(Arrays.asList(googolplex,googole));

        //LocalDateTime now = LocalDateTime.now();
        //LocalDateTime end = now.plusMonths(3); //Adiciona 3 meses para o fim do curso (exemplo)

       // Curso java = new Curso(1,"Curso JAVA", "Programacao Backend com java", "Coursera", sdf.format(now), sdf.format(end));
       // Curso angular =new Curso(2,"Curso ANGULAR", "Programacao Frontend com o capeta", "Demonho", "06/06/2020", "10/11/2020");

        //cursoRepositor.saveAll(Arrays.asList(java,angular));

    }
}