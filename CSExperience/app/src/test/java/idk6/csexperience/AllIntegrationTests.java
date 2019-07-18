package idk6.csexperience;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import idk6.csexperience.Persistence.ExamsPersistenceTest;
import idk6.csexperience.Persistence.PlayerStatsPersistenceTest;
import idk6.csexperience.Persistence.PlayerTimeTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PlayerStatsPersistenceTest.class,
        ExamsPersistenceTest.class,
        PlayerTimeTest.class,
})
public class AllIntegrationTests {

}
