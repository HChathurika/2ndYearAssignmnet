import model.CurrencyModel;
import controller.CurrencyController;
import database.CurrencyDAO;
import view.CurrencyConverterView;

public class Main {
    public static void main(String[] args) {
        CurrencyModel model = new CurrencyModel();
        CurrencyDAO dao = new CurrencyDAO();
        CurrencyController controller = new CurrencyController(model, dao);
        CurrencyConverterView view = new CurrencyConverterView(controller);

        view.start();
    }
}
