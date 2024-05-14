import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

// Subject interface
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject
class SliderSubject implements Subject {
    private int value = 0;
    private final java.util.List<Observer> observers = new java.util.ArrayList<>();

    public void setValue(int value) {
        this.value = value;
        notifyObservers();
    }

    public int getValue() {
        return value;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(value);
        }
    }
}

// Observer interface
interface Observer {
    void update(int value);
}

// Concrete Observer
class ValueDisplay implements Observer {
    private final JLabel label;

    public ValueDisplay(JLabel label) {
        this.label = label;
    }

    @Override
    public void update(int value) {
        label.setText("Value: " + value);
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        // Create subject
        SliderSubject subject = new SliderSubject();

        // Create frame for slider
        JFrame frame1 = new JFrame("Slider Subject");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new FlowLayout());

        // Create slider
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                if (!source.getValueIsAdjusting()) {
                    subject.setValue(source.getValue());
                }
            }
        });

        // Add slider to frame
        frame1.add(slider);
        frame1.pack();
        frame1.setVisible(true);

        // Create frame for value display
        JFrame frame2 = new JFrame("Value Display");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setLayout(new FlowLayout());

        // Create label for value display
        JLabel valueLabel = new JLabel("Value: ");
        frame2.add(valueLabel);

        // Create observer and register with subject
        Observer observer = new ValueDisplay(valueLabel);
        subject.registerObserver(observer);

        // Add label to frame
        frame2.pack();
        frame2.setVisible(true);
    }
}
