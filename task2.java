import java.util.Deque;
import java.util.LinkedList;

class BrowserHistory {
    private Deque<String> history = new LinkedList<>();
    private Deque<String> forwardHistory = new LinkedList<>(); //added forward history

    public void visitSite(String site) {
        history.addFirst(site);
        forwardHistory.clear(); // Clear forward history when visiting a new site
    }

    public String back(int steps) {
        if (steps <= 0 || steps >= history.size()) {
            return history.peekFirst(); // Return current site if steps is invalid
        }
        for (int i = 0; i < steps; i++) {
            forwardHistory.addFirst(history.removeFirst());
        }
        return history.peekFirst();
    }

    public String forward(int steps) {
        if (steps <= 0 || steps >= forwardHistory.size()) {
            return history.peekFirst(); //Return current site if steps is invalid
        }
        for (int i = 0; i < steps; i++) {
            history.addFirst(forwardHistory.removeFirst());
        }
        return history.peekFirst();
    }


    public Deque<String> getHistory() {
        return new LinkedList<>(history); // Return a copy to prevent external modification
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory();
        browserHistory.visitSite("google.com");
        browserHistory.visitSite("stackoverflow.com");
        browserHistory.visitSite("github.com");

        System.out.println(browserHistory.back(1)); // Output: stackoverflow.com
        System.out.println(browserHistory.getHistory()); // Output: [stackoverflow.com, google.com]
        System.out.println(browserHistory.forward(1)); // Output: github.com
        System.out.println(browserHistory.getHistory()); // Output: [github.com, stackoverflow.com, google.com]
    }
}