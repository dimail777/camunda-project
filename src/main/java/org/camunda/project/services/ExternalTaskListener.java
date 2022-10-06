package org.camunda.project.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ExternalTaskListener implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        boolean has = delegateExecution.hasVariable("message");
        if (!has) {
            System.out.println("Ext. task active!");
        } else {
            System.out.println("Ext. task active again, wait 20 sec!");
        }
    }

}
