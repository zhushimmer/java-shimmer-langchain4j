package com.shimmer.ai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shimmer.ai.entity.Appointment;

public interface AppointmentService extends IService<Appointment> {
    Appointment getOne(Appointment appointment);
}