package cn.dm.controller;

import cn.dm.common.DateUtil;
import cn.dm.pojo.DmScheduler;
import cn.dm.service.TempSchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;


@Controller
@RequestMapping("/api/scheduler")
public class DmSchedulerController {

    @Autowired
    private TempSchedulerService tempSchedulerService;

    @RequestMapping("/add")
    public void addScheduler() throws Exception {
        Random rand = new Random();
        for (int i=1;i<=1421;i++){
            int count=rand.nextInt(4)+1;
            for(int j=1;j<=count;j++){
                DmScheduler dmScheduler=new DmScheduler();
                dmScheduler.setItemId(new Long(i));
                dmScheduler.setCreatedTime(new Date());
                Calendar calendar   =   new GregorianCalendar();
                calendar.setTime(new Date());
                calendar.add(calendar.DATE,rand.nextInt(180));
                dmScheduler.setStartTime(calendar.getTime());
                calendar.add(calendar.HOUR,3);
                dmScheduler.setEndTime(calendar.getTime());
                dmScheduler.setTitle(DateUtil.format(dmScheduler.getStartTime(),"yyyy.mm.dd-HH")+"-"+DateUtil.format(dmScheduler.getEndTime(),"yyyy.mm.dd-HH"));
                tempSchedulerService.addScheduler(dmScheduler);
            }
        }
    }
}
