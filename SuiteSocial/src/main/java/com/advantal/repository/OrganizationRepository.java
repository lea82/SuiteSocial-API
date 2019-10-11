package com.advantal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.advantal.model.Organization;


public interface OrganizationRepository extends JpaRepository<Organization, Long> {
	
	Organization findByOrganizationName(String organizationName);
	
    @Query(value = "SELECT * from organization o where o.organzation_email=?1", nativeQuery = true)
	Organization findByEmailId(String organizationEmail);
    
    @Query(value = "SELECT * from organization o where o.organzation_email=?1, o.organzation_pwd=?2", nativeQuery = true)
	Organization findByEmailIdAndPassword(String organizationEmail, String organizationpwd);

	Organization findByOrganzationId(Long organzationId);
    
	
    
}
