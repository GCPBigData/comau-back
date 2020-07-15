package br.comau.util;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15/07/2020
 */
public class FormatarLocalDate {
    public static void main(String[] args) {

        //Obtém LocalDate de hoje
        LocalDate hoje = LocalDate.now(); //2020-02-02

        System.out.println("LocalDate antes de formatar: " + hoje);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //02/02/2020

        String hojeFormatado = hoje.format(formatter);

        System.out.println("LocalDate depois de formatar: " + hojeFormatado);

        //Obtém LocalDateTime de agora
        LocalDateTime agora = LocalDateTime.now();

        System.out.println("LocalDateTime antes de formatar: " + agora);

        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        String agoraFormatado = agora.format(formatter);

        System.out.println("LocalDateTime depois de formatar: " + agoraFormatado);

    }

}