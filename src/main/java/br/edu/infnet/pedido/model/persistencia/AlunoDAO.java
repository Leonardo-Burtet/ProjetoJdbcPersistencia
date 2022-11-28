package br.edu.infnet.pedido.model.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.pedido.model.entidade.Aluno;

public class AlunoDAO extends JdbcDAO<Aluno> {

	public AlunoDAO() {
	}

	@Override
	public Boolean salvar(Aluno aluno) {
		String sql = "insert into Aluno(nome, matricula) values (?,null)";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, aluno.getNome()); // sql injection
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean atualizar(Aluno aluno) {
		String sql = "update Aluno set nome = ? where matricula = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, aluno.getNome());
			pstm.setLong(2, aluno.getMatricula());
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deletar(Aluno aluno) {
		String sql = "delete from Aluno where matricula = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, aluno.getMatricula());
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Aluno obter(Long matricula) {
		String sql = "select * from Aluno where matricula = ?";
		Aluno aluno = new Aluno();
		try {
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, matricula);
			rs = pstm.executeQuery();
			if (rs.next()) {
				String nome = rs.getString("nome");
				Long matriculaDB = rs.getLong("matricula");
				aluno = new Aluno(nome, matriculaDB);
			}
			return aluno;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Aluno> listarTodos() {
		String sql = "select * from Aluno";
		List<Aluno> Alunos = new ArrayList<>();
		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				String nome = rs.getString("nome");
				Long matricula = rs.getLong("matricula");
				Aluno Aluno = new Aluno(nome, matricula);
				Alunos.add(Aluno);
			}
			return Alunos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
