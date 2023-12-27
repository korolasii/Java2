import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

import static java.lang.Double.parseDouble;


public class lesson_11 {
    public static void main(){
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(view);
        CalculatorModel model = new CalculatorModel();
        view.setVisible(true);
    }
}

class CalculatorView extends JFrame {
    private JTextField text;

    public CalculatorView() {
        initializeUI();
    }

    private void initializeUI() {
        setSize(600, 600);
        setLayout(null);

        text = new JTextField();
        text.setBounds(50, 0, 400, 50);
        add(text);

        JButton b1 = new JButton("1");
        b1.setBounds(50,200,100,50);
        add(b1);

        JButton b2 = new JButton("2");
        b2.setBounds(150,200,100,50);
        add(b2);

        JButton b3 = new JButton("3");
        b3.setBounds(250,200,100,50);
        add(b3);

        JButton b4 = new JButton("4");
        b4.setBounds(50,150,100,50);
        add(b4);

        JButton b5 = new JButton("5");
        b5.setBounds(150,150,100,50);
        add(b5);

        JButton b6 = new JButton("6");
        b6.setBounds(250,150,100,50);
        add(b6);

        JButton b7 = new JButton("7");
        b7.setBounds(50,100,100,50);
        add(b7);

        JButton b8 = new JButton("8");
        b8.setBounds(150,100,100,50);
        add(b8);

        JButton b9 = new JButton("9");
        b9.setBounds(250,100,100,50);
        add(b9);

        JButton b0 = new JButton("0");
        b0.setBounds(150,250,100,50);
        add(b0);

        JButton b10 = new JButton("*");
        b10.setBounds(350,100,100,50);
        add(b10);

        JButton b11 = new JButton("-");
        b11.setBounds(350,150,100,50);
        add(b11);

        JButton b12 = new JButton("+");
        b12.setBounds(350,200,100,50);
        add(b12);

        JButton b13 = new JButton("(");
        b13.setBounds(50,50,100,50);
        add(b13);

        JButton b14 = new JButton(")");
        b14.setBounds(150,50,100,50);
        add(b14);

        JButton b15 = new JButton("^");
        b15.setBounds(250,50,100,50);
        add(b15);

        JButton b16 = new JButton("/");
        b16.setBounds(350,50,100,50);
        add(b16);

        JButton bDel = new JButton("←");
        bDel.setBounds(250,250,100,50);
        add(bDel);

        JButton bClear = new JButton("C");
        bClear.setBounds(50,250,100,50);
        add(bClear);

        JButton bRav= new JButton("=");
        bRav.setBounds(350,250,100,50);
        add(bRav);

        setVisible(true);
    }

    public JTextField getTextField() {
        return text;
    }

    public void setDisplay(String value) {
        text.setText(value);
    }

    public void addActionListenerToButton(String buttonText, ActionListener listener) {
        for (java.awt.Component component : getContentPane().getComponents()) {
            if (component instanceof JButton && ((JButton) component).getText().equals(buttonText)) {
                ((JButton) component).addActionListener(listener);
            }
        }
    }
}

class CalculatorController {
    private CalculatorView view;
    private String currentInput = "";

    public CalculatorController(CalculatorView view) {
        this.view = view;
        addActionListeners();
    }

    private void addActionListeners() {
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonText = e.getActionCommand();
                switch (buttonText) {
                    case "=":
                        String result = CalculatorModel.evaluateExpression(currentInput);
                        view.setDisplay(result);
                        currentInput = result;
                        break;
                    case "C":
                        currentInput = "";
                        view.setDisplay(currentInput);
                        break;
                    case "←":
                        String str = currentInput;
                        view.setDisplay(str.substring(0, str.length()-1));
                        break;
                    default:
                        currentInput += buttonText;
                        view.setDisplay(currentInput);
                        break;
                }
            }
        };

        view.addActionListenerToButton("1", buttonListener);
        view.addActionListenerToButton("2", buttonListener);
        view.addActionListenerToButton("3", buttonListener);
        view.addActionListenerToButton("4", buttonListener);
        view.addActionListenerToButton("5", buttonListener);
        view.addActionListenerToButton("6", buttonListener);
        view.addActionListenerToButton("7", buttonListener);
        view.addActionListenerToButton("8", buttonListener);
        view.addActionListenerToButton("9", buttonListener);
        view.addActionListenerToButton("0", buttonListener);
        view.addActionListenerToButton("=", buttonListener);
        view.addActionListenerToButton("C", buttonListener);
        view.addActionListenerToButton("←", buttonListener);
        view.addActionListenerToButton("(", buttonListener);
        view.addActionListenerToButton(")", buttonListener);
        view.addActionListenerToButton("+", buttonListener);
        view.addActionListenerToButton("-", buttonListener);
        view.addActionListenerToButton("/", buttonListener);
        view.addActionListenerToButton("^", buttonListener);
        view.addActionListenerToButton("*", buttonListener);

    }
}

