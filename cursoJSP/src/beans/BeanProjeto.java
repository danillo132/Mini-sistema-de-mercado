package beans;

import java.util.ArrayList;
import java.util.List;

public class BeanProjeto {

	
	private Long id;
	private String nome;
	
	List<BeanSeries> series = new ArrayList<BeanSeries>();
	
	public void setSeries(List<BeanSeries> series) {
		this.series = series;
	}
	
	public List<BeanSeries> getSeries() {
		return series;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
