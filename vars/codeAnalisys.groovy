import org.calavia.jenkins.SharedLibraryConstants
import org.calavia.jenkins.CodeAnalysis

int call(CodeAnalysis.Types type, Map<String,String> args) {
    switch (type) {
        case CodeAnalysis.Types.MOLECULE:
            break
        case CodeAnalysis.Types.SONAR:
            break
        case CodeAnalysis.Types.YAMLLINT:
            break
        default:
            sh( 'echo unsupported' )
            return SharedLibraryConstants.RETURN_CODE_ERROR
    }
    return sh( 'echo ' + type + ': ' + args )
}
