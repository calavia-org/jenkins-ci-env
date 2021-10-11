import com.homeaway.devtools.jenkins.testing.JenkinsPipelineSpecification
import groovy.transform.CompileStatic

import org.calavia.jenkins.CodeAnalysis

/**
 * Utility class for declaring constants.
 *
 * @author jcalavia
 * @since 0.0.1
*/
class CodeAnalysisSpec extends JenkinsPipelineSpecification {

    def analize = null

    void setup() {
        analize = loadPipelineScriptForTest('vars/analize.groovy')
    }

    void "test_molecule_analysis_command" () {
        when:
            analize( CodeAnalysis.Types.MOLECULE)
        then:
            1 * getPipelineMock('sh')(CodeAnalysis.MOLECULE_COMMAND)
    }

    void "test_sonar_analysis_command" () {
        when:
            analize( CodeAnalysis.Types.SONAR, new HashMap<String,String>() )
        then:
            1 * getPipelineMock('sh')({ it =~ CodeAnalysis.SONAR_COMMAND + '.*' })
    }

    void "test_yaml_lint_analysis_command" () {
        when:
            analize( CodeAnalysis.Types.YAMLLINT)
        then:
            1 * getPipelineMock('sh')(CodeAnalysis.YAMLLINT_COMMAND)
    }

}
