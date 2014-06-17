import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 6/17/14
 * Time: 4:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class QueryRule {
    private HashMap<String, String> rule;

    public QueryRule(HashMap<String, String> rule) {
        this.rule = rule;
    }

    public int match(HashMap<String, String> queryCriteir) {
        List<String> keyset = rule.entrySet().stream().map(e -> e.getKey()).collect(Collectors.toList());
        Set<Boolean> collect1 = keyset.stream().map(key ->
               rule.getOrDefault(key, "VALUE").equals(queryCriteir.getOrDefault(key, "QUERY"))).collect(Collectors.toSet());
        if (collect1.size() == 1) {
            if (collect1.contains(false)) {
                return -1;
            }
            return 1;
        } else{
            return 0;
        }
    }

}
