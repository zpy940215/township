package com.zpy.township.controller;

import com.zpy.township.basic.Crop;
import com.zpy.township.mapper.CropMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/crop")
public class CropConrtroller {

    @Autowired
    private CropMapper cropMapper;

    @GetMapping("list")
    public List<Crop> list() {
        return cropMapper.listAll();
    }
}
