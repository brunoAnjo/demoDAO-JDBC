package application;

import java.text.ParseException;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.PostDao;
import model.entities.Post;
import model.entities.Usuario;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		PostDao postDao = DaoFactory.createPostDao();
		
		System.out.println("===Teste 1: Post findById ===");
		Post post = postDao.findById(1);
		System.out.println(post);
		
		System.out.println("\n===Teste 2: Post findByUsuario ===");
		Usuario user = new Usuario(1, null, null, null);
		List<Post> list = postDao.findByUsuario(user);
		
		for(Post obj : list) {
			System.out.println(obj);
		}
		
		
		System.out.println("\n===Teste 3: Post findAll() ===");
		list = postDao.findAll();
		for(Post obj : list) {
			System.out.println(obj);
		}
		
	}

}
