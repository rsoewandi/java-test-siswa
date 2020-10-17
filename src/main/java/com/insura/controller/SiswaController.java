package com.insura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.insura.model.Siswa;
import com.insura.service.SiswaService;

@RestController
@RequestMapping(value="/api")
public class SiswaController {
	
	@Autowired
	SiswaService siswaService;
	
	@PostMapping("/siswa/add")
	public ResponseEntity<String> add(@RequestParam(name = "excel",required = false) MultipartFile excel){
		siswaService.add(excel);
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
	
	@GetMapping("/siswa/nik/{nomorInduk}")
	public ResponseEntity<Siswa> findByNik(@PathVariable String nomorInduk){
		return new ResponseEntity<>(siswaService.findByNik(nomorInduk), HttpStatus.OK);
	}
	
	@GetMapping("/siswa/nik/{kelas}")
	public ResponseEntity<List<Siswa>> findByKelas(@PathVariable String kelas){
		return new ResponseEntity<>(siswaService.findByKelas(kelas), HttpStatus.OK);
	}
	
	@GetMapping("/siswa/nik/{nama}")
	public ResponseEntity<List<Siswa>> findByNilai(@PathVariable String nama){
		return new ResponseEntity<>(siswaService.findByNama(nama), HttpStatus.OK);
	}
	
	
}
