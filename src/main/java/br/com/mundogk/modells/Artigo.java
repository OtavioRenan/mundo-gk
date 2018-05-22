package br.com.mundogk.modells;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
public class Artigo implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_artigo;
	
	
	//Primariamente essa coluna chamava-se ´txtArtigo,
	//mas por algum motivo o hibernate mudou para txt_artigo e na inserção de dados
	//o mysql não encontrava a tabela.´
	@Lob
	@Column(columnDefinition="TEXT")
	@NotBlank(message="*O artigo não pode estar em branco")
	//@Length(min=300, message="O artigo não pode ter menos que 300 caracteres!")
	private String txt_artigo;
	
	@Basic
	@NotBlank(message="*Informe a data")
	private String data_publicacao;
	
	@NotBlank(message="*Informe o titulo")
	private String titulo;
	
	@JoinColumn(name="id_entidae")
	@NotNull(message="*Informe a entidade")
	private Long id_entidade;
	
	@NotBlank(message="*Informe o nome do autor")
	private String autor;
	
	//método para pegar a data do sistema
	
	public Long getId_artigo() {
		return id_artigo;
	}
	public String getData_publicacao() {
		return data_publicacao;
	}
	public void setData_publicacao(String data_publicacao) {
		this.data_publicacao = data_publicacao;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setId_artigo(Long id_artigo) {
		this.id_artigo = id_artigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}	
	public String getTxt_artigo() {
		return txt_artigo;
	}
	public void setTxt_artigo(String txt_artigo) {
		this.txt_artigo = txt_artigo;
	}
	public Long getId_entidade() {
		return id_entidade;
	}
	public void setId_entidade(Long id_entidade) {
		this.id_entidade = id_entidade;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((data_publicacao == null) ? 0 : data_publicacao.hashCode());
		result = prime * result + ((id_artigo == null) ? 0 : id_artigo.hashCode());
		result = prime * result + ((id_entidade == null) ? 0 : id_entidade.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		result = prime * result + ((txt_artigo == null) ? 0 : txt_artigo.hashCode());
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
		Artigo other = (Artigo) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (data_publicacao == null) {
			if (other.data_publicacao != null)
				return false;
		} else if (!data_publicacao.equals(other.data_publicacao))
			return false;
		if (id_artigo == null) {
			if (other.id_artigo != null)
				return false;
		} else if (!id_artigo.equals(other.id_artigo))
			return false;
		if (id_entidade == null) {
			if (other.id_entidade != null)
				return false;
		} else if (!id_entidade.equals(other.id_entidade))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (txt_artigo == null) {
			if (other.txt_artigo != null)
				return false;
		} else if (!txt_artigo.equals(other.txt_artigo))
			return false;
		return true;
	}
	
	
}