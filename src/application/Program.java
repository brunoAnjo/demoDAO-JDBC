package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.dao.DaoFactory;
import model.dao.PostDao;
import model.entities.Post;
import model.entities.Usuario;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Usuario user = new Usuario(1 , "Bruno", "Anjo", sdf.parse("1993-11-08"));
		Post post = new Post(21, "gdsgdfgabhsabshaasgsaffsga", new Date(), user);
		
		PostDao postDao = DaoFactory.createPostDao();
		
		System.out.println(post);
		
		
		
	}

}
