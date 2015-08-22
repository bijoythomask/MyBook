package com.smartapps.com.mybook;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment {


    public static final String MY_PREFERENCES = "MY_PREFERENCES";

    public static final String USER_LEARNED_DRAWER = "USER_LEARNED_DRAWER";

    private ActionBarDrawerToggle mDrawerToggle;

    View containerView;

    private DrawerLayout mDrawerLayout;

    private boolean mUserLearnedDrawer;

    private boolean mFromSavedInstance;

    private ListView languageSelection;

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserLearnedDrawer = Boolean.valueOf(readPreferences(getActivity(), USER_LEARNED_DRAWER, "false"));
        languageSelection = (ListView) getActivity().findViewById(R.id.listView);
        String[] langaues = getActivity().getResources().getStringArray(R.array.menu_language);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, langaues);
    }

    public void setUp(int ViewId, DrawerLayout drawerLayout, final Toolbar toolbar) {

        containerView = getActivity().findViewById(ViewId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (!mUserLearnedDrawer) {
                    mUserLearnedDrawer = true;
                    saveToPreferences(getActivity(), USER_LEARNED_DRAWER, Boolean.toString(mUserLearnedDrawer));
                }
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                if (slideOffset < 0.7) {
                    toolbar.setAlpha(1 - slideOffset);
                }
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (!mUserLearnedDrawer && !mFromSavedInstance) {
            mDrawerLayout.openDrawer(containerView);
        }

        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }


    public static void saveToPreferences(Context context, String preferenceName, String preferenceValue) {

        SharedPreferences sharedPrefences = context.getSharedPreferences(MY_PREFERENCES, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefences.edit();
        editor.putString(preferenceName, preferenceValue);
        editor.apply();

    }

    public static String readPreferences(Context context, String preferenceName, String defaultValue) {
        SharedPreferences sharedPrefences = context.getSharedPreferences(MY_PREFERENCES, context.MODE_PRIVATE);
        return sharedPrefences.getString(preferenceName, defaultValue);
    }


}
