package json;

import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class TestJUnitJson {

    @Test
    public void getCurrRate() throws IOException {

        List<CurrencyRate> currUtilesList = CurrUtiles.getCurrencies();
        Assert.assertEquals(60,currUtilesList.size());

    }

    @Test
    public void getCurrRateMoreThan50() throws IOException {
        List<CurrencyRate> currUtilesList = CurrUtiles.getCurrencies();
        long count = currUtilesList.stream()
                .filter(r->r.getRate()>19.5)
                .count();

        currUtilesList.stream()
                .filter(r->r.getRate()>19.5).sorted(Comparator.comparing(CurrencyRate::getTxt)).forEach(System.out::println);
        Assert.assertEquals(12,count);
    }
}