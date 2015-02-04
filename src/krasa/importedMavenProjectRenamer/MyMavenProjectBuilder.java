package krasa.importedMavenProjectRenamer;

import java.util.List;

import org.jetbrains.idea.maven.wizards.MavenProjectBuilder;

import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.*;

public class MyMavenProjectBuilder extends MavenProjectBuilder {

	private String parentName;
	private VirtualFile root;

	@Override
	public boolean setRootDirectory(Project projectToUpdate, String root) throws ConfigurationException {
		try {
			this.root = LocalFileSystem.getInstance().findFileByPath(root);
		} catch (Exception e) {
		}
		return super.setRootDirectory(projectToUpdate, root);
	}

	@Override
	public void setFiles(List<VirtualFile> files) {
		try {
			this.parentName = files.get(0).getParent().getName();
		} catch (Exception e) {
		}
		super.setFiles(files);
	}

	@Override
	public String getSuggestedProjectName() {
		if (parentName != null) {
			return parentName;
		} else if (root != null) {
            String name = root.getName();
            if (!name.contains("_") && root.getParent().getName().contains("_")) {
                name = root.getParent().getName();
            }
            return name;
        }
        return super.getSuggestedProjectName();
	}
}
