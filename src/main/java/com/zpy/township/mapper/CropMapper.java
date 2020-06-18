package com.zpy.township.mapper;

import com.zpy.township.basic.Crop;
import com.zpy.township.constants.CropStatus;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CropMapper {

    List<Crop> listAll();

    Crop getById(int id);

    void insert(Crop crop);

    void update(Crop crop);

    List<Crop> listByStatus(CropStatus status);
}
