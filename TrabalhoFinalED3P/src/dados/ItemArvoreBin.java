package dados;

public class ItemArvoreBin {
	private int ap;
	private Long telefone,cpf;
	private String nome,email;

	public ItemArvoreBin(String nome, Long cpf, int ap, Long telefone, String email) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.ap = ap;
		this.telefone = telefone;
		this.email = email;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public int getAp() {
		return ap;
	}

	public void setAp(int ap) {
		this.ap = ap;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
