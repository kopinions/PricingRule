import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QueryRuleTable {
    private Map<QueryRule, Integer> queryRule;
    private int defaultValue =1;

    public QueryRuleTable(Map<QueryRule, Integer> queryRule) {
        this.queryRule = queryRule;
    }

    public int getPrice(HashMap<String, String> rule) {
        List<Map.Entry<QueryRule, Integer>> matchQueryRules = queryRule.entrySet().stream().filter(r -> r.getKey().match(rule) == 0 || r.getKey().match(rule) == 1).collect(Collectors.toList());
        if (matchQueryRules.size() == 1) {
            return matchQueryRules.get(0).getValue();
        }
        if (matchQueryRules.size() == 0) {
            return defaultValue;
        }
        Integer maxPrice = matchQueryRules.stream().max((c1, c2) -> c1.getValue() - c2.getValue()).get().getValue();
        return maxPrice;
    }

    public int getDefaultValue() {
        return defaultValue;
    }
}
