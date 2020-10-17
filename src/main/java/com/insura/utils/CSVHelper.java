package com.insura.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.insura.model.Nilai;
import com.insura.model.Siswa;

public class CSVHelper {
	public static String TYPE = "text/csv";

	public static boolean hasCSVFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<Nilai> csvToNilais(InputStream is) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			List<Nilai> nilais = new ArrayList<Nilai>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for (CSVRecord csvRecord : csvRecords) {
				String nik = csvRecord.get("nomor_induk");
				String mataPelajaran = csvRecord.get("mata_pelajaran");
				Integer nilai = Integer.valueOf(csvRecord.get("nilai"));
				nilais.add(new Nilai(nik, mataPelajaran, nilai));
			}

			return nilais;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}
	
	public static List<Siswa> csvToSiswas(InputStream is) {
	    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        CSVParser csvParser = new CSVParser(fileReader,
	            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

	      List<Siswa> nilais = new ArrayList<Siswa>();

	      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

	      for (CSVRecord csvRecord : csvRecords) {
	    	  String nik = csvRecord.get("nomor_induk");
	    	  String nama = csvRecord.get("nama");
	    	  String kelas = csvRecord.get("kelas");
	    	  nilais.add(new Siswa(nik,nama,kelas));
	      }

	      return nilais;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
	    }
	  }
}
