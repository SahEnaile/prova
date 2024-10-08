package src;

public class Curso {
    private static int idCounter = 1; 
    private int id;
    private String nome;
    private int cargaHoraria;
    private int idProfessor; 

    public Curso(String nome, int cargaHoraria, int idProfessor) {
        this.id = idCounter++;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.idProfessor = idProfessor;
    }

   
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    @Override
    public String toString() {
        return "Curso: " + nome + ", Carga Horária: " + cargaHoraria + ", Professor ID: " + idProfessor;
    }
}
