package br.com.doceasier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.doceasier.config.Config;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//System.out.println("Iniicou !");
		SpringApplication.run(Config.class, args);
	}

}
