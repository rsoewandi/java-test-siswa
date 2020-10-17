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
import com.insura.model.Siswa;
import com.insura.repository.SiswaRepository;
import com.insura.utils.CSVHelper;

@Service
public class SiswaService {

	private final static Logger logger = LoggerFactory.getLogger(SiswaService.class);

	@Autowired
	SiswaRepository siswaRepo;
	
	@Autowired
	ConfigUtils configUtils;

	public void add(MultipartFile file) {
		try {

			if(CSVHelper.hasCSVFormat(file)==false) {
				throw new ValidationException("format file tidak sesuai");
			}
			List<Siswa> listSiswa = CSVHelper.csvToSiswas(file.getInputStream());
			siswaRepo.saveAll(listSiswa);
			logger.info("save siswa");
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
			List<Siswa> listNilai = new ArrayList<>();
			for (final File fileEntry : file.listFiles()) {
			    InputStream input = new FileInputStream(fileEntry);
			    listNilai.addAll(CSVHelper.csvToSiswas(input));
		    }
			siswaRepo.saveAll(listNilai);
			logger.info("save nilai from scheduler");
		}
		
	}
	
	public Siswa findByNik(String nomorInduk) {
		return siswaRepo.findById(nomorInduk).get();
	}
	
	public List<Siswa> findByKelas(String kelas) {
		return siswaRepo.findByKelas(kelas);
	}
	
	public List<Siswa> findByNama(String nama) {
		return siswaRepo.findByNama(nama);
	}

}
