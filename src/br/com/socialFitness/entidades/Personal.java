package br.com.socialFitness.entidades;

import java.io.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import br.com.socialFitness.entidades.*;
import javax.persistence.*;

@Entity
public class Personal implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Usuario UserID;
	private String Espec;
	private Plano planoID;
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
		UserID = UserID;
	}
	@Column(length=100)
	public String getEspec() {
		return Espec;
	}
	public void setEspec(String espec) {
		Espec = espec;
	}
	public Plano getPlanoID() {
		return planoID;
	}
	public void setPlanoID(Plano planoID) {
		this.planoID = planoID;
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
		result = prime * result + ((Espec == null) ? 0 : Espec.hashCode());
		result = prime * result + ((UserID == null) ? 0 : UserID.hashCode());
		result = prime * result + ((ag == null) ? 0 : ag.hashCode());
		result = prime * result + ((classif == null) ? 0 : classif.hashCode());
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((obs == null) ? 0 : obs.hashCode());
		result = prime * result + ((planoID == null) ? 0 : planoID.hashCode());
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
		Personal other = (Personal) obj;
		if (Espec == null) {
			if (other.Espec != null)
				return false;
		} else if (!Espec.equals(other.Espec))
			return false;
		if (UserID == null) {
			if (other.UserID != null)
				return false;
		} else if (!UserID.equals(other.UserID))
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
		if (planoID == null) {
			if (other.planoID != null)
				return false;
		} else if (!planoID.equals(other.planoID))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Personal [id=" + id + ", UserID=" + UserID + ", Espec=" + Espec + ", planoID=" + planoID + ", obs="
				+ obs + ", ag=" + ag + ", conta=" + conta + ", classif=" + classif + "]";
	}
	
	
	
}
