package com.example.www_week5_huynhhuuphuoc;

import com.example.www_week5_huynhhuuphuoc.backend.enums.Country;
import com.example.www_week5_huynhhuuphuoc.backend.models.Address;
import com.example.www_week5_huynhhuuphuoc.backend.models.Candidate;
import com.example.www_week5_huynhhuuphuoc.backend.repositories.AddressRepository;
import com.example.www_week5_huynhhuuphuoc.backend.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
public class WwwWeek5HuynhHuuPhuocApplication {

	public static void main(String[] args) {
		SpringApplication.run(WwwWeek5HuynhHuuPhuocApplication.class, args);
	}
	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private AddressRepository addressRepository;
//	@Bean
	CommandLineRunner initData(){
		return args -> {
			Random rnd =new Random();
			for (int i = 1; i < 1000; i++) {
				Address add = new Address("Quang Trung","HCM", Country.VIETNAM, rnd.nextInt(1,1000)+"", rnd.nextInt(70000,80000)+"" );
				addressRepository.save(add);
				add = addressRepository.findById(add.getAdd_id()).orElseThrow();
				Candidate can=new Candidate("Name #"+i,
						LocalDate.of(1998,rnd.nextInt(1,13),rnd.nextInt(1,29)),
						add,
						rnd.nextLong(1111111111L,9999999999L)+"",
						"email_"+i+"@gmail.com");
				candidateRepository.save(can);
				System.out.println("Added: " +can);
			}
		};
	}


}
