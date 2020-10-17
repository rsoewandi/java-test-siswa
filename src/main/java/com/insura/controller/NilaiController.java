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

import com.insura.model.Nilai;
import com.insura.service.NilaiService;

@RestController
@RequestMapping(value="/api")
public class NilaiController {
	
	@Autowired
	NilaiService nilaiService;
	
	@PostMapping("/nilai/add")
	public ResponseEntity<String> add(@RequestParam(name = "excel",required = false) MultipartFile excel){
		nilaiService.add(excel);
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
	
	@GetMapping("/Nilai/nik/{nomorInduk}")
	public ResponseEntity<List<Nilai>> findByNik(@PathVariable String nomorInduk){
		return new ResponseEntity<>(nilaiService.findByNik(nomorInduk), HttpStatus.OK);
	}
	
	@GetMapping("/Nilai/nik/{mp}")
	public ResponseEntity<List<Nilai>> findByMataPelajaran(@PathVariable String mp){
		return new ResponseEntity<>(nilaiService.findByMataPelajaran(mp), HttpStatus.OK);
	}
	
	@GetMapping("/Nilai/nik/{nilai}")
	public ResponseEntity<List<Nilai>> findByNilai(@PathVariable Integer nilai){
		return new ResponseEntity<>(nilaiService.findByNilai(nilai), HttpStatus.OK);
	}
	
	
}
