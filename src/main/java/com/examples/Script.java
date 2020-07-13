package com.examples;

import java.util.List;

import org.jbpm.demo.itorders.ApproverInfo;
import org.kie.api.runtime.process.ProcessContext;

public class Script {

    public static void mgrApprovalOnEntry(ProcessContext kcontext) {
        Integer cnt = (Integer) kcontext.getVariable("count");
        java.util.List aplist = (java.util.List) kcontext.getVariable("caseFile_approvalList");
        if (cnt == null) {
            cnt = new Integer(1);
            kcontext.setVariable("count", cnt);

        } else {
            cnt = cnt + 1;
            kcontext.setVariable("count", cnt);
        }
        System.out.println("count" + cnt);
        if (aplist != null && aplist.size() > 0) {
            System.out.println("size11" + aplist.size());
            System.out.println("count from" + cnt);

            ApproverInfo info = (ApproverInfo) aplist.get(cnt - 1);
            kcontext.setVariable("approver", info.getName());
            System.out.println("user name" + info.getName());

        } else if (aplist == null) {
            System.out.println("size12 is null");
        } else if (aplist != null && aplist.size() == 0) {
            System.out.println("size12 is 0");
        }
    }

    public static void ruleOnExit(ProcessContext kcontext) {
        List<ApproverInfo> aplist =  (List<ApproverInfo>) kcontext.getVariable("caseFile_approvalList");
        kcontext.setVariable("caseFile_approvalCount", aplist.size());
        for (ApproverInfo approverInfo : aplist) {
            kcontext.getCaseAssignment().assignUser("manager", approverInfo.getName());
        }
        kcontext.getCaseAssignment().assignUser("manager", "donato");
    }

}