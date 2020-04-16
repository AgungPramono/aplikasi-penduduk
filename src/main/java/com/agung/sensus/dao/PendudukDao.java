package com.agung.sensus.dao;

import com.agung.sensus.entity.Penduduk;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PendudukDao extends PagingAndSortingRepository<Penduduk, String> {

    List<Penduduk> findByNamaContainingIgnoreCase(String value, Pageable pageable);
}
