package com.zpy.township;

import com.zpy.township.basic.Crop;
import com.zpy.township.basic.Fodder;
import com.zpy.township.basic.Land;
import com.zpy.township.constants.CropStatus;
import com.zpy.township.constants.FodderStatus;
import com.zpy.township.crops.Corn;
import com.zpy.township.crops.Wheat;
import com.zpy.township.factory.FodderFactory;
import com.zpy.township.mapper.CropMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@MapperScan("com.zpy.township.mapper")
@SpringBootTest
class TownshipApplicationTests {

    private static Logger log = LoggerFactory.getLogger(TownshipApplicationTests.class);

    @Autowired
    private CropMapper cropMapper;

    @Test
    public void testCropMapper() {
        Crop crop = new Wheat();
//        cropMapper.insert(crop);
        Crop crop1 = cropMapper.getById(2);
        System.out.println(crop1);
        crop1.setStatus(CropStatus.ripe);
        cropMapper.update(crop1);
    }

    @Test
    public void testLand() {
        Crop wheat = new Wheat();
        System.out.println("before grow: " + wheat.toString());
        wheat.setStatus(CropStatus.ripe);
        Land land = new Land();
        land.grow(wheat);
        System.out.println("land grow: " + land.toString());
        wheat = land.harvest();
        System.out.println("after harvest: " + land.toString() + " wheat: " + wheat.toString());
    }

    public static void main(String[] args) {
        new TownshipApplicationTests().testFodderFactory();
    }

    public void testFodderFactory() {
        List<Wheat> wheats = new ArrayList<>();
        List<Corn> corns = new ArrayList<>();
        Wheat wheat1 = new Wheat();
        Wheat wheat2 = new Wheat();
        Corn corn = new Corn();

        log.info("before grow: " + wheat1);
        log.info("before grow: " + wheat2);
        log.info("before grow: " + corn);

        wheat1.setStatus(CropStatus.ripe);
        wheat2.setStatus(CropStatus.ripe);
        corn.setStatus(CropStatus.ripe);

        wheats.add(wheat1);
        wheats.add(wheat2);
        corns.add(corn);

        log.info("before process: " + wheats);
        log.info("before process: " + corns);

        FodderFactory factory = new FodderFactory();
        log.info("before process: " + factory);

        factory.processCowFodder(wheats, corns);

        log.info("process start: " + factory);
        log.info("process start: " + wheats);
        log.info("process start: " + corns);

        for (Fodder fodder : factory.getProcessingFodders()) {
            fodder.setStatus(FodderStatus.processed);
        }

        log.info("process finish: " + factory);

        factory.storage();

        log.info("after storage: " + factory);
    }
}
