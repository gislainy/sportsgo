package br.com.sempreufg.model.anuncio;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class AnuncioArquivo {

	private Long idArquivo;	
	private String enderecoArquivo;
	
	public AnuncioArquivo(){
		anuncio = new Anuncio();
	}
	
	public AnuncioArquivo(Anuncio anuncio, String enderecoArquivo){
		this.anuncio = anuncio;
		this.enderecoArquivo = enderecoArquivo;
	}
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.REFRESH)
	@JoinColumn(name="codAnuncio")
	private Anuncio anuncio;
	
	@JsonProperty
	public void setanuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}
	
	@Id
	@GeneratedValue
	public Long getIdArquivo() {
		return idArquivo;
	}

	public void setIdArquivo(Long idArquivo) {
		this.idArquivo = idArquivo;
	}
	@Column(name="codAnuncio")
	public Long getAnuncio() {
		return anuncio.getCodAnuncio();
	}
	public void setAnuncio(Long codAnuncio) {
		this.anuncio.setCodAnuncio(codAnuncio);
	}
	public String getEnderecoArquivo() {
		return enderecoArquivo;
	}

	public void setEnderecoArquivo(String enderecoArquivo) {
		this.enderecoArquivo = enderecoArquivo;
	}
}
