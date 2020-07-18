/**
 * 
 */
package com.evolvus.sms.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.evolvus.sms.model.TaSms;

/**
 * @author EVOLVUS\nagendrappae
 *
 */
@Transactional
@Repository

public interface SMSCrudRepository  extends CrudRepository<TaSms, Long>{

}
