import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class QueryRuleTest {
    @Test
    public void should_return_1_exact_match() {
        HashMap<String, String> stringStringHashMap = new HashMap<String, String>();
        stringStringHashMap.put("Position", "Beijin");
        stringStringHashMap.put("Name", "dongcheng");
        HashMap<String, String> queryCriteir = new HashMap<String, String>();
        queryCriteir.put("Position", "Beijin");
        queryCriteir.put("Name", "dongcheng");

        int match = new QueryRule(stringStringHashMap).match(queryCriteir);
        assertEquals(match, 1);
    }

    @Test
    public void should_return_negative_when_no_match() {
        HashMap<String, String> stringStringHashMap = new HashMap<String, String>();
        stringStringHashMap.put("Position", "Beijin");
        stringStringHashMap.put("Name", "dongcheng");
        HashMap<String, String> queryCriteir = new HashMap<String, String>();
        queryCriteir.put("Position", "Not Exist Position");
        queryCriteir.put("Name", "Not Exist Name");

        int match = new QueryRule(stringStringHashMap).match(queryCriteir);
        assertEquals(-1, match);
    }

    @Test
    public void should_return_zero_when_fuzzy_match() {
        HashMap<String, String> stringStringHashMap = new HashMap<String, String>();
        stringStringHashMap.put("Position", "Beijin");
        stringStringHashMap.put("Name", "dongcheng");
        HashMap<String, String> queryCriteir = new HashMap<String, String>();
        queryCriteir.put("Position", "Beijin");
        queryCriteir.put("Name", "Not Exist Name");

        int match = new QueryRule(stringStringHashMap).match(queryCriteir);
        assertEquals(match, 0);
    }
}
