/**
 * 
 */
package com.evolvus.smsEmailWeb.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.evolvus.smsEmailWeb.model.TaEmail;


/**
 * @author EVOLVUS\manishp
 *
 */
@Transactional
@Repository
public interface EmailCrudRepository  extends CrudRepository<TaEmail, Long>{

	
	List<TaEmail> findByEmailId(int emailId);
}
