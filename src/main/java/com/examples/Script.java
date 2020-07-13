package com.examples;

import java.util.List;

import org.jbpm.demo.itorders.ApproverInfo;
import org.kie.api.runtime.process.ProcessContext;

public class Script {
    public static void ruleOnExit(ProcessContext kcontext) {
        List<ApproverInfo> aplist = (List<ApproverInfo>) kcontext.getVariable("caseFile_approvalList");
        kcontext.setVariable("caseFile_approvalCount", aplist.size());

        StringBuffer approvers = new StringBuffer();

        int count = 0; 
        for (ApproverInfo approverInfo : aplist) {
            if (count++>0)
                approvers.append(",");
            approvers.append(approverInfo.getName());
        }
        
        System.out.println("approvers:" + approvers);
    }
}