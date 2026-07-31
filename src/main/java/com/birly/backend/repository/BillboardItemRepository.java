package com.birly.backend.repository;

import com.birly.backend.HousingAssociation;
import com.birly.backend.entity.BillboardItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BillboardItemRepository extends JpaRepository<BillboardItemEntity, UUID> {
    List<BillboardItemEntity> findByHousingAssociation(HousingAssociation housingAssociation);

    boolean existsByTitle(String title);
}
