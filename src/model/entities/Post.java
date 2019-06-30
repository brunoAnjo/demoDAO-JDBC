package model.entities;

import java.io.Serializable;
import java.util.Date;

public class Post implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer idpost;
	private String post;
	private Date datePost;
	
	private Usuario usuario;
	
	public Post() {
	}

	public Post(Integer idpost, String post, Date datePost, Usuario usuario) {
		this.idpost = idpost;
		this.post = post;
		this.datePost = datePost;
		this.usuario = usuario;
	}

	public Integer getIdpost() {
		return idpost;
	}

	public void setIdpost(Integer idpost) {
		this.idpost = idpost;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Date getDatePost() {
		return datePost;
	}

	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idpost == null) ? 0 : idpost.hashCode());
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
		Post other = (Post) obj;
		if (idpost == null) {
			if (other.idpost != null)
				return false;
		} else if (!idpost.equals(other.idpost))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Post [idpost=" + idpost + ", post=" + post + ", datePost=" + datePost + ", usuario=" + usuario + "]";
	}

	
	

}
