package src;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PlatCursos {
    private static List<Professor> professores = new ArrayList<>();
    private static List<Curso> cursos = new ArrayList<>();
    private static List<Aluno> alunos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("==== Menu Principal ====");
            System.out.println("1 - Cadastrar Professor");
            System.out.println("2 - Cadastrar Curso");
            System.out.println("3 - Cadastrar Aluno");
            System.out.println("4 - Listar Professores");
            System.out.println("5 - Listar Cursos");
            System.out.println("6 - Listar Alunos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        cadastrarProfessor(scanner);
                        break;
                    case 2:
                        cadastrarCurso(scanner);
                        break;
                    case 3:
                        cadastrarAluno(scanner);
                        break;
                    case 4:
                        listarProfessores();
                        break;
                    case 5:
                        listarCursos();
                        break;
                    case 6:
                        listarAlunos();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine(); 
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void cadastrarProfessor(Scanner scanner) {
        System.out.print("Nome do Professor: ");
        String nome = scanner.nextLine();
        System.out.print("Departamento: ");
        String departamento = scanner.nextLine();

        Professor professor = new Professor(nome, departamento);
        professores.add(professor);
        System.out.println("Professor cadastrado com sucesso!");
    }

    private static void cadastrarCurso(Scanner scanner) {
        System.out.print("Nome do Curso: ");
        String nome = scanner.nextLine();
        System.out.print("Carga Horária: ");
        int cargaHoraria = scanner.nextInt();
        scanner.nextLine();
        System.out.print("ID do Professor (para associar): ");
        int idProfessor = scanner.nextInt();
        scanner.nextLine();

        Curso curso = new Curso(nome, cargaHoraria, idProfessor);
        cursos.add(curso);       
        for (Professor professor : professores) {
            if (professor.getId() == idProfessor) {
                professor.adicionarCurso(curso);
                break;
            }
        }
        System.out.println("Curso cadastrado com sucesso!");
    }

    private static void cadastrarAluno(Scanner scanner) {
        System.out.print("Nome do Aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Data de Nascimento (DD/MM/AAAA): ");
        String dataNascimento = scanner.nextLine();
        System.out.print("C.P.F.: ");
        String cpf = scanner.nextLine();
        System.out.print("ID do Curso (para associar): ");
        int idCurso = scanner.nextInt();
        scanner.nextLine();

        Aluno aluno = new Aluno(nome, dataNascimento, cpf, idCurso);
        alunos.add(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    private static void listarProfessores() {
        professores.forEach(professor -> {
            System.out.println(professor);
            System.out.println("Carga Horária Total: " + professor.calcularCargaHorariaTotal());
        });
    }

    private static void listarCursos() {
        cursos.forEach(curso -> {
            int idProfessor = curso.getIdProfessor();
            String nomeProfessor = professores.stream()
                    .filter(p -> p.getId() == idProfessor)
                    .map(Professor::getNome)
                    .findFirst()
                    .orElse("Não encontrado");
            System.out.println("Nome do Curso: " + curso.getNome() + ", Carga Horária: " + curso.getCargaHoraria() + ", Professor: " + nomeProfessor);
        });
    }

    private static void listarAlunos() {
        alunos.forEach(aluno -> {
            int idCurso = aluno.getIdCurso();
            String nomeCurso = cursos.stream()
                    .filter(c -> c.getId() == idCurso)
                    .map(Curso::getNome)
                    .findFirst()
                    .orElse("Não encontrado");
            System.out.println("Nome do Aluno: " + aluno.getNome() + ", Data de Nascimento: " + aluno.getDataNascimento() + ", C.P.F.: " + aluno.getCpf() + ", Curso: " + nomeCurso);
        });
    }
}

