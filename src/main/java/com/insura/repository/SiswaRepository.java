package com.insura.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insura.model.Siswa;

@Repository
public interface SiswaRepository extends CrudRepository<Siswa, String>{
	List<Siswa> findByKelas(String kelas);
	List<Siswa> findByNama(String nama);
	
}
