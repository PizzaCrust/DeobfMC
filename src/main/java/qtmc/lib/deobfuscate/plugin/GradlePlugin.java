package qtmc.lib.deobfuscate.plugin;

import qtmc.lib.deobfuscate.DeobfMCExtension;
import qtmc.lib.deobfuscate.tasks.ApplySpecialSourceTask;
import qtmc.lib.deobfuscate.tasks.CheckDestinationTask;
import qtmc.lib.deobfuscate.tasks.DownloadClientTask;
import qtmc.lib.deobfuscate.tasks.DownloadMappingTask;
import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class GradlePlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.afterEvaluate(new Action<Project>() {
            @Override
            public void execute(Project project) {
                println("#################################################");
                println("         Reobfuscate4J 1.9 for Gradle            ");
                println("          Powered by QuantumTheoryMC             ");
                println("#################################################");
            }
        });
        project.getExtensions().add("deobfmc", DeobfMCExtension.class);
        project.getTasks().create("checkDestination", CheckDestinationTask.class);
        project.getTasks().create("downloadClient", DownloadClientTask.class);
        project.getTasks().create("downloadMappings", DownloadMappingTask.class);
        project.getTasks().create("applySpecialSource", ApplySpecialSourceTask.class);
    }

    private void println(String msg) {
        System.out.println(msg);
    }
}