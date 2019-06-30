package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.entities.Usuario;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Usuario user = new Usuario(1 , "Bruno", "Anjo", sdf.parse("1993-11-08"));
		System.out.println(user);
		
		
	}

}
