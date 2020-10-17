package com.insura.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insura.model.Nilai;

@Repository
public interface NilaiRepository extends CrudRepository<Nilai, Long>{
	List<Nilai> findByNomorInduk(String nomorInduk);
	List<Nilai> findByMataPelajaran(String mataPelajaran);
	List<Nilai> findByNilai(Integer nilai);
}
