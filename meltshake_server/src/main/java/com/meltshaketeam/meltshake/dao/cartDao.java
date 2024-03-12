package com.meltshaketeam.meltshake.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meltshaketeam.meltshake.entity.cartEntity;

public interface cartDao extends JpaRepository<cartEntity, String>{
	cartEntity findByProductcode(String productCode);
	void deleteAll();
}