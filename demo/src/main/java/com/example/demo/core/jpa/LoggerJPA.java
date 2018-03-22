package com.example.demo.core.jpa;

import com.example.demo.core.entity.LoggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Administrator on 2018/3/21.
 */
public interface LoggerJPA
	extends JpaRepository<LoggerEntity,Long >
{
}
