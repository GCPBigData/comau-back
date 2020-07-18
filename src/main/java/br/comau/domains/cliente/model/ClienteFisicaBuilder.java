package br.comau.domains.cliente.model;

import java.time.LocalDateTime;

import br.comau.model.Perfil;

public class ClienteFisicaBuilder {

	private long id;
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	private String email;
	private Status status;
	private String empresa;
	private Perfil perfil;
	private TipoCliente tipoClienteFisica;
	private LocalDateTime dataCadastro;
	private LocalDateTime vistoDataVencimento;
	

	public ClienteFisicaBuilder() {}

	public ClienteFisicaBuilder setId(long id) {
		this.id = id;
		return this;
	}

	public ClienteFisicaBuilder setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public ClienteFisicaBuilder setCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}

	public ClienteFisicaBuilder setEndereco(String endereco) {
		this.endereco = endereco;
		return this;
	}

	public ClienteFisicaBuilder setTelefone(String telefone) {
		this.telefone = telefone;
		return this;
	}

	public ClienteFisicaBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	public ClienteFisicaBuilder setStatus(Status status) {
		this.status = status;
		return this;
	}

	public ClienteFisicaBuilder setEmpresa(String empresa) {
		this.empresa = empresa;
		return this;
	}

	public ClienteFisicaBuilder setPerfil(Perfil perfil) {
		this.perfil = perfil;
		return this;
	}

	public ClienteFisicaBuilder setTipoClienteFisica(TipoCliente tipoClienteFisica) {
		this.tipoClienteFisica = tipoClienteFisica;
		return this;
	}

	public ClienteFisicaBuilder setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
		return this;
	}

	public ClienteFisicaBuilder setVistoDataVencimento(LocalDateTime vistoDataVencimento) {
		this.vistoDataVencimento = vistoDataVencimento;
		return this;
	}
	
	public ClienteFisica constroi() {
		ClienteFisica clienteFisica = new ClienteFisica();
		clienteFisica.setId(id);
		clienteFisica.setNome(nome);
		clienteFisica.setCpf(cpf);
		clienteFisica.setEndereco(endereco);
		clienteFisica.setTelefone(telefone);
		clienteFisica.setEmail(email);
		clienteFisica.setStatus(status);
		clienteFisica.setEmpresa(empresa);
		clienteFisica.setPerfil(perfil);
		clienteFisica.setTipoClienteFisica(tipoClienteFisica);
		clienteFisica.setDataCadastro(dataCadastro);
		clienteFisica.setVistoDataVencimento(vistoDataVencimento);
		return clienteFisica;
	}

}
