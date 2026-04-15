import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class QuizApp extends JFrame implements ActionListener {

    Question[] questions;
    int current = 0, score = 0;
    String username;

    JLabel qLabel, timerLabel;
    JRadioButton[] options = new JRadioButton[4];
    ButtonGroup bg;
    JButton nextBtn;

    Timer timer;
    int timeLeft = 10;

    public QuizApp(String username) {
        this.username = username;

        questions = new Question[]{
            new Question("Java is?", new String[]{"Language", "OS", "Tool", "IDE"}, 0),
            new Question("OOP stands for?", new String[]{"Object Oriented Programming", "Only One Program", "Old Program", "None"}, 0),
            new Question("Which is not Java feature?", new String[]{"Portable", "Secure", "Pointer", "Object-Oriented"}, 2)
        };

        setTitle("Quiz App");
        setSize(400, 350);
        setLayout(null);

        qLabel = new JLabel();
        qLabel.setBounds(20, 20, 350, 30);
        add(qLabel);

        timerLabel = new JLabel();
        timerLabel.setBounds(300, 20, 100, 30);
        add(timerLabel);

        bg = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            options[i].setBounds(20, 60 + i * 30, 300, 30);
            bg.add(options[i]);
            add(options[i]);
        }

        nextBtn = new JButton("Next");
        nextBtn.setBounds(150, 220, 80, 30);
        nextBtn.addActionListener(this);
        add(nextBtn);

        loadQuestion();

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void loadQuestion() {
        bg.clearSelection();
        qLabel.setText(questions[current].question);

        for (int i = 0; i < 4; i++) {
            options[i].setText(questions[current].options[i]);
        }

        startTimer();
    }

    void startTimer() {
        timeLeft = 10;
        timerLabel.setText("Time: " + timeLeft);

        timer = new Timer(1000, e -> {
            timeLeft--;
            timerLabel.setText("Time: " + timeLeft);

            if (timeLeft == 0) {
                timer.stop();
                nextQuestion();
            }
        });

        timer.start();
    }

    void nextQuestion() {
        checkAnswer();
        current++;

        if (current < questions.length) {
            loadQuestion();
        } else {
            showResult();
        }
    }

    void checkAnswer() {
        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected() && i == questions[current].correctAnswer) {
                score++;
            }
        }
    }

    void showResult() {
        double percentage = (score * 100.0) / questions.length;
        String result = percentage >= 50 ? "Pass" : "Fail";

        saveResult();

        JOptionPane.showMessageDialog(this,
                "Score: " + score +
                "\nPercentage: " + percentage + "%" +
                "\nResult: " + result);
    }

    void saveResult() {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO results(username, score) VALUES (?, ?)"
            );

            ps.setString(1, username);
            ps.setInt(2, score);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        timer.stop();
        nextQuestion();
    }
    public static void main(String[] args) {
    new QuizApp("babu");
}
    }
