package com.zpy.township.basic;

import com.zpy.township.constants.CropStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Land {

    private Crop crop;

    public void grow(Crop crop) {
        if (this.crop == null) {
            this.setCrop(crop);
        } else {
            System.err.println("已种植作物");
        }
    }

    public Crop harvest() {
        Crop crop = null;
        if (this.crop != null) {
            if (CropStatus.ripe.equals(this.crop.getStatus())) {
                this.crop.setStatus(CropStatus.harvested);
                crop = this.crop;
                this.crop = null;
            } else {
                System.err.println("[" + this.crop.getCropName() + "]尚未成熟");
            }
        } else {
            System.err.println("尚未种植作物");
        }
        return crop;
    }
}
