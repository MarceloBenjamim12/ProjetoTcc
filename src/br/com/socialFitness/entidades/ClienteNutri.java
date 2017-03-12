package br.com.socialFitness.entidades;

import java.io.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import br.com.socialFitness.entidades.*;
import javax.persistence.*;

@Entity
public class ClienteNutri implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Nutricionista prof;
	private Usuario cliente;
	private Date dtContrato;
	private Double Preco;
	private Integer vencimento;
	private String obs;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Nutricionista getProf() {
		return prof;
	}
	public void setProf(Nutricionista prof) {
		this.prof = prof;
	}
	public Usuario getCliente() {
		return cliente;
	}
	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	public Date getDtContrato() {
		return dtContrato;
	}
	public void setDtContrato(Date dtContrato) {
		this.dtContrato = dtContrato;
	}
	public Double getPreco() {
		return Preco;
	}
	public void setPreco(Double preco) {
		Preco = preco;
	}
	public Integer getVencimento() {
		return vencimento;
	}
	public void setVencimento(Integer vencimento) {
		this.vencimento = vencimento;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Preco == null) ? 0 : Preco.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((dtContrato == null) ? 0 : dtContrato.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((obs == null) ? 0 : obs.hashCode());
		result = prime * result + ((prof == null) ? 0 : prof.hashCode());
		result = prime * result + ((vencimento == null) ? 0 : vencimento.hashCode());
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
		ClienteNutri other = (ClienteNutri) obj;
		if (Preco == null) {
			if (other.Preco != null)
				return false;
		} else if (!Preco.equals(other.Preco))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (dtContrato == null) {
			if (other.dtContrato != null)
				return false;
		} else if (!dtContrato.equals(other.dtContrato))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (obs == null) {
			if (other.obs != null)
				return false;
		} else if (!obs.equals(other.obs))
			return false;
		if (prof == null) {
			if (other.prof != null)
				return false;
		} else if (!prof.equals(other.prof))
			return false;
		if (vencimento == null) {
			if (other.vencimento != null)
				return false;
		} else if (!vencimento.equals(other.vencimento))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ClienteNutri [id=" + id + ", prof=" + prof + ", cliente=" + cliente + ", dtContrato=" + dtContrato
				+ ", Preco=" + Preco + ", vencimento=" + vencimento + ", obs=" + obs + "]";
	}
	
	

}
