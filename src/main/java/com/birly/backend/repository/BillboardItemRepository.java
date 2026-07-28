package com.birly.backend.repository;

import com.birly.backend.entity.BillboardItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillboardItemRepository extends JpaRepository<BillboardItemEntity, String> {}
