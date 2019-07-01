package model.dao;

import model.dao.impl.PostDaoJDBC;

public class DaoFactory {
	
	public static PostDao createPostDao() {
		return new PostDaoJDBC();
	}
	

}
