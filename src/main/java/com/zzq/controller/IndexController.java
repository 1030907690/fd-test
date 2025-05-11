package com.zzq.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
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
    private final Logger log = LoggerFactory.getLogger(IndexController.class);
    private final ExecutorService executorService = Executors.newFixedThreadPool(2000);

    @RequestMapping("/fd")
    public String fd(Integer num) {
        /**
         * StringWriter 不需要关流
         * 硬盘文件  需要关流
         */
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

        PrintWriter printWriter1 = null;
        try {
            printWriter1 = new PrintWriter(namePrefix);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            printWriter1.close();
        }
        StringWriter sw = new StringWriter();
        PrintWriter printWriter = new PrintWriter(sw, true);
        try {
            int a = 1 / 0;
        } catch (Exception e) {
            log.error("异常");
            e.printStackTrace(printWriter);
        }

        try {
            sw.close();
            printWriter.close();
        } catch (IOException ioException) {
            log.error("异常日志：关闭异常详情Writer异常");
        }
        // 异常的详情
        String expDetail = sw.toString();


        log.info("expDetail {} ", expDetail);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "fd";
    }
}
