package com.unip.tcc2k22.repositories;

import com.unip.tcc2k22.models.DataSpring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Repository
@Transactional
public interface Repository extends JpaRepository<DataSpring,Long > {
}
