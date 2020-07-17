package design_pattern.structural.adapter.application_scenarios.unify.adapter;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 统一多个类的接口设计
 * 扩展性更好，更加符合开闭原则
 * 如果添加一个新的敏感词过滤系统，这个类完全不需要改动；
 * 而且基于接口而非实现编程，代码的可测试性更好。
 * @author chenyuqun
 */
public class RiskManagement {
    private List<ISensitiveWordsFilter> filters = Lists.newArrayList();

    public void addSensitiveWordsFilter(ISensitiveWordsFilter filter) {
        filters.add(filter);
    }

    public String filterSensitiveWords(String text) {
        String maskedText = text;
        for(ISensitiveWordsFilter filter: filters) {
            maskedText = filter.filter(maskedText);
        }
        return maskedText;
    }
}
