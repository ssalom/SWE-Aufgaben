import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Route {
  private List<Ort> orte;

  public Route () {
    orte = new ArrayList<>();
  }

  public void add(Ort ort) {
    orte.add(ort);
  }

  public void anzeigen () {
    System.out.println("Meine Route");
    orte.forEach(ort -> ort.anzeigen());
  }

  public double rechneDistanz () {
    double distanzGesamt = 0;
    for (int i = 0; i < orte.size(); i++) {
      int naechsterOrt = i + 1;
      if (naechsterOrt < orte.size()) {
        distanzGesamt += orte.get(i).rechneDistanz(orte.get(naechsterOrt));
      }
    }
      return distanzGesamt;
  }


  public Zeit rechneReisezeit(int geschwindigkeit) {
      int zeitInSek = 0;
      zeitInSek = (int)((rechneDistanz() / geschwindigkeit) * 3600);
      Zeit z = new Zeit();
      z.setSekMinStd(zeitInSek);
      return z;
  }

  public Zeit rechneAnkunft(Zeit start, int geschwindigkeit) {
        return start.add(rechneReisezeit(geschwindigkeit));
  }
}
