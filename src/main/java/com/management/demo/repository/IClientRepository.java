package com.management.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.demo.entities.Client;


public interface IClientRepository extends JpaRepository<Client, Long>{

}
