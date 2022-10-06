package org.camunda.project.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class MessageServiceTask implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        var message = delegateExecution.getVariable("message");
        System.out.println("Message = " + message);
    }

}
