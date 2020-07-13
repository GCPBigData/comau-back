package br.comau.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "putinhas")
public class Putinhas {

	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	
	@Id
	private long id;
	
	//@NotBlank
    //@Size(max=100)
    //@Indexed(unique=true)
	private String nome;
	private String nomeGuerra;

	//@NotBlank
    //@Size(max=100)
    //@Indexed(unique=true)
	private String email;
	
	public Putinhas() {
		
	}
	
	public Putinhas(String nome, String nomeGuerra, String email) {
		this.nome = nome;
		this.nomeGuerra = nomeGuerra;
		this.email = email;
	}

	public Putinhas(long id, String nome, String nomeGuerra, String email) {
		this.id = id;
		this.nome = nome;
		this.nomeGuerra = nomeGuerra;
		this.email = email;
	}

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeGuerra() {
		return nomeGuerra;
	}

	public void setNomeGuerra(String nomeGuerra) {
		this.nomeGuerra = nomeGuerra;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
