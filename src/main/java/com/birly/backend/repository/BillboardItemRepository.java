package com.birly.backend.repository;

import com.birly.backend.HousingAssociation;
import com.birly.backend.entity.BillboardItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillboardItemRepository extends JpaRepository<BillboardItemEntity, String> {
    List<BillboardItemEntity> findByHousingAssociation(HousingAssociation housingAssociation);
}
