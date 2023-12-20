import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lesson_10 {
    public static void main() {
        TextModel model = new TextModel();
        TextView view = new TextView();
        TextController controller = new TextController(model, view);
    }
}

class TextModel {
    private String buttonText;

    public TextModel() {
        buttonText = "Початковий текст";
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String newText) {
        buttonText = newText;
    }
}

class TextView extends JFrame {
    private JButton button;

    public TextView() {
        super("Змінююча кнопка");

        button = new JButton();
        button.setText("Початковий текст");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.add(button);
        add(panel);

        setVisible(true);
    }

    public JButton getButton() {
        return button;
    }
}

class TextController {
    private TextModel model;
    private TextView view;

    public TextController(TextModel model, TextView view) {
        this.model = model;
        this.view = view;

        view.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newText = "Новий текст";
                model.setButtonText(newText);
                view.getButton().setText(model.getButtonText());
            }
        });
    }
}