package net.media.training.designpattern.adapter;

import net.media.training.designpattern.adapter.thirdparty.ThirdPartyLeaveRecord;

import java.util.Arrays;
import java.util.List;

public class ThirdPartyLeaveRecordAdapter implements LeaveRecord{

    private final ThirdPartyLeaveRecord thirdPartyLeaveRecord;

    public ThirdPartyLeaveRecordAdapter(ThirdPartyLeaveRecord thirdPartyLeaveRecord) {
        this.thirdPartyLeaveRecord = thirdPartyLeaveRecord;
    }

    public String getMostAbsentEmployee() {
        List<String> employeeName = Arrays.asList(thirdPartyLeaveRecord.getMostAbsentEmployee().getName().split(", "));
        return employeeName.get(1) + " "  + employeeName.get(0);
    }

    public int getEmployeeAbsences(String employeeName) {
        List<String> employeeNameList = Arrays.asList(employeeName.split(" "));
        StringBuilder thirdPartyEmployeeName = new StringBuilder(employeeNameList.get(employeeNameList.size() - 1) + ",");
        for (int i = 0; i < employeeNameList.size() -1; i++){
            thirdPartyEmployeeName.append(" " + employeeNameList.get(i));
        }
        return thirdPartyLeaveRecord.getEmployeeAbsences(new Employee(thirdPartyEmployeeName.toString()));
    }
}
