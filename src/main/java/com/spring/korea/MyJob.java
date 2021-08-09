package com.spring.korea;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.korea.dao.MainDAO;

public class MyJob implements Job {

	@Autowired
	MainDAO mainDAO;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		int num = mainDAO.updateOnePoint();
		System.out.println("Job이 실행됨 : " + new Date(System.currentTimeMillis()) + " / " + num + "명에게 포인트 부여(1점).");
	}

}