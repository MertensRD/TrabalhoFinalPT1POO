package turing.trabalhofinalpt1poo.DAO;

import turing.trabalhofinalpt1poo.entidades.Aluno;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlunoDAO {

    //Dados da base de dados MySQL
    private final String URL = "jdbc:mysql://localhost:3306/sistema_academico";
    private final String UTILIZADOR = "root";
    private final String PALAVRA_PASSE = "40028922"; // Se não tiver senha, deixem vazio: ""

    // 1. Método para Cadastrar
    public void cadastrar(Aluno novoAluno) {
        String sql = "INSERT INTO alunos (nome, rga, email, curso) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, UTILIZADOR, PALAVRA_PASSE);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoAluno.getNome());
            stmt.setString(2, novoAluno.getRga()); // Alterem para setInt se mantiveram o rga como int
            stmt.setString(3, novoAluno.getEmail());
            stmt.setString(4, novoAluno.getCurso());

            stmt.executeUpdate(); // Executa a inserção na base de dados
            System.out.println("Aluno registado com sucesso na base de dados!");

        } catch (SQLException e) {
            System.out.println("Erro ao registar aluno: " + e.getMessage());
        }
    }

    // 2. Método para Listar
    public ArrayList<Aluno> listarAlunos() {
        ArrayList<Aluno> lista = new ArrayList<>();
        String sql = "SELECT * FROM alunos";

        try (Connection conn = DriverManager.getConnection(URL, UTILIZADOR, PALAVRA_PASSE);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setRga(rs.getString("rga")); // Alterem para getInt se rga for int
                aluno.setEmail(rs.getString("email"));
                aluno.setCurso(rs.getString("curso"));

                lista.add(aluno);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar alunos: " + e.getMessage());
        }
        return lista;
    }

    // 3. Método para Deletar
    public void deletar(int aluno_id) {
        String sql = "DELETE FROM alunos WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, UTILIZADOR, PALAVRA_PASSE);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, aluno_id);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Aluno removido com sucesso!");
            } else {
                System.out.println("Nenhum aluno encontrado com esse ID.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao remover aluno: " + e.getMessage());
        }
    }
}