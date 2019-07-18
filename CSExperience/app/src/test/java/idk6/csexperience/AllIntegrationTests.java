package idk6.csexperience;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import idk6.csexperience.persistence.ExamsPersistenceTest;
import idk6.csexperience.persistence.PlayerStatsPersistenceTest;
import idk6.csexperience.persistence.PlayerTimeTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PlayerStatsPersistenceTest.class,
        ExamsPersistenceTest.class,
        PlayerTimeTest.class,
})
public class AllIntegrationTests {

}
