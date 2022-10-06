package org.camunda.project.usecases;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class StartProcess {

    @Autowired
    private RuntimeService runtimeService;

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    @EventListener
    private void processPostDeploy(ApplicationReadyEvent event) {
        var process = runtimeService.startProcessInstanceByKey("Process_1xr5vad", "123");
        System.out.println(
                "key = " + process.getBusinessKey() +
                        ", definition = " + process.getProcessDefinitionId() +
                        ", id = " + process.getId()
        );

        executorService.submit(() -> {
            try {
                Thread.sleep(10000);

                runtimeService.createMessageCorrelation("Message_26h8ckm")
                        .processInstanceBusinessKey("123")
                        .setVariable("message", "Hello! How are you?")
                        .correlate();

            } catch (Exception e) {
                System.out.println("message error - " + e.getMessage());
            }
        });

    }

}
