package io.jenkins.docker.pipeline;

import org.jenkinsci.plugins.pipeline.modeldefinition.agent.DeclarativeAgentScript
import org.jenkinsci.plugins.workflow.cps.CpsScript


/**
 * @author <a href="mailto:nicolas.deloof@gmail.com">Nicolas De Loof</a>
 */
class DockerAgentScript extends DeclarativeAgentScript<DockerAgent> {

    DockerAgentScript(CpsScript s, DockerAgent dockerAgent) {
        super(s, dockerAgent)
    }

    @Override
    Closure run(Closure closure) {
        return {
            script.dockerNode("unix://var/run/docker.sock", describable.image, "/tmp") {
                body.call()
            }
        }
    }
}
