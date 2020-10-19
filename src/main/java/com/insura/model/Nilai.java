package com.insura.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Nilai {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String nomorInduk;
	
	@Column
	private String mataPelajaran;
	
	@Column
	private Integer nilai;
	
	public Nilai() {}

	public Nilai(String nomorInduk, String mataPelajaran, Integer nilai) {
		super();
		this.nomorInduk = nomorInduk;
		this.mataPelajaran = mataPelajaran;
		this.nilai = nilai;
	}

	
}