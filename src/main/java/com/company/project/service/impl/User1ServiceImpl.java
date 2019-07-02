package com.company.project.service.impl;

import com.company.project.dao.db1.User1Mapper;
import com.company.project.model.User1;
import com.company.project.service.User1Service;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/07/02.
 */
@Service
@Transactional
public class User1ServiceImpl extends AbstractService<User1> implements User1Service {
    @Resource
    private User1Mapper user1Mapper;

}
