package com.agung.sensus.dao;

import com.agung.sensus.entity.Pekerjaan;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PekerjaanDao extends PagingAndSortingRepository<Pekerjaan, String> {
}
