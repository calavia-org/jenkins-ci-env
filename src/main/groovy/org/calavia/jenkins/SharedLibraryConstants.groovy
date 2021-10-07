package org.calavia.jenkins

import groovy.transform.CompileStatic

/**
 * Utility class for declaring constants.
 *
 * @author jcalavia
 * @since 0.0.1
*/
@CompileStatic
class SharedLibraryConstants implements Serializable {

    private static final long serialVersionUID = 1L

    public static final int RETURN_CODE_OK = 0
    public static final int RETURN_CODE_ERROR = -1

}
