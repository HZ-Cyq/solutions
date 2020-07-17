package design_pattern.structural.adapter.application_scenarios.unify.adapter;

import design_pattern.structural.adapter.application_scenarios.unify.ASensitiveWordsFilter;

/**
 * @author chenyuqun
 */
public class ASensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {
    private ASensitiveWordsFilter aFilter = new ASensitiveWordsFilter();

    @Override
    public String filter(String text) {
        String maskedText = aFilter.filterSexyWords(text);
        maskedText = aFilter.filterPoliticalWords(text);
        return maskedText;
    }
}
