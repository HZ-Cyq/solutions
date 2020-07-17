package design_pattern.structural.adapter.application_scenarios.unify.prime;

import design_pattern.structural.adapter.application_scenarios.unify.ASensitiveWordsFilter;
import design_pattern.structural.adapter.application_scenarios.unify.BSensitiveWordsFilter;
import design_pattern.structural.adapter.application_scenarios.unify.CSensitiveWordsFilter;

/**
 * 未使用适配器模式之前的代码：代码的可测试性、扩展性不好
 * @author chenyuqun
 */
public class RiskManagement {
    private ASensitiveWordsFilter aFilter = new ASensitiveWordsFilter();
    private BSensitiveWordsFilter bFilter = new BSensitiveWordsFilter();
    private CSensitiveWordsFilter cFilter = new CSensitiveWordsFilter();

    public String filterSensitiveWords(String text) {
        String maskedText = aFilter.filterSexyWords(text);
        maskedText = aFilter.filterPoliticalWords(text);
        maskedText = bFilter.filter(maskedText);
        maskedText = cFilter.filter(maskedText, "***");
        return maskedText;
    }

}
