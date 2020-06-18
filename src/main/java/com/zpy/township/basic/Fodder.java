package com.zpy.township.basic;

import com.zpy.township.constants.FodderStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

//饲料
@Setter
@Getter
@ToString
public class Fodder {

    private String name;//名称

    private long sellingPrice;//销售价

    private long processTime;//加工时长

    private FodderStatus status;//状态

    private Date startTime;//加工时间

    private Date endTime;//完成时间

    public Fodder() {

    }

    public Fodder(String name, long sellingPrice, long processTime) {
        this.name = name;
        this.sellingPrice = sellingPrice;
        this.processTime = processTime;
        this.status = FodderStatus.processing;
        this.startTime = new Date();
    }
}
