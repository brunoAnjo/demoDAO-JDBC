package model.dao;

import db.DB;
import model.dao.impl.PostDaoJDBC;

public class DaoFactory {
	
	public static PostDao createPostDao() {
		return new PostDaoJDBC(DB.getConnection());
	}
	

}
