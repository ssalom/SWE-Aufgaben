public enum Messages {
    START("TaskManager wurde erfolgreich gestartet"),
    ENDE("Auf wiedersehen"),
    WARNING_WRON_MENU_ENTRY("Falscher Menu Eintrag gewählt. Bitte versuchen Sie es erneut mit einer entsprechenden Nummer."),
    WELCOME("Bitte wählen Sie einen Menu Eintrag in dem Sie eine entsprechenden Menu Nummer eingeben."),
    SHORT_DESCRIPTION("Kurzbeschreibung"),
    DESCRIPTION("Beschreibung"),
    PRIORITY("Priorität (1 - Hoch, 2 - Medium, 3 - Niedrig)"),
    STATE("Status (1 - Open, 2 - In Progress, 3 - Done)"),
    SHOW_TASK_DIALOG_QUESTION1("Bitte wählen Sie eine der folgenden Tasks aus um die Detailierten Informatiionen anzuzeigen."),
    SHOW_TASK_DIALOG_QUESTION2("Nummer der anzuzeigenden Task"),
    EDIT_TASK_DIALOG_QUESTION1("Bitte wählen Sie eine der folgenden Tasks aus um sie zu bearbeiten."),
    EDIT_TASK_DIALOG_QUESTION2("Nummer der zu bearbeitenden Task"),
    EDIT_TASK_DIALOG_SUCCESS("Die Änderungen wurden Erfolgreich durchgeführt"),
    DELETE_TASK_DIALOG_QUESTION1("Bitte wählen Sie eine der folgenden Tasks aus um sie zu löschen."),
    DELETE_TASK_DIALOG_QUESTION2("Nummer der zu löschenden Task"),
    DELETE_TASK_DIALOG_SUCCESS("Task mit der Nummer %s wurden Erfolgreich gelöscht"),
    MENU_ENTRY_EXIT("Beenden"),
    MENU_ENTRY_ADD_TASK("Aufgabe hinzufügen"),
    MENU_ENTRY_EDIT_TASK("Aufgabe bearbeiten"),
    MENU_ENTRY_DELETE_TASK("Aufgabe löschen"),
    MENU_ENTRY_SHOW_TASK("Aufgabe anzeigen"),
    MENU_ENTRY_SHOW_ALL_TASKS("Alle Aufgaben Anzeigen");


    private final String message;


    private Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
