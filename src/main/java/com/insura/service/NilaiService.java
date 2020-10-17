package com.insura.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.insura.config.ConfigUtils;
import com.insura.exception.ValidationException;
import com.insura.model.Nilai;
import com.insura.repository.NilaiRepository;
import com.insura.utils.CSVHelper;

@Service
public class NilaiService {

	private final static Logger logger = LoggerFactory.getLogger(NilaiService.class);

	@Autowired
	NilaiRepository nilaiRepo;
	
	@Autowired
	ConfigUtils configUtils;

	public void add(MultipartFile file) {
		try {

			if (CSVHelper.hasCSVFormat(file) == false) {
				throw new ValidationException("format file tidak sesuai");
			}
			List<Nilai> listNilai = CSVHelper.csvToNilais(file.getInputStream());
			nilaiRepo.saveAll(listNilai);
			logger.info("save nilai");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scheduler() throws IOException {
		File file = new File(configUtils.getDirNilai());
		
		if(!file.exists()) {
			logger.info("file not exist");
			Files.createDirectories(file.toPath());
		}else {
			List<Nilai> listNilai = new ArrayList<>();
			for (final File fileEntry : file.listFiles()) {
			    InputStream input = new FileInputStream(fileEntry);
			    listNilai.addAll(CSVHelper.csvToNilais(input));
		    }
			nilaiRepo.saveAll(listNilai);
			logger.info("save nilai from scheduler");
		}
		
	}
	
	public List<Nilai> findByNik(String nomorInduk) {
		return nilaiRepo.findByNomorInduk(nomorInduk);
	}
	
	public List<Nilai> findByMataPelajaran(String mp) {
		return nilaiRepo.findByMataPelajaran(mp);
	}
	
	public List<Nilai> findByNilai(Integer nomorInduk) {
		return nilaiRepo.findByNilai(nomorInduk);
	}

}
