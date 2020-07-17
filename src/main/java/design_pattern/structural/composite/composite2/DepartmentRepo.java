package design_pattern.structural.composite.composite2;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 数据类
 *
 * @author chenyuqun
 */
public class DepartmentRepo {
    /**
     * 部门的id
     */
    private long id;

    /**
     * 子部门或者员工
     */
    private List<DepartmentRepo> subDepartment = Lists.newArrayList();


    public DepartmentRepo(long id, List<DepartmentRepo> subDepartment) {
        this.id = id;
        this.subDepartment = subDepartment;
    }

    public DepartmentRepo(long id) {
        this.id = id;
    }

    public List<Long> getSubDepartmentIds(long id) {
        List<Long> re = getSubDepartmentIds(id, this);
        if(re == null) {
            re = Lists.newArrayList();
        }
        return re;
    }

    public List<Long> getSubDepartmentIds(long id, DepartmentRepo departmentRepo) {
        if(departmentRepo.getId() == id) {
            return departmentRepo.getSubDepartment().stream().map(ele -> ele.getId()).collect(Collectors.toList());
        }

        List<Long> re = null;
        for(DepartmentRepo departmentRepo1 : departmentRepo.getSubDepartment()) {
            re = getSubDepartmentIds(id, departmentRepo1);
            if(re == null) {
                continue;
            }
        }
        return re;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<DepartmentRepo> getSubDepartment() {
        return subDepartment;
    }

    public void setSubDepartment(List<DepartmentRepo> subDepartment) {
        this.subDepartment = subDepartment;
    }
}
