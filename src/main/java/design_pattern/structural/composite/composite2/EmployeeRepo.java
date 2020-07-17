package design_pattern.structural.composite.composite2;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * 数据类:存所有雇员的信息
 * @author chenyuqun
 */
public class EmployeeRepo {

    /**
     * 所有部门的id
     * key: 部门的id
     * key: 雇员的id
     */
    Map<Long, List<Long>> departmentEmployeeIds;

    /**
     * 所有雇员的id
     * key: 雇员的id
     * value: 雇员的薪资
     */
    Map<Long, Double> salaries;

    public EmployeeRepo(Map<Long, List<Long>> departmentEmployeeIds, Map<Long, Double> salaries) {
        this.departmentEmployeeIds = departmentEmployeeIds;
        this.salaries = salaries;
    }

    public List<Long> getDepartmentEmployeeIds(long id) {
        return departmentEmployeeIds.getOrDefault(id, Lists.newArrayList());
    }

    public double getEmployeeSalary(Long employeeId) {
        return salaries.get(employeeId);
    }
}
