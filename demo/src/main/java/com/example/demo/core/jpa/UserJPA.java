package com.example.demo.core.jpa;

import com.example.demo.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;


/**
 * Created by Administrator on 2018/3/19.
 */
public interface UserJPA extends
		JpaRepository<User,Long>, JpaSpecificationExecutor<User>,Serializable
{
}
