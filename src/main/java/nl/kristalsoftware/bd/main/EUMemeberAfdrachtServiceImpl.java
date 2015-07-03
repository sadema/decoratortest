package nl.kristalsoftware.bd.main;

import nl.kristalsoftware.bd.annotations.EUMember;
import nl.kristalsoftware.bd.annotations.Voes;

import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 03-07-15.
 */
@EUMember
public class EUMemeberAfdrachtServiceImpl implements AfdrachtService {

    @Inject
    private Logger log;

    public EUMemeberAfdrachtServiceImpl() {
    }

    @Override
    public Integer getBetalingsVerplichting(Integer bedrag) {
        log.info("EUMember betalingsverplichting: " + bedrag);
        return bedrag;
    }
}
