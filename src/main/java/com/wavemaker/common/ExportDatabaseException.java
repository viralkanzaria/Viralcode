package com.wavemaker.common;

/**
 * @author sunilp
 */
public class ExportDatabaseException extends WMRuntimeException {

    public ExportDatabaseException(MessageResource resource, Object... args) {
        super(resource, args);
    }

    public ExportDatabaseException(Throwable cause, MessageResource resource, Object... args) {
        super(resource, cause, args);
    }

    public ExportDatabaseException(String message) {
        super(message, (String) null);
    }

    public ExportDatabaseException(Throwable e, String message)
    {
        super(message, e) ;
    }
}