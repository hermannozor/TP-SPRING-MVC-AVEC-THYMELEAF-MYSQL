package com.supinfoB2.tpSpringMvnCmd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;

import com.supinfoB2.tpSpringMvnCmd.entities.*;

import com.supinfoB2.tpSpringMvnCmd.dao.ClientRepository;

@SpringBootApplication(exclude= SecurityAutoConfiguration.class)
public class TpSpringMvnCmdApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(TpSpringMvnCmdApplication.class, args);
		
		ClientRepository clientRepo = ctx.getBean(ClientRepository.class);
		
		/*
		 * Penser à décommenter le code ci-dessous pour pouvoir insérer des éléments en BDD
		 * Penser également à modifier le fichier application.properties, la ligne 
		 * 'spring.jpa.hibernate.ddl-auto = update' par 'create' au lieu de 'update' si vous souhaiteriez faire des insertions en one shoot
		 */
		
		clientRepo.save(new Client("DUPONT", "Richard", "2 rue du parc, Rouen", "07890987890", "testB2@gmail.com"));	
		clientRepo.save(new Client("CHAPUIS", "Albert", "9 rue du parc, Lille", "07890987890", "test33B2@gmail.com"));
		clientRepo.save(new Client("DESMOND", "Roger", "7 rue du parc, Amiens", "07898789090", "test32B2@gmail.com"));
	/*	clientRepo.save(new Client("ABDEL", "Karim", "19 rue du parc, Amiens", "07326789090", "test34B2@gmail.com"));
		clientRepo.save(new Client("YOUSSEF", "BEN ABDALLA", "20 rue du parc, Amiens", "07896589090", "test38B2@gmail.com"));
		clientRepo.save(new Client("MOHAMMED", "Yousrif", "42 rue du parc, Sense", "07896589090", "test38B2@gmail.com"));*/
		
	}

}
