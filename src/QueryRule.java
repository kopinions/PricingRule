import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class QueryRule {
    private HashMap<String, String> rule;

    public QueryRule(HashMap<String, String> rule) {
        this.rule = rule;
    }

    public int match(HashMap<String, String> queryCriteir) {
        List<String> ruleHeaders = rule.entrySet().stream().map(e -> e.getKey()).collect(Collectors.toList());
        Set<Boolean> matchStatus = ruleHeaders.stream().map(key ->
                rule.getOrDefault(key, "VALUE").equals(queryCriteir.getOrDefault(key, "QUERY"))).collect(Collectors.toSet());
        if (matchStatus.size() == 1) {
            if (matchStatus.contains(false)) {
                return -1;
            }
            return 1;
        } else {
            return 0;
        }
    }

}
