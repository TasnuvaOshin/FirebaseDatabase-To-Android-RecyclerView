package oshin.tasnuva.cwcreminder;

public class DataSetFirebase {

    String teamone;
    String teamtwo;

    public String getTeamone() {
        return teamone;
    }

    public void setTeamone(String teamone) {
        this.teamone = teamone;
    }

    public String getTeamtwo() {
        return teamtwo;
    }

    public void setTeamtwo(String teamtwo) {
        this.teamtwo = teamtwo;
    }

    public DataSetFirebase() {
    }

    public DataSetFirebase(String teamone, String teamtwo) {
        this.teamone = teamone;
        this.teamtwo = teamtwo;
    }
}
