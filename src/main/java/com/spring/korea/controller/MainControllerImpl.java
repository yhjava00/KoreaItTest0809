package com.spring.korea.controller;

import javax.servlet.http.HttpServletRequest;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.korea.MyJob;
import com.spring.korea.dto.MemberDTO;
import com.spring.korea.service.MainService;

@Controller
public class MainControllerImpl implements MainController {

	@Autowired
	MainService mainService;
	

	@RequestMapping(value = "/start")  // 스케줄러 시작할게요 (= 10초마다 MyJob 실행할게요).
	public String homeStart() throws SchedulerException {
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		
		  // define the job and tie it to our HelloJob class
		  JobDetail job = JobBuilder.newJob(MyJob.class)
		      .withIdentity("job1", "group1")
		      .build();

		  // Trigger the job to run now, and then repeat every 40 seconds
		  Trigger trigger = TriggerBuilder.newTrigger()
		      .withIdentity("trigger1", "group1")
		      .startNow()
		      .withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * * * ?"))
		      .build();

		  // Tell quartz to schedule the job using our trigger
		  scheduler.scheduleJob(job, trigger);
		  scheduler.start();
		  System.out.println("<<< 포인트 스케줄러가 시작되었습니다. >>>");
		return "admin";
	}
	
	@RequestMapping(value = "/end")    // 스케줄러 끝낼게요 (= MyJob 그만 할게요).
	public String homeEnd() throws SchedulerException {
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.shutdown();
		System.out.println("<<< 포인트 스케줄러의 실행이 종료되었습니다.. >>>");
		return "admin";
	}
	
	@RequestMapping("/main")
	public String main(HttpServletRequest request, String goods, String plus) {
		
		String id = (String) request.getSession().getAttribute("login");
		
		MemberDTO member = mainService.getMember(id);
		
		request.setAttribute("goods", goods);
		request.setAttribute("plus", plus);
		request.setAttribute("member", member);
		
		return "main";
	}
	
	@Override
	@RequestMapping("/purchase")
	public String purchase(HttpServletRequest request, String goods, int point) {
		
		String id = (String) request.getSession().getAttribute("login");
		
		mainService.purchase(id, point);
		
		return "redirect:main?goods=" + goods;
	}
	
	@Override
	@RequestMapping("/plusPoint")
	public String plusPoint(HttpServletRequest request) {

		String id = (String) request.getSession().getAttribute("login");

		mainService.plusPoint(id);
		
		return "redirect:main?plus=plus";
	}
	
	@Override
	@RequestMapping(value = {"/", "login"})
	public String login(HttpServletRequest request, String state) {
		
		request.setAttribute("state", state);
		
		return "login";
	}

	@Override
	@RequestMapping("/loginAction")
	public String loginAction(HttpServletRequest request, MemberDTO member) {
		String state = mainService.login(member);

		if(state.equals("fail")) {
			return "redirect:login?state=fail";
		}
		
		if(state.equals("admin")) {
			return "admin";
		}
		
		member = mainService.getMember(member.getId());
		
		request.getSession().setAttribute("login", member.getId());
		
		request.setAttribute("member", member);
		
		return "main";
	}
	
	@Override
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {

		request.setAttribute("msg", "logout");
		
		request.getSession().removeAttribute("login");
		
		return "redirect:login?state=logout";
	}

	@Override
	@RequestMapping("signUp")
	public String signUp() {
		return "signUp";
	}

	@Override
	@RequestMapping("/signUpAction")
	public String signUpAction(HttpServletRequest request, MemberDTO member) {
		
		mainService.signUp(member);
		
		return "redirect:login?state=signUp";
	}
	
	@Override
	public String adminPage() {
		return null;
	}
	
}
