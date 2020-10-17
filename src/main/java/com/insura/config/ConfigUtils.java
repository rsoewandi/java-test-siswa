package com.insura.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ConfigUtils {
	
	@Value("${directory.nilai}")
	private String dirNilai;
	
	@Value("${directory.siswa}")
	private String dirSiswa;

}
