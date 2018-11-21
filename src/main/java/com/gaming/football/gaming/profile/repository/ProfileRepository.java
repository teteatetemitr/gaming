package com.gaming.football.gaming.profile.repository;




import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gaming.football.gaming.profile.beans.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile,Integer> {
	
	@Query("select usr from Profile usr where usr.idProfile = :userId")
	Profile findByUserId(@Param("userId")int userId);

	
}
