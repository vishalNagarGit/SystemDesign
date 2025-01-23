package LLD.librarymanagement;

public class Log {
    private String isbn;
    private LogType logType;
    private int date;
    private int panalty;

    public Log(String isbn, LogType logType, int date, int panalty) {
        this.isbn = isbn;
        this.logType = logType;
        this.date = date;
        this.panalty = panalty;
    }

    // Getters
    public String getIsbn() {
        return isbn;
    }

    public LogType getLogType() {
        return logType;
    }

    public int getDate() {
        return date;
    }

    public int getPanalty() {
        return panalty;
    }
}