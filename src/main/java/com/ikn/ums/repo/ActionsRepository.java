package com.ikn.ums.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikn.ums.entity.ActionItems;
import com.ikn.ums.model.ActionModel;

@Repository
public interface ActionsRepository extends JpaRepository<ActionItems, Integer> {

	
	
	

}
