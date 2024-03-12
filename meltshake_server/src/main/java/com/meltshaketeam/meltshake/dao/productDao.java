package com.meltshaketeam.meltshake.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meltshaketeam.meltshake.bean.*;
import com.meltshaketeam.meltshake.entity.productEntity;

@Repository
public interface productDao extends JpaRepository<productEntity, Integer> {
	productEntity findByProductcode(String productcode);
}