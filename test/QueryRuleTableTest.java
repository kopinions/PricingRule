import org.junit.Test;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;

public class QueryRuleTableTest {

    @Test
    public void should_return_price_of_exact_macth() {
        HashMap<String, String> product1 = new HashMap<String, String>();
        product1.put("Position", "Beijin");
        product1.put("Name", "dongcheng");
        HashMap<String, String> product2 = new HashMap<String, String>();
        product2.put("Position", "Chengdu");
        product2.put("Name", "dongdong");
        HashMap<QueryRule, Integer> queryRuleIntegerHashMap = new HashMap<>();
        queryRuleIntegerHashMap.put(new QueryRule(product1), 1);
        queryRuleIntegerHashMap.put(new QueryRule(product2), 3);
        QueryRuleTable queryRuleTable = new QueryRuleTable(queryRuleIntegerHashMap);

        HashMap<String, String> queryCriteir = new HashMap<String, String>();
        queryCriteir.put("Position", "Beijin");
        queryCriteir.put("Name", "dongcheng");
        assertEquals(1, queryRuleTable.getPrice(queryCriteir));
    }


    @Test
    public void should_return_price_fuzzy_match() {
        HashMap<String, String> product1 = new HashMap<String, String>();
        product1.put("Position", "Beijin");
        product1.put("Name", "dongdong");
        HashMap<String, String> product2 = new HashMap<String, String>();
        product2.put("Position", "Chengdu");
        product2.put("Name", "dongdong");
        HashMap<QueryRule, Integer> queryRuleIntegerHashMap = new HashMap<>();
        queryRuleIntegerHashMap.put(new QueryRule(product1), 2);
        queryRuleIntegerHashMap.put(new QueryRule(product2), 3);
        QueryRuleTable queryRuleTable = new QueryRuleTable(queryRuleIntegerHashMap);

        HashMap<String, String> queryCriteir = new HashMap<String, String>();
        queryCriteir.put("Position", "Beijin");
        queryCriteir.put("Name", "dongcheng");
        assertEquals(2, queryRuleTable.getPrice(queryCriteir));
    }

    @Test
    public void should_default_when_no_match() {
        HashMap<String, String> product1 = new HashMap<String, String>();
        product1.put("Position", "Beijin");
        product1.put("Name", "dongdong");
        HashMap<String, String> product2 = new HashMap<String, String>();
        product2.put("Position", "Chengdu");
        product2.put("Name", "dongdong");
        HashMap<QueryRule, Integer> queryRuleIntegerHashMap = new HashMap<>();
        queryRuleIntegerHashMap.put(new QueryRule(product1), 2);
        queryRuleIntegerHashMap.put(new QueryRule(product2), 3);
        QueryRuleTable queryRuleTable = new QueryRuleTable(queryRuleIntegerHashMap);

        HashMap<String, String> queryCriteir = new HashMap<String, String>();
        queryCriteir.put("Position", "Not Exist");
        queryCriteir.put("Name", "Not Exist");
        assertEquals(queryRuleTable.getDefaultValue(), queryRuleTable.getPrice(queryCriteir));
    }

    @Test
    public void should_get_bigest_when_fuzzy_match() {
        HashMap<String, String> product1 = new HashMap<String, String>();
        product1.put("Position", "Beijin");
        product1.put("Name", "dongcheng");
        HashMap<String, String> product2 = new HashMap<String, String>();
        product2.put("Position", "Chengdu");
        product2.put("Name", "dongdong");
        HashMap<QueryRule, Integer> queryRuleIntegerHashMap = new HashMap<>();
        queryRuleIntegerHashMap.put(new QueryRule(product1), 2);
        queryRuleIntegerHashMap.put(new QueryRule(product2), 3);
        QueryRuleTable queryRuleTable = new QueryRuleTable(queryRuleIntegerHashMap);

        HashMap<String, String> queryCriteir = new HashMap<String, String>();
        queryCriteir.put("Position", "Beijin");
        queryCriteir.put("Name", "dongdong");
        assertEquals(3, queryRuleTable.getPrice(queryCriteir));
    }
}