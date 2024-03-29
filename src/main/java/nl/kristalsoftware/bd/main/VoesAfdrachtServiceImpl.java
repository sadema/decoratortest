package nl.kristalsoftware.bd.main;

import nl.kristalsoftware.bd.annotations.Voes;

import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 03-07-15.
 */
@Voes
public class VoesAfdrachtServiceImpl implements AfdrachtService {

    @Inject
    private Logger log;

    public VoesAfdrachtServiceImpl() {}

    @Override
    public Integer getBetalingsVerplichting(Integer bedrag) {
        log.info("Voes betalingsverplichting: " + bedrag);
        return bedrag;
    }
}
