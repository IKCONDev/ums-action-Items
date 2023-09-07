package com.ikn.ums.actionitem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ikn.ums.actionitem.entity.ActionItems;

@Repository
public interface ActionsRepository extends JpaRepository<ActionItems, Integer> {
	
	@Query("FROM ActionItems WHERE eventid=:eventId")
	public List<ActionItems> findActionItemsByEventId(Integer eventId);

}
