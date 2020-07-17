package design_pattern.structural.adapter.application_scenarios.unify.adapter;

import design_pattern.structural.adapter.application_scenarios.unify.CSensitiveWordsFilter;

/**
 * @author chenyuqun
 */
public class CSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {
    private CSensitiveWordsFilter cFilter = new CSensitiveWordsFilter();
    @Override
    public String filter(String text) {
        return cFilter.filter(text,"***");
    }
}
