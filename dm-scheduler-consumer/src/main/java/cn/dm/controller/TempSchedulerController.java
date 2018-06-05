package cn.dm.controller;

import cn.dm.service.TempSchedulerService;
import org.bouncycastle.cms.PasswordRecipientId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/index")
public class TempSchedulerController {
    @Autowired
    private TempSchedulerService tempSchedulerService;

    @GetMapping("/generateScheduleSeatData")
    public void generateScheduleSeatData() throws Exception {
        tempSchedulerService.generateScheduleSeatData();
    }
}
