package beans;

public class BeanProdutos {

	private Long id;
	private String nome;
	private Integer qtd;
	private Double preco;
	private Long categoria_id;
	
	public void setCategoria_id(Long categoria_id) {
		this.categoria_id = categoria_id;
	}
	
	public Long getCategoria_id() {
		return categoria_id;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getQtd() {
		return qtd;
	}
	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public String getValorEmTexto() {
		return Double.toString(preco).replace('.', ',');
		
	}
	
}
