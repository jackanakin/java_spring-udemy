package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {

	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside of doMyStartupStuff()");
	}

	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside of doMyCleanupStuff()");
	}
	//Field injection
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	/*@Autowired - Constructor Injection
	public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}*/

	/*@Autowired - setter Injection
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside setFortuneService() method");
		this.fortuneService = theFortuneService;
	}*/
/*
	@Value("${foo.email}")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Value("${foo.team}")
	private String team;
*/
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
