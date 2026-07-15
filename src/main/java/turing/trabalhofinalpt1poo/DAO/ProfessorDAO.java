package turing.trabalhofinalpt1poo.DAO;

import turing.trabalhofinalpt1poo.entidades.Professor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfessorDAO {

    //Dados da base de dados MySQL
    private final String URL = "jdbc:mysql://localhost:3306/sistema_academico";
    private final String USUARIO = "root";
    private final String SENHA = "40028922";

    // 1. Método para Cadastrar Professor(a)
    public void cadastrar(Professor novoProfessor) {
        // Atenção: a tabela no banco deve se chamar 'professores'
        String sql = "INSERT INTO professores (nome, siape, unidade_academica, curso) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoProfessor.getNome());
            stmt.setString(2, novoProfessor.getSiape()); // Usando como String
            stmt.setString(3, novoProfessor.getUni_academica());
            stmt.setString(4, novoProfessor.getCurso());

            stmt.executeUpdate();
            System.out.println("Professor(a) cadastrado(a) com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar professor(a): " + e.getMessage());
        }
    }

    // 2. Método para Listar Professores
    public ArrayList<Professor> listarProfessores() {
        ArrayList<Professor> lista = new ArrayList<>();
        String sql = "SELECT * FROM professores";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Professor prof = new Professor();
                prof.setId(rs.getInt("id"));
                prof.setNome(rs.getString("nome"));
                prof.setSiape(rs.getString("siape")); // Resgatando como String
                prof.setUni_academica(rs.getString("unidade_academica")); // Mapeando a coluna do banco
                prof.setCurso(rs.getString("curso"));

                lista.add(prof);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar professores: " + e.getMessage());
        }

        return lista;
    }

    // 3. Método para Excluir Professor(a)
    public void deletar(int professor_id) {
        String sql = "DELETE FROM professores WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, professor_id);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Professor(a) removido(a) com sucesso!");
            } else {
                System.out.println("Nenhum(a) professor(a) encontrado(a) com o ID informado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao deletar professor(a): " + e.getMessage());
        }
    }
}