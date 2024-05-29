package com.barmont.crudapi.repository;

import com.barmont.crudapi.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<UserModel, Long> {



}
