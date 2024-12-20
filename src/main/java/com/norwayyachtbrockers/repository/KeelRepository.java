package com.norwayyachtbrockers.repository;

import com.norwayyachtbrockers.model.Keel;
import com.norwayyachtbrockers.repository.projections.KeelProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeelRepository extends JpaRepository<Keel, Long> {

    @Query("SELECT k.id FROM Keel k WHERE k.name = :name")
    Long findIdByName(@Param("name") String name);

    @Query("""
            SELECT new com.norwayyachtbrockers.repository.projections.KeelProjection(
            k.id,
            k.name,
            k.createdAt,
            k.updatedAt
            )
            FROM Keel k
            ORDER BY k.id ASC
            """)
    List<KeelProjection> findAllProjections();
}
