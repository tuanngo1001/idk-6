package idk6.csexperience;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import idk6.csexperience.business.AdjustPlayerStatsTest;
import idk6.csexperience.business.AdjustGameTest;
import idk6.csexperience.business.AdjustCalendarTest;

import idk6.csexperience.business.CalendarPersistenceAccessorTest;
import idk6.csexperience.business.CombatTest;
import idk6.csexperience.business.GameServicesTest;
import idk6.csexperience.objects.CalendarTest;
import idk6.csexperience.objects.GameTest;
import idk6.csexperience.objects.PlayerStatsTest;
import idk6.csexperience.objects.PlayerTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        AdjustGameTest.class,
        AdjustPlayerStatsTest.class,
        AdjustCalendarTest.class,
        CombatTest.class,
        CalendarPersistenceAccessorTest.class,
        GameServicesTest.class,

        GameTest.class,
        PlayerTest.class,
        PlayerStatsTest.class,
        CalendarTest.class
})

public class AllUnitTests {}
