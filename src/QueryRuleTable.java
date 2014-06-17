import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 6/17/14
 * Time: 4:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class QueryRuleTable {
    private Map<QueryRule, Integer> queryRule;
    private int defaultValue =0;

    public QueryRuleTable(Map<QueryRule, Integer> queryRule) {

        this.queryRule = queryRule;
    }



    public int getPrice(HashMap<String, String> rule) {
        List<Map.Entry<QueryRule, Integer>> collect = queryRule.entrySet().stream().filter(r -> r.getKey().match(rule) == 0 || r.getKey().match(rule) == 1).collect(Collectors.toList());
        if (collect.size() == 1) {
            return collect.get(0).getValue();
        }
        if (collect.size() == 0) {
            return 0;
        }
        return collect.stream().max((c1, c2) -> c1.getValue() - c2.getValue()).get().getValue();
    }

    public int getDefaultValue() {
        return defaultValue;
    }
}
