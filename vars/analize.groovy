import org.calavia.jenkins.CodeAnalysis

def call(CodeAnalysis.Types type, Map<String,String> args = [:]) {
    String analysisCommand = CodeAnalysis.analysisCommand(type, args)
    return sh( analysisCommand )
}
