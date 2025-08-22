package com.shimmer.ai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shimmer.ai.entity.Appointment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppointmentMapper extends BaseMapper<Appointment> {
}