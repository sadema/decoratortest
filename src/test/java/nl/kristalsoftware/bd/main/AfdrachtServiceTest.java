package nl.kristalsoftware.bd.main;

import nl.kristalsoftware.bd.annotations.EUMember;
import nl.kristalsoftware.bd.annotations.Voes;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by sjoerdadema on 03-07-15.
 */
@RunWith(Arquillian.class)
public class AfdrachtServiceTest {

    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(LogProducer.class)
                .addClass(EUMemeberAfdrachtServiceImpl.class)
                .addClass(VoesAfdrachtServiceImpl.class)
                .addClass(AfdrachtServiceDecorator.class)
                .addClass(RetentionServiceImpl.class)
                .addAsManifestResource("META-INF/beans.xml", ArchivePaths.create("beans.xml"));
    }

    @Inject
    @Voes
    private AfdrachtService voesAfdrachtService;

    @Inject
    @EUMember
    private AfdrachtService euMemberAfdrachtService;

    @Test
    public void doPaymentForVoesTest() throws Exception {
        assertNotNull("voesAfdrachtService is null", voesAfdrachtService);
        Integer bedrag = voesAfdrachtService.getBetalingsVerplichting(100);
        assertThat("bedrag is niet 100", bedrag, is(100));
    }

    @Test
    public void doPaymentForEuMemberTest() throws Exception {
        assertNotNull("euMemberAfdrachtService is null", euMemberAfdrachtService);
        Integer bedrag = euMemberAfdrachtService.getBetalingsVerplichting(100);
        assertThat("bedrag is niet 70", bedrag, is(70));
    }

}
