package br.com.socialFitness.entidades;

import java.io.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import br.com.socialFitness.entidades.*;
import javax.persistence.*;

@Entity
public class Msg implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Usuario msgEnv;
	private Usuario msgReceb;
	private Date dtEnvio;
	private String msg;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Usuario getMsgEnv() {
		return msgEnv;
	}
	public void setMsgEnv(Usuario msgEnv) {
		this.msgEnv = msgEnv;
	}
	public Usuario getMsgReceb() {
		return msgReceb;
	}
	public void setMsgReceb(Usuario msgReceb) {
		this.msgReceb = msgReceb;
	}
	public Date getDtEnvio() {
		return dtEnvio;
	}
	public void setDtEnvio(Date dtEnvio) {
		this.dtEnvio = dtEnvio;
	}
	@Column(length=500)
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtEnvio == null) ? 0 : dtEnvio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((msg == null) ? 0 : msg.hashCode());
		result = prime * result + ((msgEnv == null) ? 0 : msgEnv.hashCode());
		result = prime * result + ((msgReceb == null) ? 0 : msgReceb.hashCode());
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
		Msg other = (Msg) obj;
		if (dtEnvio == null) {
			if (other.dtEnvio != null)
				return false;
		} else if (!dtEnvio.equals(other.dtEnvio))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (msg == null) {
			if (other.msg != null)
				return false;
		} else if (!msg.equals(other.msg))
			return false;
		if (msgEnv == null) {
			if (other.msgEnv != null)
				return false;
		} else if (!msgEnv.equals(other.msgEnv))
			return false;
		if (msgReceb == null) {
			if (other.msgReceb != null)
				return false;
		} else if (!msgReceb.equals(other.msgReceb))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Msg [id=" + id + ", msgEnv=" + msgEnv + ", msgReceb=" + msgReceb + ", dtEnvio=" + dtEnvio + ", msg="
				+ msg + "]";
	}
	
		
}
