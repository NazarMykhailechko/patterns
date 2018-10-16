package json;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({@NamedQuery(name="GetRateMoreThan19",query = "SELECT c FROM CurrencyRate AS c WHERE c.rate >19.5"),
               @NamedQuery(name="GetRateMoreThan20000",query = "SELECT c FROM CurrencyRate AS c WHERE c.rate >20000.0")})
@Entity
public class CurrencyRate extends GeneralID {

      @Column
      private int r030;
      @Column
      private String txt;
      @Column
      private double rate;
      @Column
      private String exchangedate;

    public CurrencyRate() {
    }

    public CurrencyRate(int r030, String txt, double rate, String exchangedate) {
        this.r030 = r030;
        this.txt = txt;
        this.rate = rate;
        this.exchangedate = exchangedate;
    }

    public int getR030() {
        return r030;
    }

    public void setR030(int r030) {
        this.r030 = r030;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getExchangedate() {
        return exchangedate;
    }

    public void setExchangedate(String exchangedate) {
        this.exchangedate = exchangedate;
    }

    @Override
    public String toString() {
        return "CurrencyRate{" +
                "r030=" + r030 +
                ", txt='" + txt + '\'' +
                ", rate=" + rate +
                ", exchangedate='" + exchangedate + '\'' +
                '}';
    }
}
