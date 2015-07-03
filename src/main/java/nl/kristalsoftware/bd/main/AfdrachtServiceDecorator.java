package nl.kristalsoftware.bd.main;

import nl.kristalsoftware.bd.annotations.EUMember;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

/**
 * Created by sjoerdadema on 03-07-15.
 */
@Decorator
@EUMember
public class AfdrachtServiceDecorator implements AfdrachtService {

    @Inject
    private RetentionService retentionService;

    @Inject
    @Delegate
    @EUMember
    private AfdrachtService afdrachtService;

    @Override
    public Integer getBetalingsVerplichting(Integer bedrag) {
        Integer retentionBedrag = retentionService.berekenRetention(bedrag);
        return afdrachtService.getBetalingsVerplichting(bedrag - retentionBedrag);
    }
}
