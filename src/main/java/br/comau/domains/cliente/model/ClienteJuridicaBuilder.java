package br.comau.domains.cliente.model;

public class ClienteJuridicaBuilder {

	private long id;
	private String razaoSocial;
	private String nomeFantasia;
	private TipoCliente tipo;
	private String cnpj;
	private String endereco;
	private String telefone;
	private String email;
	private String obs;
	private Status status;
	private String logo;
	

	public ClienteJuridicaBuilder() {}

	public ClienteJuridicaBuilder setId(long id) {
		this.id = id;
		return this;
	}

	public ClienteJuridicaBuilder setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
		return this;
	}

	public ClienteJuridicaBuilder setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
		return this;
	}

	public ClienteJuridicaBuilder setTipo(TipoCliente tipo) {
		this.tipo = tipo;
		return this;
	}

	public ClienteJuridicaBuilder setCnpj(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}

	public ClienteJuridicaBuilder setEndereco(String endereco) {
		this.endereco = endereco;
		return this;
	}
	
	public ClienteJuridicaBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	public ClienteJuridicaBuilder setTelefone(String telefone) {
		this.telefone = telefone;
		return this;
	}

	public ClienteJuridicaBuilder setObs(String obs) {
		this.obs = obs;
		return this;
	}

	public ClienteJuridicaBuilder setStatus(Status status) {
		this.status = status;
		return this;
	}

	public ClienteJuridicaBuilder setLogo(String logo) {
		this.logo = logo;
		return this;
	}

	public ClienteJuridica constroi() {
		ClienteJuridica clienteJuridica = new ClienteJuridica();
		clienteJuridica.setId(id);
		clienteJuridica.setRazaoSocial(razaoSocial);
		clienteJuridica.setNomeFantasia(nomeFantasia);
		clienteJuridica.setTipo(tipo);
		clienteJuridica.setCnpj(cnpj);
		clienteJuridica.setEndereco(endereco);
		clienteJuridica.setTelefone(telefone);
		clienteJuridica.setEmail(email);
		clienteJuridica.setObs(obs);
		clienteJuridica.setStatus(status);
		clienteJuridica.setLogo(logo);
		return clienteJuridica;
	}

}
