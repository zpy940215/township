package com.zpy.township.factory;

import com.zpy.township.basic.Fodder;
import com.zpy.township.constants.CropStatus;
import com.zpy.township.constants.FodderStatus;
import com.zpy.township.crops.Carrot;
import com.zpy.township.crops.Corn;
import com.zpy.township.crops.Wheat;
import com.zpy.township.fodder.ChickenFodder;
import com.zpy.township.fodder.CowFodder;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

//饲料厂
@ToString
@Getter
public class FodderFactory {

    private final int maxPositionNum = 6;//最大栏位

    private int positionNum = 3;//当前栏位

    private final int maxProcessingNum = 6;//最大可加工数量

    private int processingNum = 3;//可加工数量

    private List<Fodder> fodders = new ArrayList<>();//已加工完的饲料

    private final int maxFodderNum = 6;//最大储量

    private List<Fodder> processingFodders = new ArrayList<>();//正加工的饲料

    public void processCowFodder(List<Wheat> wheats, List<Corn> corns) {
        if (this.processingFodders.size() >= this.processingNum) {
            System.err.println("加工列队已满");
        } else {
            if (wheats == null || wheats.isEmpty() || wheats.size() < 2) {
                System.err.println("【小麦】数量不足");
            }
            if (corns == null || corns.isEmpty() || corns.size() < 1) {
                System.err.println("【玉米】数量不足");
            }
            for (int i = 0; i < 2; i++) {
                wheats.get(0).setStatus(CropStatus.consumed);
                wheats.remove(0);
            }
            corns.get(0).setStatus(CropStatus.consumed);
            corns.remove(0);
            this.processingFodders.add(new CowFodder());
        }
    }

    public void processChickenFodder(List<Wheat> wheats, List<Carrot> carrots) {
        if (this.processingFodders.size() >= this.processingNum) {
            System.err.println("加工列队已满");
        } else {
            if (wheats == null || wheats.isEmpty() || wheats.size() < 2) {
                System.err.println("【小麦】数量不足");
            }
            if (carrots == null || carrots.isEmpty() || carrots.size() < 1) {
                System.err.println("【胡萝卜】数量不足");
            }
            for (int i = 0; i < 2; i++) {
                wheats.get(0).setStatus(CropStatus.consumed);
                wheats.remove(0);
            }
            carrots.get(0).setStatus(CropStatus.consumed);
            carrots.remove(0);
            this.processingFodders.add(new ChickenFodder());
        }
    }

    public void storage() {
        if(this.processingFodders.size() > 0) {
            Fodder fodder = this.processingFodders.get(0);
            if(FodderStatus.processed.equals(fodder.getStatus())) {
                if(this.fodders.size() < this.positionNum) {
                    fodder.setStatus(FodderStatus.storaged);
                    this.processingFodders.remove(0);
                    this.fodders.add(fodder);
                } else {
                    System.out.println("存储队列已满");
                }
            } else {
                System.out.println("尚未加工完成");
            }
        }
    }
}
