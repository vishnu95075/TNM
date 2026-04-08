package com.tns.user.service;

import com.tns.user.entity.Dummy;

import java.util.List;

public interface IDummyService {
    Dummy createDummy(Dummy dummy);
    Dummy getDummy(Integer id);
    List<Dummy> getAllDummy();

}
