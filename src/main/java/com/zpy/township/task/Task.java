package com.zpy.township.task;

import com.zpy.township.basic.Crop;
import com.zpy.township.constants.CropStatus;
import com.zpy.township.mapper.CropMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Component
@EnableScheduling
public class Task {

    private static Logger log = LoggerFactory.getLogger(Task.class);

    @Autowired
    private CropMapper cropMapper;

    @Scheduled(cron = "0 0/1 * * * ?")
    //@Scheduled(fixedRate=5000)
    private void checkGrowingCrops() {
        System.err.println("检查农作物是否成熟: " + LocalDateTime.now());
        Date date = new Date();
        List<Crop> crops = cropMapper.listByStatus(CropStatus.growing);
        for(Crop crop:crops) {
            if(date.before(crop.getRipeTime())) {
                crop.setStatus(CropStatus.ripe);
                cropMapper.update(crop);
            }
        }
        System.err.println("农作物是否成熟检查完毕: " + LocalDateTime.now());
    }

}
