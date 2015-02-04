package krasa.importedMavenProjectRenamer;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.idea.maven.wizards.MavenProjectBuilder;
import org.picocontainer.MutablePicoContainer;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.diagnostic.Logger;

public class ImportedMavenProjectRenamerAppComponent implements ApplicationComponent {

	private static final Logger LOG = Logger.getInstance(ImportedMavenProjectRenamerAppComponent.class.getName());

	public ImportedMavenProjectRenamerAppComponent() {
	}

	public void initComponent() {
		MutablePicoContainer picoContainer = (MutablePicoContainer) ApplicationManager.getApplication().getPicoContainer();
		LOG.info("Overriding " + MavenProjectBuilder.class.getName() + ".");
		picoContainer.unregisterComponent(MavenProjectBuilder.class.getName());
		picoContainer.registerComponentImplementation(MavenProjectBuilder.class.getName(), MyMavenProjectBuilder.class);
	}

	public void disposeComponent() {

	}

	@NotNull
	public String getComponentName() {
		return "ImportedMavenProjectRenamer";
	}
}
