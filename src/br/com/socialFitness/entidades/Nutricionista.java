package br.com.socialFitness.entidades;

import java.io.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import br.com.socialFitness.entidades.*;
import javax.persistence.*;

@Entity
public class Nutricionista implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Usuario UserID;
	private String espec;
	private Plano PlanoID;
	private String obs;
	private String ag;
	private String conta;
	private Double classif;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Usuario getUserID() {
		return UserID;
	}
	public void setUserID(Usuario UserID) {
		this.UserID = UserID;
	}
	@Column(length=100)
	public String getEspec() {
		return espec;
	}
	public void setEspec(String espec) {
		this.espec = espec;
	}
	public Plano getPlanoID() {
		return PlanoID;
	}
	public void setPlanoID(Plano planoID) {
		PlanoID = planoID;
	}
	@Column(length=1000)
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	@Column(length=10)
	public String getAg() {
		return ag;
	}
	public void setAg(String ag) {
		this.ag = ag;
	}
	@Column(length=25)
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public Double getClassif() {
		return classif;
	}
	public void setClassif(Double classif) {
		this.classif = classif;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PlanoID == null) ? 0 : PlanoID.hashCode());
		result = prime * result + ((ag == null) ? 0 : ag.hashCode());
		result = prime * result + ((classif == null) ? 0 : classif.hashCode());
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
		result = prime * result + ((espec == null) ? 0 : espec.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((obs == null) ? 0 : obs.hashCode());
		result = prime * result + ((UserID == null) ? 0 : UserID.hashCode());
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
		Nutricionista other = (Nutricionista) obj;
		if (PlanoID == null) {
			if (other.PlanoID != null)
				return false;
		} else if (!PlanoID.equals(other.PlanoID))
			return false;
		if (ag == null) {
			if (other.ag != null)
				return false;
		} else if (!ag.equals(other.ag))
			return false;
		if (classif == null) {
			if (other.classif != null)
				return false;
		} else if (!classif.equals(other.classif))
			return false;
		if (conta == null) {
			if (other.conta != null)
				return false;
		} else if (!conta.equals(other.conta))
			return false;
		if (espec == null) {
			if (other.espec != null)
				return false;
		} else if (!espec.equals(other.espec))
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
		if (UserID == null) {
			if (other.UserID != null)
				return false;
		} else if (!UserID.equals(other.UserID))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Nutricionista [id=" + id + ", userID=" + UserID + ", espec=" + espec + ", PlanoID=" + PlanoID + ", obs="
				+ obs + ", ag=" + ag + ", conta=" + conta + ", classif=" + classif + "]";
	}
	
	
	
}
