package com.insura.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Siswa {

	@Id
	private String nomorInduk;
	
	@Column
	private String nama;
	
	@Column
	private String kelas;
	
	public Siswa() {}

	public Siswa(String nomorInduk, String nama, String kelas) {
		super();
		this.nomorInduk = nomorInduk;
		this.nama = nama;
		this.kelas = kelas;
	}
}