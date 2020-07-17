package design_pattern.structural.composite.composite2;

import java.util.List;

/**
 * @author chenyuqun
 */
public class Demon {
    long ORGANIZATION_ROOT_ID;
    DepartmentRepo departmentRepo; // 依赖注入
    EmployeeRepo employeeRepo; // 依赖注入

    public Demon(long ORGANIZATION_ROOT_ID, DepartmentRepo departmentRepo, EmployeeRepo employeeRepo) {
        this.ORGANIZATION_ROOT_ID = ORGANIZATION_ROOT_ID;
        this.departmentRepo = departmentRepo;
        this.employeeRepo = employeeRepo;
    }

    public Department buildOrganization() {
        Department rootDepartment = new Department(ORGANIZATION_ROOT_ID);
        buildOrganization(rootDepartment);
        return rootDepartment;
    }

    // 创建一个组织
    private void buildOrganization(Department department) {
        List<Long> subDepartmentIds = departmentRepo.getSubDepartmentIds(department.getId());
        // 创建组织
        for (Long subDepartmentId : subDepartmentIds) {
            Department subDepartment = new Department(subDepartmentId);
            department.addSubNode(subDepartment);
            buildOrganization(subDepartment);
        }
        // 创建雇员
        List<Long> employeeIds = employeeRepo.getDepartmentEmployeeIds(department.getId());
        for (Long employeeId : employeeIds) {
            double salary = employeeRepo.getEmployeeSalary(employeeId);
            department.addSubNode(new Employee(employeeId, salary));
        }
    }
}
