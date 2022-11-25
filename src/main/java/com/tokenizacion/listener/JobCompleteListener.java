package com.tokenizacion.listener;

import com.tokenizacion.dto.TokenDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompleteListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompleteListener.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobCompleteListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINALIZADO! VERIFICA RESULTADOS");
            jdbcTemplate.query("SELECT tokenId, status, created_date FROM DA_Tokens",
                    (rs, row) -> new TokenDTO(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getDate(3).toLocalDate()
                    )
            ).forEach(token -> log.info("Se encontro  <" + token + "> en la base de datos."));
        }
    }
}