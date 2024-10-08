package src;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    private static int idCounter = 1; 
    private int id;
    private String nome;
    private String departamento;
    private List<Curso> cursos; 

    public Professor(String nome, String departamento) {
        this.id = idCounter++;
        this.nome = nome;
        this.departamento = departamento;
        this.cursos = new ArrayList<>();
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    
    public void adicionarCurso(Curso curso) {
        cursos.add(curso);
    } // Método para adicionar um curso ao Professor

    
    public int calcularCargaHorariaTotal() {
        int cargaHorariaTotal = 0;
        for (Curso curso : cursos) {
            cargaHorariaTotal += curso.getCargaHoraria();
        }
        return cargaHorariaTotal;
    }// Método para calcular a carga horária total de todos os cursos

    @Override
    public String toString() {
        return "Professor: " + nome + ", Departamento: " + departamento + ", Cursos: " + cursos.size();
    }
}

