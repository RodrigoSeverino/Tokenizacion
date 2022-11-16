package com.Tokenizacion.Listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

@Component
public class JobListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobListener.class);


    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("Job Finalizado el status es :" + jobExecution.getStatus());
    }
}
