package course.lab.modernartui.interfaces;

import android.view.MenuItem;

public interface FragmentAlertDialog {
    void showDialog ( MenuItem item );
    void doPositiveClick();
    void doNegativeClick();
}