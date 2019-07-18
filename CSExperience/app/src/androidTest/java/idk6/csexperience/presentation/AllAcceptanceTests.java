package idk6.csexperience.presentation;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
;import idk6.csexperience.presentation.AcceptanceTests.DoJobTest;
import idk6.csexperience.presentation.AcceptanceTests.LoginTest;
import idk6.csexperience.presentation.AcceptanceTests.PurchasableItemTest;
import idk6.csexperience.presentation.AcceptanceTests.SaveLoadTest;
import idk6.csexperience.presentation.AcceptanceTests.StatusActivityTest;
import idk6.csexperience.presentation.AcceptanceTests.StudyActivityTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTest.class,
        SaveLoadTest.class,
        DoJobTest.class,
        PurchasableItemTest.class,
        StudyActivityTest.class,
        StatusActivityTest.class,

})

public class AllAcceptanceTests {}
