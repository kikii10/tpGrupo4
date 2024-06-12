package com.unla.tpGrupo4.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.tpGrupo4.entities.Stock;

@Repository("stockRepository")
public interface IStockRepository extends JpaRepository<Stock,Serializable > {

}
