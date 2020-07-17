package design_pattern.structural.adapter.application_scenarios.unify.adapter;

import design_pattern.structural.adapter.application_scenarios.unify.BSensitiveWordsFilter;

/**
 * @author chenyuqun
 */
public class BSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter{
    private BSensitiveWordsFilter bFilter = new BSensitiveWordsFilter();
    @Override
    public String filter(String text) {
        return bFilter.filter(text);
    }
}