class CalculatorModel {
    static double result;
    public static String evaluateExpression(String expression) {
        calculate(expression);
        return Double.toString(result);
    }

    public static void calculate(String str){
        ArrayList<String> array = breakingString(str);
        array = deegre(array);
        array = division(array);
        array = multiplication(array);
        array = summation(array);
        array = difference(array);
        result = parseDouble(array.get(0));
    }

    public static ArrayList<String> breakingString(String str) {
        ArrayList<String> array = new ArrayList<>();

        StringBuilder temp = new StringBuilder();

        boolean isFirstNegative = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (i == 0 && c == '-') {
                isFirstNegative = true;
                continue;
            }

            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '(' || c == ')' || c == '.') {
                if (temp.length() > 0) {
                    array.add(temp.toString());
                    temp = new StringBuilder();
                }
                array.add(String.valueOf(c));
            } else {
                temp.append(c);
            }
        }

        if (temp.length() > 0) {
            array.add(temp.toString());
        }

        if (isFirstNegative && array.size() >= 2 && array.get(0).matches("\\d+(\\.\\d+)?") && array.get(1).matches("[\\+\\-\\*\\/^()]")) {
            array.set(0, "-" + array.get(0));
        }

        return array;
    }

    public static ArrayList<String> deegre(ArrayList array){
        ArrayList<String> newArray = array;
        if(newArray.contains("^")){
            int indexDeegre = newArray.lastIndexOf("^");
            int indexFirstNumber = indexDeegre-1;
            int indexSecondNumber = indexDeegre+1;
            double deegreNumber = Math.pow(parseDouble(newArray.get(indexFirstNumber)),parseDouble(newArray.get(indexSecondNumber)));
            newArray.set(indexFirstNumber, Double.toString(deegreNumber));
            newArray.remove(indexSecondNumber);
            newArray.remove(indexDeegre);
            return deegre(newArray);
        }

        return newArray;
    }

    public static ArrayList<String> division(ArrayList array){
        ArrayList<String> newArray = array;
        if(newArray.contains("/")){
            int indexDivision = newArray.lastIndexOf("/");
            int indexFirstNumber = indexDivision-1;
            int indexSecondNumber = indexDivision+1;
            double deegreNumber = parseDouble(newArray.get(indexFirstNumber)) / parseDouble(newArray.get(indexSecondNumber));
            newArray.set(indexFirstNumber, Double.toString(deegreNumber));
            newArray.remove(indexSecondNumber);
            newArray.remove(indexDivision);
            return division(newArray);
        }
        return newArray;
    }

    public static ArrayList<String> multiplication(ArrayList array){
        ArrayList<String> newArray = array;
        if(newArray.contains("*")){
            int indexMultiplication = newArray.lastIndexOf("*");
            int indexFirstNumber = indexMultiplication-1;
            int indexSecondNumber = indexMultiplication+1;
            double deegreNumber = parseDouble(newArray.get(indexFirstNumber)) * parseDouble(newArray.get(indexSecondNumber));
            newArray.set(indexFirstNumber, Double.toString(deegreNumber));
            newArray.remove(indexSecondNumber);
            newArray.remove(indexMultiplication);
            return multiplication(newArray);
        }
        return newArray;
    }

    public static ArrayList<String> summation(ArrayList array){
        ArrayList<String> newArray = array;
        if(newArray.contains("+")){
            int indexSummation = newArray.lastIndexOf("+");
            int indexFirstNumber = indexSummation-1;
            int indexSecondNumber = indexSummation+1;
            double deegreNumber = parseDouble(newArray.get(indexFirstNumber)) + parseDouble(newArray.get(indexSecondNumber));
            newArray.set(indexFirstNumber, Double.toString(deegreNumber));
            newArray.remove(indexSecondNumber);
            newArray.remove(indexSummation);
            return summation(newArray);
        }
        return newArray;
    }

    public static ArrayList<String> difference(ArrayList array){
        ArrayList<String> newArray = array;
        if(newArray.contains("-")){
            int indexDifference = newArray.lastIndexOf("-");
            int indexFirstNumber = indexDifference-1;
            int indexSecondNumber = indexDifference+1;
            double deegreNumber = parseDouble(newArray.get(indexFirstNumber)) - parseDouble(newArray.get(indexSecondNumber));
            newArray.set(indexFirstNumber, Double.toString(deegreNumber));
            newArray.remove(indexSecondNumber);
            newArray.remove(indexDifference);

            return difference(newArray);
        }
        return newArray;
    }

}