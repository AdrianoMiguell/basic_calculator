import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class CalculatorController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnBackspace;

    @FXML
    private Button btnCancelEntry;

    @FXML
    private Button btnClean;

    @FXML
    private Button btnClousedParent;

    @FXML
    private Button btnComma;

    @FXML
    private Button btnDiv;

    @FXML
    private Button btnEight;

    @FXML
    private Button btnEqual;

    @FXML
    private Button btnFive;

    @FXML
    private Button btnFour;

    @FXML
    private Button btnInverse;

    @FXML
    private Button btnMult;

    @FXML
    private Button btnNegative;

    @FXML
    private Button btnNine;

    @FXML
    private Button btnOne;

    @FXML
    private Button btnOpenParent;

    @FXML
    private Button btnPercent;

    @FXML
    private Button btnSeven;

    @FXML
    private Button btnSix;

    @FXML
    private Button btnSub;

    @FXML
    private Button btnThree;

    @FXML
    private Button btnTwo;

    @FXML
    private Button btnZero;

    @FXML
    private TextField enterValueField;

    @FXML
    private Button iconBackspace;

    @FXML
    private Label responseValue;

    String number[] = { "", "" };
    String op = "";
    int numberAct = 0;
    int result = 0;

    @FXML
    void btnAddActived(ActionEvent event) {
        if (enterValueField.getText() != "") {
            String numInOp = enterValueField.getText();
            op = "+";
            numberAct = 1;
            responseValue.setText(numInOp + " " + op + " ");
        }
    }

    @FXML
    void btnBackspaceActived(ActionEvent event) {
        System.out.println(enterValueField.getText());
        String st = enterValueField.getText();
        String newSt = st.substring(0, st.length() - 1);
        enterValueField.setText(newSt);
        number[numberAct] = newSt;
        System.out.println("menos um = " + newSt);
    }

    @FXML
    void btnCancelEntryActived(ActionEvent event) {
        System.out.println("Atualização futura!");
    }

    @FXML
    void btnCleanActived(ActionEvent event) {
        clearFields();
    }

    @FXML
    void btnClousedParentActived(ActionEvent event) {
        System.out.println("Atualização futura!");
    }

    @FXML
    void btnCommaActived(ActionEvent event) {
        System.out.println("Atualização futura!");
    }

    @FXML
    void btnDivActived(ActionEvent event) {
        if (enterValueField.getText() != "") {
            String numInOp = enterValueField.getText();
            op = "/";
            numberAct = 1;
            responseValue.setText(numInOp + " " + op + " ");
        }
    }

    @FXML
    void btnEightActived(ActionEvent event) {
        changeValueActual("8");
    }

    @FXML
    void btnEqualClicked(MouseEvent event) {
        System.out.println("Click to change");
        if (!number[0].equals("") && !number[0].equals("")) {
            String opeString = responseValue.getText();
            responseValue.setText(opeString + number[numberAct] + " = ");
            switchOp(op);
            enterValueField.setText(Integer.toString(result));
            numberAct = 0;
            clearValueActual();
        }
    }

    @FXML
    void btnFiveActived(ActionEvent event) {
        changeValueActual("5");
    }

    @FXML
    void btnFourActived(ActionEvent event) {
        changeValueActual("4");
    }

    @FXML
    void btnInverseActived(ActionEvent event) {
        System.out.println("Atualização futura!");
    }

    @FXML
    void btnMultActived(ActionEvent event) {
        if (enterValueField.getText() != "") {
            String numInOp = enterValueField.getText();
            op = "*";
            numberAct = 1;
            responseValue.setText(numInOp + " " + op + " ");
        }
    }

    @FXML
    void btnNegativeActived(ActionEvent event) {
        System.out.println("Atualização futura!");
    }

    @FXML
    void btnNineActived(ActionEvent event) {
        changeValueActual("9");
    }

    @FXML
    void btnOneActived(ActionEvent event) {
        changeValueActual("1");
    }

    @FXML
    void btnOpenParentActived(ActionEvent event) {
        System.out.println("Atualização futura!");
    }

    @FXML
    void btnPercentActived(ActionEvent event) {
        System.out.println("Atualização futura!");
    }

    @FXML
    void btnSevenActived(ActionEvent event) {
        changeValueActual("7");
    }

    @FXML
    void btnSixActived(ActionEvent event) {
        changeValueActual("6");
    }

    @FXML
    void btnSubActived(ActionEvent event) {
        if (enterValueField.getText() != "") {
            String numInOp = enterValueField.getText();
            op = "-";
            numberAct = 1;
            responseValue.setText(numInOp + " " + op + " ");
        }
    }

    @FXML
    void btnThreeActived(ActionEvent event) {
        changeValueActual("3");
    }

    @FXML
    void btnTwoActived(ActionEvent event) {
        changeValueActual("2");
    }

    @FXML
    void btnZeroActived(ActionEvent event) {
        changeValueActual("0");
    }

    @FXML
    void enterValueFieldPressed(KeyEvent event) {
        System.out.println(event.getText().toString());
        number[numberAct] += event.getText();
    }

    public void changeValueActual(String num) {
        if (!enterValueField.getText().isEmpty()) {
            enterValueField.setText("");
        }

        number[numberAct] += num;
        System.out.println(number[numberAct]);
        enterValueField.setText(number[numberAct]);
        if (numberAct == 0) {
            responseValue.setText("");
        }
    }

    public void clearValueActual() {
        number[0] = "";
        number[1] = "";
    }

    public void clearFields() {
        enterValueField.setText("");
        responseValue.setText("");
    }

    public void error(String message) {
        System.out.println(message);
    }

    public void switchOp(String op) {
        int n1 = Integer.parseInt(number[0]);
        int n2 = Integer.parseInt(number[1]);

        System.out.println(n1);

        switch (op) {
            case "+":
                result = sum(n1, n2);
                break;
            case "-":
                result = sub(n1, n2);
                break;
            case "*":
                result = mult(n1, n2);
                break;
            case "/":
                result = div(n1, n2);
                break;

            default:
                System.out.println("Operation not supported");
                break;
        }

        System.out.println(result);
    }

    public int sum(int valueOne, int valueTwo) {
        return valueOne + valueTwo;
    }

    public int sub(int valueOne, int valueTwo) {
        return valueOne - valueTwo;
    }

    public int mult(int valueOne, int valueTwo) {
        return valueOne * valueTwo;
    }

    public int div(int valueOne, int valueTwo) {
        return valueOne / valueTwo;
    }

}