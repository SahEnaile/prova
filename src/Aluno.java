package src;

import java.time.LocalDate;
import java.time.Period;

public class Aluno {
    private static int idCounter = 1; 
    private int id;
    private String nome;
    private String dataNascimento;
    private String cpf;
    private int idCurso; 

    public Aluno(String nome, String dataNascimento, String cpf, int idCurso) {
        this.id = idCounter++;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.idCurso = idCurso;
    }

  
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdCurso() {
        return idCurso;
    }

    // Método para calcular a idade do Aluno
    public int calcularIdade() {
        LocalDate dataNasc = LocalDate.parse(dataNascimento, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return Period.between(dataNasc, LocalDate.now()).getYears();
    }

    // Método para validar o CPF do Aluno
    public boolean validarCpf() {
        return cpf.matches("\\d{11}");
    }

    @Override
    public String toString() {
        return "Aluno: " + nome + ", Data de Nascimento: " + dataNascimento + ", CPF: " + cpf + ", Curso ID: " + idCurso;
    }
}
