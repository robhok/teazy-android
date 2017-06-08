package com.hetic.teazy;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    static void removeShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("ERROR NO SUCH FIELD", "Unable to get shift mode field");
        } catch (IllegalAccessException e) {
            Log.e("ERROR ILLEGAL ALG", "Unable to change value of shift mode");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        removeShiftMode(bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener
            (new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.action_home:
                        selectedFragment = HomeFragment.newInstance();
                        break;
                    case R.id.action_partys:
                        selectedFragment = PartysFragment.newInstance();
                        break;
                    case R.id.action_profile:
                        selectedFragment = ProfileFragment.newInstance();
                        break;
                    case R.id.action_cocktails:
                        selectedFragment = CocktailsFragment.newInstance();
                        break;
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, selectedFragment);
                transaction.commit();
                return true;
                }
            });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, HomeFragment.newInstance());
        transaction.commit();

        //Used to select an item programmatically
        //bottomNavigationView.getMenu().getItem(2).setChecked(true);
    }

    private ConstraintLayout getParent(View view) {
        ViewParent parent = view.getParent();
        ConstraintLayout r = null;
        if (parent == null) {
            Log.d("TEST", "this.getParent() is null");
        }
        else {
            if (parent instanceof ViewGroup) {
                ViewParent grandparent = ((ViewGroup) parent).getParent();
                if (grandparent == null) {
                    Log.d("TEST", "((ViewGroup) this.getParent()).getParent() is null");
                }
                else {
                    if (parent instanceof ConstraintLayout) {
                        r = (ConstraintLayout) grandparent;
                    }
                    else {
                        Log.d("TEST", "((ViewGroup) this.getParent()).getParent() is not a ConstraintLayout");
                    }
                }
            }
            else {
                Log.d("TEST", "this.getParent() is not a ViewGroup");
            }
        }
        return r;
    }

    private CheckBox getCheckbox(ConstraintLayout layout) {
        return (CheckBox) layout.findViewWithTag("checkbox");
    }

    private TextView getChecksymbol(ConstraintLayout layout) {
        return (TextView) layout.findViewWithTag("checksymbol");
    }

    public void setToChecked(View view) {
        //ConstraintLayout parent = getParent(view);
        Log.d("Parent", "test");
        ConstraintLayout parent = (ConstraintLayout) view.getParent();
        if (parent != null) {
            CheckBox box = getCheckbox(parent);
            TextView symbol = getChecksymbol(parent);
            if (box != null) {
                Boolean checked = box.isChecked();
                box.setChecked(!checked);
                if (!checked == true) {
                    box.setVisibility(View.VISIBLE);
                    symbol.setVisibility(View.VISIBLE);
                } else {
                    box.setVisibility(View.INVISIBLE);
                    symbol.setVisibility(View.INVISIBLE);
                }
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem item){
        getFragmentManager().popBackStack();
        return true;
    }
}
