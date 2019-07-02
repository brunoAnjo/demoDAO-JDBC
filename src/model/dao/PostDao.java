package model.dao;

import java.util.List;

import model.entities.Post;
import model.entities.Usuario;

public interface PostDao {
	
	void insert(Post obj);
	void update(Post obj);
	void deleteById(Integer id);
	Post findById(Integer id);
	List<Post> findAll();
	List<Post> findByUsuario(Usuario user);

}
