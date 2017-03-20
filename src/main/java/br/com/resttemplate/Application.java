package br.com.resttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.resttemplate.config.Config;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//System.out.println("Iniicou !");
		SpringApplication.run(Config.class, args);
	}

}
