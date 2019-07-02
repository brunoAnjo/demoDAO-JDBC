package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.PostDao;
import model.entities.Post;
import model.entities.Usuario;

public class PostDaoJDBC implements PostDao{

	private Connection conn;
	
	public PostDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Post obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Post obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Post findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT comentario.*, usuarios.nome as UserNome, usuarios.sobrenome, usuarios.datanas "
					+ "FROM comentario INNER JOIN usuarios "
					+ "ON comentario.idUsuarios = usuarios.idusuarios "
					+ "WHERE comentario.idcomentario = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Usuario user = instanciaUser(rs);
				
				Post post = instanciaPost(rs, user);
				return post;
			}
			return null;
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage()); 
		}finally {
			DB.closeStatement(st);
			DB.closeResultSett(rs);
		}
		
	}

	private Post instanciaPost(ResultSet rs, Usuario user) throws SQLException {
		Post post = new Post();
		post.setIdpost(rs.getInt("idcomentario"));
		post.setPost(rs.getString("comentario"));
		post.setUsuario(user);
		
		return post;
	}

	private Usuario instanciaUser(ResultSet rs) throws SQLException {
		Usuario user = new Usuario();
		user.setId(rs.getInt("idusuarios"));
		user.setName(rs.getString("UserNome"));
		user.setSobrenome(rs.getString("sobrenome"));
		user.setDataNas(rs.getDate("datanas"));
		return user;
	}


	@Override
	public List<Post> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT comentario.*, usuarios.nome as UserNome, usuarios.sobrenome, usuarios.datanas "
					+ "FROM comentario INNER JOIN usuarios "
					+ "ON comentario.idUsuarios = usuarios.idusuarios "
					+ "ORDER BY UserNome");
			
			rs = st.executeQuery();
			
			List<Post> list = new ArrayList<>();
			Map<Integer, Usuario> map = new HashMap<>();
			
			while(rs.next()) {
				
				Usuario user = map.get(rs.getInt("idusuarios"));
				
				if(user == null) {
					user = instanciaUser(rs);
					map.put(rs.getInt("idusuarios"), user);
				}
				
				
				Post post = instanciaPost(rs, user);
				list.add(post);
				
			}
			
			return list;
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage()); 
		}finally {
			DB.closeStatement(st);
			DB.closeResultSett(rs);
		}
		
	}

	@Override
	public List<Post> findByUsuario(Usuario use) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT comentario.*, usuarios.nome as UserNome, usuarios.sobrenome, usuarios.datanas "
					+ "FROM comentario INNER JOIN usuarios "
					+ "ON comentario.idUsuarios = usuarios.idusuarios "
					+ "WHERE usuarios.idusuarios = ? ORDER BY UserNome");
			
			st.setInt(1, use.getId());
			
			rs = st.executeQuery();
			
			List<Post> list = new ArrayList<>();
			Map<Integer, Usuario> map = new HashMap<>();
			
			while(rs.next()) {
				
				Usuario user = map.get(rs.getInt("idusuarios"));
				
				if(user == null) {
					user = instanciaUser(rs);
					map.put(rs.getInt("idusuarios"), user);
				}
				
				
				Post post = instanciaPost(rs, user);
				list.add(post);
				
			}
			
			return list;
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage()); 
		}finally {
			DB.closeStatement(st);
			DB.closeResultSett(rs);
		}
	}

}
