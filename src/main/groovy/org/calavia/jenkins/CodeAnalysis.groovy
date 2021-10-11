package org.calavia.jenkins

import groovy.transform.CompileStatic

/**
 * Base class for code analysis.
 *
 * @author jcalavia
 * @since 0.0.1
*/
@CompileStatic
class CodeAnalysis implements Serializable {

    private static final long serialVersionUID = 1L
    private static final String MOLECULE_COMMAND = 'molecule lint'
    static final String SONAR_COMMAND = 'sonar-scanner'
    private static final String YAMLLINT_COMMAND = 'yamllint .'

    enum Types {

        MOLECULE ('MOLECULE'),
        SONAR ('SONAR'),
        YAMLLINT ('YAMLLINT'),

        private final String type

        Types(String type) {
            this.type = type
        }

        String getType() {
            return type
        }

    }

    static String analysisCommand(Types type, Map<String,String> args) {
        switch (type) {
            case CodeAnalysis.Types.MOLECULE:
                return MOLECULE_COMMAND
            case CodeAnalysis.Types.SONAR:
                return sonarCommand(args)
            case CodeAnalysis.Types.YAMLLINT:
                return YAMLLINT_COMMAND
            default:
                return '[FAILED] Unsupported Analisys Type: ' + type + ' | false'
        }
    }

    private static String sonarCommand(Map<String,String> args) {
        return  CodeAnalysis.SONAR_COMMAND  + args
    }

}
