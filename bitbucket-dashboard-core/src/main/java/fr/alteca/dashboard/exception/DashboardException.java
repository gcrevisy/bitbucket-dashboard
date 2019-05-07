package fr.alteca.dashboard.exception;

/**
 * Classe d'exception personnalisée.
 */
public class DashboardException extends Exception {

    public DashboardException(String msg) {
        super(msg);
    }

    public DashboardException(String msg, Throwable t) {
        super(msg, t);
    }

    private static final long serialVersionUID = 1L;

}