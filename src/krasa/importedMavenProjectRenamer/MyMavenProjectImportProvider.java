package krasa.importedMavenProjectRenamer;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.idea.maven.wizards.*;

public class MyMavenProjectImportProvider extends MavenProjectImportProvider {
    @NotNull
    @Override
    public String getName() {
        return "Better Maven";
    }

    public MyMavenProjectImportProvider(MyMavenProjectBuilder builder) {
        super(builder);
    }
}
