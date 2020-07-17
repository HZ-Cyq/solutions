package design_pattern.structural.composite.composite2;

import com.alibaba.fastjson.JSONPObject;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * EmployeeRepo和DepartmentRepo的结构是什么？
 *
 * @author chenyuqun
 */
public class Composite2Test {
    /**
     * 部门结构：以0结尾的id是雇员
     * 1
     * 1/11
     * 1/11/1110
     * 1/11/1120
     * 1/11/1130
     * 1/11/1140
     * 1/12
     * 1/12/1210
     * 1/12/1220
     * 1/12/1230
     * 1/13
     * 1/13/1310
     * 1/13/1320
     */
    DepartmentRepo departmentRepo;
    EmployeeRepo employeeRepo;

    public void buildRepo() {
        Map<Long, List<Long>> departmentEmployeeIds = Maps.newHashMap();
        Map<Long, Double> salaries = Maps.newHashMap();

        departmentEmployeeIds.put(11L, Arrays.asList(1110L, 1120L, 1130L, 1140L));
        departmentEmployeeIds.put(12L, Arrays.asList(1210L, 1220L, 1230L));
        departmentEmployeeIds.put(13L, Arrays.asList(1310L, 1320L));

        salaries.put(1110L, 1.0);
        salaries.put(1120L, 2.0);
        salaries.put(1130L, 3.0);
        salaries.put(1140L, 4.0);
        salaries.put(1210L, 1.0);
        salaries.put(1220L, 2.0);
        salaries.put(1230L, 3.0);
        salaries.put(1310L, 1.0);
        salaries.put(1320L, 2.0);

        this.employeeRepo = new EmployeeRepo(departmentEmployeeIds, salaries);

        Map<Long, List<Long>> subDepartmentIds = Maps.newHashMap();
        subDepartmentIds.put(1L, Arrays.asList(11L, 12L, 13L));
        DepartmentRepo departmentRepo11 = new DepartmentRepo(11L);
        DepartmentRepo departmentRepo12 = new DepartmentRepo(12L);
        DepartmentRepo departmentRepo13 = new DepartmentRepo(13L);
        this.departmentRepo = new DepartmentRepo(1L, Arrays.asList(departmentRepo11, departmentRepo12, departmentRepo13));
    }

    @Test
    public void testComposite() {
        buildRepo();
        Demon demon = new Demon(1L, departmentRepo, employeeRepo);
        Department department = demon.buildOrganization();
        System.out.print(department.calculateSalary());
    }
}
