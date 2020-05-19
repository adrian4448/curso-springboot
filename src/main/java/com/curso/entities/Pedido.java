package com.curso.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.curso.entities.enums.StatusPedido;

@Entity
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public Usuario getUsuario() {
		return cliente;
	}

	public void setUsuario(Usuario cliente) {
		this.cliente = cliente;
	}
	
	public StatusPedido getStatusPedido() {
		return StatusPedido.valueOf(statusPedido);
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido.getCode();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant momento;
	private Integer statusPedido;
	
	

	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Usuario cliente;
	
	public Pedido() {
		
	}
	
	public Pedido(Long id, Instant momento,StatusPedido statusPedido, Usuario cliente) {
		this.id = id;
		this.momento = momento;
		setStatusPedido(statusPedido);;
		this.cliente = cliente;
		
	}
	
}