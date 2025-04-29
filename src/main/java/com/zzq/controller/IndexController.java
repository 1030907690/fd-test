package com.zzq.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: zzq
 * @date: 4/29/2025 9:50 PM
 */
@RestController
@RequestMapping("/api/index")
public class IndexController {
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);
    private final ExecutorService executorService = Executors.newFixedThreadPool(2000);

    @RequestMapping("/fd")
    public String fd(Integer num) {
        String pathSuffix = "/home/zzq/software/";
        String namePrefix = pathSuffix + "test.txt";
        log.info("thread {}",Thread.currentThread().getName());
        for (int i = 0; i < num; i++) {
            try {
                FileInputStream fileInputStream = new FileInputStream(namePrefix);

                /*
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
*/

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("done");
        return "fd";
    }
}
