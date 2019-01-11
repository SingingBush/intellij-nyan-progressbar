import com.intellij.ide.ui.LafManager;
import com.intellij.ide.ui.laf.LafManagerImpl;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.BaseComponent;
import com.intellij.util.ui.UIUtil;
import org.jetbrains.annotations.NotNull;

import javax.swing.UIManager;

public class NyanApplicationComponent implements BaseComponent {

    private int shownProgressBars;
    private boolean isShown;

    public NyanApplicationComponent(LafManagerImpl lafManager) {
        lafManager.addLafManagerListener(this::lookAndFeelChanged);
    }

    @Override
    public void initComponent() {
        updateProgressBarUi();
    }

    @Override
    public void disposeComponent() {
    }

    @NotNull
    @Override
    public String getComponentName() {
        return "NyanLafUpdater";
    }

    private void updateProgressBarUi() {
        UIManager.put("ProgressBarUI", NyanProgressBarUi.class.getName());
        UIManager.getDefaults().put(NyanProgressBarUi.class.getName(), NyanProgressBarUi.class);
    }

    static NyanApplicationComponent getInstance() {
        return ApplicationManager.getApplication().getComponent(NyanApplicationComponent.class);
    }

    private void lookAndFeelChanged(LafManager lafManager1) {
        updateProgressBarUi();
    }
}
