package com.zpy.township.basic;

import com.zpy.township.constants.CropStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class Crop {

    private int id;

    private String cropName;//名称

    private long growthPeriod;//生长周期

    private long costPrice;//成本价

    private long sellingPrice;//销售价

    private Date growTime;//种植时间

    private Date ripeTime;//成熟时间

    private CropStatus status;

    public Crop() {

    }

    public Crop(String cropName, long growthPeriod, long costPrice, long sellingPrice) {
        this.cropName = cropName;
        this.growthPeriod = growthPeriod;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.status = CropStatus.growing;
        this.growTime = new Date();
        this.ripeTime = new Date(this.growTime.getTime() + this.growthPeriod * 60 * 1000);
    }
}
