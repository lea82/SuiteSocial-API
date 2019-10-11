package com.advantal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.advantal.model.Influencer;

public interface InfluencerRepository extends JpaRepository<Influencer, Long> {

	@Query(value = "SELECT * from influencer o where o.email=?1", nativeQuery = true)
	Influencer findByEmailId(String email);

	Influencer findByEmail(String iName);

	Influencer findByInfluencerId(Long influencerId);

}
