package idk6.csexperience.utils;



import com.google.common.io.Files;
import idk6.csexperience.application.Main;

import java.io.File;
import java.io.IOException;


    public class TestUtils {
        private static final File DB_SRC = new File("src/main/assets/db/CSExperienceDB.script");

        public static File copyDB() throws IOException {
            final File target = File.createTempFile("temp-db", ".script");
            Files.copy(DB_SRC, target);
            Main.setDBPathName(target.getAbsolutePath().replace(".script", ""));
            return target;
        }
    }


