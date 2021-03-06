package br.com.sempreufg.model.anuncio;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AnuncioPremium {

	private Long idAnuncioPremium;
	private Integer dataInicio;
	private Integer dataTermino;
	private Double valor;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "codAnuncio")
	private Anuncio anuncio;

	public AnuncioPremium() {
		anuncio = new Anuncio();
	}

	@Id
	@GeneratedValue
	public Long getIdAnuncioPremium() {
		return idAnuncioPremium;
	}

	public void setIdAnuncioPremium(Long idAnuncioPremium) {
		this.idAnuncioPremium = idAnuncioPremium;
	}

	public Integer getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Integer dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Integer getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Integer dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@JoinColumn(name = "codAnuncio")
	public Long getAnuncio() {
		return anuncio.getCodAnuncio();
	}

	public void setAnuncio(Long codAnuncio) {
		this.anuncio.setCodAnuncio(codAnuncio);
	}
}
