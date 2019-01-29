package controllers;

import DataStructure.IBinTree;
import ExprNode.Evaluable;
import Parser.CalcParser;
import Parser.ParseException;
import Parser.TokenMgrError;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {
    private StringBuilder inputBuffer = new StringBuilder();
    public Label inputLabel;
    public Label resultLabel;

    public void onInputButton(ActionEvent actionEvent) {
        Button button = (Button)actionEvent.getSource();
        inputBuffer.append(button.getText());
        inputLabel.setText(inputBuffer.toString());
    }

    public void onResultButton() {
        String expr = inputBuffer.toString();
        try {
            IBinTree<Evaluable> eTree = CalcParser.parse(expr);
            Number n = eTree.getValue().eval();
            if (n instanceof Integer) {
                resultLabel.setText(String.valueOf(n.intValue()));
            } else {
                resultLabel.setText(String.valueOf(n.doubleValue()));
            }
        } catch (ParseException ee) {
            resultLabel.setText("不正な入力です");
        }finally {
            inputBuffer = new StringBuilder();
        }
    }
}
