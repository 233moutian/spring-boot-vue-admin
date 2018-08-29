package com.zoctan.api.service.impl;

import com.zoctan.api.mapper.BikeMapper;
import com.zoctan.api.model.Bike;
import com.zoctan.api.service.BikeService;
import com.zoctan.api.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author 233moutian
 * @date 2018/08/29
 */
@Service
@Transactional
@SuppressWarnings("SpringJavaAutowiringInspection")
public class BikeServiceImpl extends AbstractService<Bike> implements BikeService {
    @Resource
    private BikeMapper bikeMapper;

}
