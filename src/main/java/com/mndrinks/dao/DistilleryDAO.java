package com.mndrinks.dao;

import com.mndrinks.entities.Distillery;

import java.util.List;

public interface DistilleryDAO {

    void insert(Distillery distillery);

    void insertBatch(List<Distillery> distilleries);

    List<Distillery> findAllDistilleries();

    Distillery findDistilleryById(long id);
}
