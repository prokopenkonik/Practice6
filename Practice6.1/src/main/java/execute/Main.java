package execute;

import controller.Controller;
import model.Bookshelf;
import org.apache.log4j.Logger;
import view.Viewer;

public class Main {
    static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("Приложение запущено");
        Viewer view = new Viewer();
        Bookshelf bookshelf = Bookshelf.getInstance();
        Controller controller = new Controller(view, bookshelf);
        controller.run();
    }
}
