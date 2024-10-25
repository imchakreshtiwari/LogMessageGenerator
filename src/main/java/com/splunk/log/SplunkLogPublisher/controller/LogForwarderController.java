package com.splunk.log.SplunkLogPublisher.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogForwarderController {

    private static final Logger logger = LoggerFactory.getLogger(LogForwarderController.class);

    @GetMapping("/info")
    public String getInfo() {
        logger.info("INFO: Fetching alerting health-rule information.");
        return "Health Rule information fetched successfully.";
    }

    @GetMapping("/warning")
    public String getWarning() {

        logger.warn("WARNING: Testing Random value logic.");
        int randomValue = (int) (Math.random() * 100);
        if (randomValue < 30) {
            logger.warn("WARNING: Random value is low: {}", randomValue);
        }
        return "Random logic executed, check logs for warnings.";
    }

    @GetMapping("/error")
    public String getError() {
        try {
            throw new RuntimeException("Simulated error occurred!");
        } catch (RuntimeException e) {
            logger.error("ERROR: An error occurred while fetching Health rules: {}", e.getMessage());
            return "An error occurred, check logs for details.";
        }
    }

}
