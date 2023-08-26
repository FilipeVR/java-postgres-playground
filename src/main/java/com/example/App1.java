package com.example;

import java.sql.*;

public class App1 {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Aplicação Java de Exemplo");
        listarEstados();
    }

    public static void listarEstados() {
        System.out.println("Listando Estados Cadastrados no Banco de Dados");
        try {
            Class.forName("org.postgresql.Driver");
            try(var conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "gitpod", "")) {
                var stm = conn.createStatement();
                var result = stm.executeQuery("select * from estado");
                while(result.next()) {
                    System.out.println(result.getString("nome"));
                } 
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
}
