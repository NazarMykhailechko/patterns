package soccer.org.model;

import javax.persistence.*;

@Entity
@Table(name = "data_base")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "tournament_id",referencedColumnName = "id")
    private Tournament tournament;

    private String season;
    private String tur;
    private String dates;
    private String teamhome;
    private String teamaway;
    private int scorehome;
    private int scoreaway;

    public Result() {
    }

    public Result(Tournament tournament, String season, String tur,
                  String dates, String teamhome, String teamaway,
                  int scorehome, int scoreaway) {
        this.tournament = tournament;
        this.season = season;
        this.tur = tur;
        this.dates = dates;
        this.teamhome = teamhome;
        this.teamaway = teamaway;
        this.scorehome = scorehome;
        this.scoreaway = scoreaway;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getTeamhome() {
        return teamhome;
    }

    public void setTeamhome(String teamhome) {
        this.teamhome = teamhome;
    }

    public String getTeamaway() {
        return teamaway;
    }

    public void setTeamaway(String teamaway) {
        this.teamaway = teamaway;
    }

    public int getScorehome() {
        return scorehome;
    }

    public void setScorehome(int scorehome) {
        this.scorehome = scorehome;
    }

    public int getScoreaway() {
        return scoreaway;
    }

    public void setScoreaway(int scoreaway) {
        this.scoreaway = scoreaway;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;

        Result result = (Result) o;

        if (getId() != result.getId()) return false;
        if (getScorehome() != result.getScorehome()) return false;
        if (getScoreaway() != result.getScoreaway()) return false;
        if (getTournament() != null ? !getTournament().equals(result.getTournament()) : result.getTournament() != null)
            return false;
        if (getSeason() != null ? !getSeason().equals(result.getSeason()) : result.getSeason() != null) return false;
        if (getTur() != null ? !getTur().equals(result.getTur()) : result.getTur() != null) return false;
        if (getDates() != null ? !getDates().equals(result.getDates()) : result.getDates() != null) return false;
        if (getTeamhome() != null ? !getTeamhome().equals(result.getTeamhome()) : result.getTeamhome() != null)
            return false;
        return getTeamaway() != null ? getTeamaway().equals(result.getTeamaway()) : result.getTeamaway() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getTournament() != null ? getTournament().hashCode() : 0);
        result = 31 * result + (getSeason() != null ? getSeason().hashCode() : 0);
        result = 31 * result + (getTur() != null ? getTur().hashCode() : 0);
        result = 31 * result + (getDates() != null ? getDates().hashCode() : 0);
        result = 31 * result + (getTeamhome() != null ? getTeamhome().hashCode() : 0);
        result = 31 * result + (getTeamaway() != null ? getTeamaway().hashCode() : 0);
        result = 31 * result + getScorehome();
        result = 31 * result + getScoreaway();
        return result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", tournament=" + tournament +
                ", season='" + season + '\'' +
                ", tur='" + tur + '\'' +
                ", dates='" + dates + '\'' +
                ", teamhome='" + teamhome + '\'' +
                ", teamaway='" + teamaway + '\'' +
                ", scorehome=" + scorehome +
                ", scoreaway=" + scoreaway +
                '}';
    }
}
