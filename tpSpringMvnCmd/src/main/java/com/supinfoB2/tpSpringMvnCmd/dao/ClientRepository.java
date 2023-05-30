package com.supinfoB2.tpSpringMvnCmd.dao;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.supinfoB2.tpSpringMvnCmd.entities.*;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	
	public List<Client> findByNom(String n);
	//Chercher les clients par nom page par page(notion de pagination)
	public List<Client> findByNom(String n, Pageable pageable );
	
	@Query("select e from Client e where e.nom like :x")
	public Page<Client> chercherClients(@Param("x") String mc, Pageable pageable);

}
