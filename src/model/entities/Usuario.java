package model.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private Integer id;
	private String name;
	private String sobrenome;
	private Date dataNas;
	
	public Usuario() {		
	}
	
	public Usuario(Integer id, String name, String sobrenome, Date dataNas) {
		this.id = id;
		this.name = name;
		this.sobrenome = sobrenome;
		this.dataNas = dataNas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getDataNas() {
		return dataNas;
	}

	public void setDataNas(Date dataNas) {
		this.dataNas = dataNas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", name=" + name + ", sobrenome=" + sobrenome + ", dataNas=" + sdf.format(dataNas) + "]";
	}
	
	

}
