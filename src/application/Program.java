package application;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.PostDao;
import model.entities.Post;
import model.entities.Usuario;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
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
		
		System.out.println("\n===Teste 4: Post Insert() ===");
		Post post2 = new Post(null, "gtmnsagadsfadr", new Date(), user);
		postDao.insert(post2);
		System.out.println("Inserido! Novo id = " + post2.getIdpost());
		
		System.out.println("\n===Teste 5: Post Update() ===");
		post = postDao.findById(3);
		post.setPost("Martha Wenny morreu quando Bruce tinha apenhas 8 anos");
		postDao.update(post);
		
		System.out.println("\n===Teste �6: Post Delete() ===");
		System.out.println("Enter com o id que vai ser deletado do POST: ");
		int id = sc.nextInt();
		postDao.deleteById(id);
		System.out.println("Delete completo");
		
		sc.close();
	}

}
