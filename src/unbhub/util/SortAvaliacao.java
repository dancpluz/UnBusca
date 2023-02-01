package unbhub.util;

import java.util.Comparator;
import unbhub.Avaliacao;

/**
 *
 * @author gcrbe
 */
public class SortAvaliacao implements Comparator<Avaliacao> {  
    @Override
    public int compare(Avaliacao a, Avaliacao b) {
        return a.getData().compareTo(b.getData());
    }
}
