package design_pattern.structural.composite.composite2;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author chenyuqun
 */
public class Department extends HumanResource{
    private List<HumanResource> subNodes = Lists.newArrayList();
    public Department(long id) {
        super(id);
    }

    public void addSubNode(HumanResource humanResource) {
        subNodes.add(humanResource);
    }

    @Override
    public double calculateSalary() {
        double totalSalary = 0.0;
        for(HumanResource humanResource : subNodes) {
            totalSalary += humanResource.calculateSalary();
        }
        return totalSalary;
    }

    public List<HumanResource> getSubNodes() {
        return subNodes;
    }
}
