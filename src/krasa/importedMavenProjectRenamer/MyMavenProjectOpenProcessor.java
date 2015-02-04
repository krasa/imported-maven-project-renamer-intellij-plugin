package krasa.importedMavenProjectRenamer;

import org.jetbrains.idea.maven.wizards.*;

public class MyMavenProjectOpenProcessor extends MavenProjectOpenProcessor {
    public MyMavenProjectOpenProcessor(MyMavenProjectBuilder builder) {
        super(builder);
    }
}
