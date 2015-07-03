package nl.kristalsoftware.bd.main;

import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * Created by sjoerdadema on 03-07-15.
 */
public class RetentionServiceImpl implements RetentionService {

    @Inject
    private Logger log;

    @Override
    public Integer berekenRetention(Integer bedrag) {
        Integer retentionBedrag = bedrag * 30 / 100;
        log.info("RetentionServiceImpl#berekenRetention " + retentionBedrag);
        return retentionBedrag;
    }
}
