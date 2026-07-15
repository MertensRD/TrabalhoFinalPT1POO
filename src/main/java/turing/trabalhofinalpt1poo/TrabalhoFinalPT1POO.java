package turing.trabalhofinalpt1poo;

import turing.trabalhofinalpt1poo.DAO.AlunoDAO;
import turing.trabalhofinalpt1poo.DAO.ProfessorDAO;
import turing.trabalhofinalpt1poo.entidades.Aluno;
import turing.trabalhofinalpt1poo.entidades.Professor;

import java.util.ArrayList;
import java.util.Scanner;

public class TrabalhoFinalPT1POO {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcao;

        // Instanciando os DAOs que vão conversar com o banco
        AlunoDAO alunoDAO = new AlunoDAO();
        ProfessorDAO professorDAO = new ProfessorDAO();

        do {
            System.out.println("\n===== SISTEMA ACADÊMICO =====");
            System.out.println("1. Cadastrar Aluno(a)");
            System.out.println("2. Listar Alunos(as)");
            System.out.println("3. Excluir Aluno(a)");
            System.out.println("4. Cadastrar Professor(a)");
            System.out.println("5. Listar Professores(as)");
            System.out.println("6. Excluir Professor(a)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = entrada.nextInt();
            entrada.nextLine(); // Limpa o buffer do teclado

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Cadastro de Aluno(a) ---");
                    Aluno novoAluno = new Aluno();
                    System.out.print("Nome: ");
                    novoAluno.setNome(entrada.nextLine());
                    System.out.print("RGA: ");
                    novoAluno.setRga(entrada.nextLine());
                    System.out.print("E-mail: ");
                    novoAluno.setEmail(entrada.nextLine());
                    System.out.print("Curso: ");
                    novoAluno.setCurso(entrada.nextLine());

                    alunoDAO.cadastrar(novoAluno);
                    break;

                case 2:
                    System.out.println("\n--- Lista de Alunos(as) ---");
                    ArrayList<Aluno> listaAlunos = alunoDAO.listarAlunos();
                    for (Aluno a : listaAlunos) {
                        System.out.println("ID: " + a.getId() + " | Nome: " + a.getNome() + " | RGA: " + a.getRga() + " | Curso: " + a.getCurso());
                    }
                    break;

                case 3:
                    System.out.println("\n--- Excluir Aluno(a) ---");
                    System.out.print("Digite o ID do aluno que deseja excluir: ");
                    int idAluno = entrada.nextInt();
                    alunoDAO.deletar(idAluno);
                    break;

                case 4:
                    System.out.println("\n--- Cadastro de Professor(a) ---");
                    Professor novoProf = new Professor();
                    System.out.print("Nome: ");
                    novoProf.setNome(entrada.nextLine());
                    System.out.print("SIAPE: ");
                    novoProf.setSiape(entrada.nextLine());
                    System.out.print("Unidade Acadêmica: ");
                    novoProf.setUni_academica(entrada.nextLine());
                    System.out.print("Curso: ");
                    novoProf.setCurso(entrada.nextLine());

                    professorDAO.cadastrar(novoProf);
                    break;

                case 5:
                    System.out.println("\n--- Lista de Professores(as) ---");
                    ArrayList<Professor> listaProfs = professorDAO.listarProfessores();
                    for (Professor p : listaProfs) {
                        System.out.println("ID: " + p.getId() + " | Nome: " + p.getNome() + " | SIAPE: " + p.getSiape() + " | Unidade: " + p.getUni_academica());
                    }
                    break;

                case 6:
                    System.out.println("\n--- Excluir Professor(a) ---");
                    System.out.print("Digite o ID do professor que deseja excluir: ");
                    int idProf = entrada.nextInt();
                    professorDAO.deletar(idProf);
                    break;

                case 0:
                    System.out.println("Saindo do sistema... Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        entrada.close();
    }
}