package application.data;

import java.util.ArrayList;
import java.util.List;

public class CData {

    private List<String> historique;

    public CData() {
        this.historique = new ArrayList<String>();
    }

    public List<String> getHistorique() {
        return historique;
    }
}
