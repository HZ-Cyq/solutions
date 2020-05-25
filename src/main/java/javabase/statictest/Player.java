package javabase.statictest;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author playcrab_chenyuqun
 */
public class Player {
    private List<Activity> activityList = Lists.newArrayList();

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }
}
