package idk6.csexperience;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import idk6.csexperience.business.AdjustPlayerStatsTest;
import idk6.csexperience.business.AdjustGameTest;
import idk6.csexperience.business.AdjustCalendarTest;

import idk6.csexperience.objects.PlayerStatsTest;
import idk6.csexperience.objects.SkillLevelTest;
import idk6.csexperience.objects.SkillTest;
import idk6.csexperience.objects.CombatSkillsTest;
import idk6.csexperience.objects.GameTest;
import idk6.csexperience.objects.PlayerTest;
import idk6.csexperience.objects.CalendarTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AdjustGameTest.class,
        AdjustPlayerStatsTest.class,
        AdjustCalendarTest.class,
        AdjustTimeTest.class,

        GameTest.class,
        PlayerTest.class,
        PlayerStatsTest.class,
        CalendarTest.class,
        SkillTest.class,
        SkillLevelTest.class,
        CombatSkillsTest.class

})

public class AllTests {}
