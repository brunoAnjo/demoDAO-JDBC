package application;

import java.text.ParseException;

import model.dao.DaoFactory;
import model.dao.PostDao;
import model.entities.Post;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		PostDao postDao = DaoFactory.createPostDao();
		
		Post post = postDao.findById(1);
		
		System.out.println(post);
		
		
		
	}

}
