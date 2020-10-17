package com.insura.scheduler;


import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.insura.service.NilaiService;
import com.insura.service.SiswaService;

@Component
public class CloseScheduler {
	
	private static final Logger logger = LoggerFactory.getLogger(CloseScheduler.class);

	@Autowired
	NilaiService nilaiService;
	
	@Autowired
	SiswaService siswaService;

	@Scheduled(cron="0 0 23 * * *")
    public void checkFileInput() throws IOException{
    	logger.info("check is any file input");
    	nilaiService.scheduler();
    	siswaService.scheduler();
    }
}