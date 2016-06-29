package com.example.diego.appsinformation.activities;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.diego.appsinformation.BuildConfig;
import com.example.diego.appsinformation.R;
import com.example.diego.appsinformation.adapters.AplicationsAdapter;
import com.example.diego.appsinformation.adapters.CategoriesAdapter;
import com.example.diego.appsinformation.api.IAppsInformationService;
import com.example.diego.appsinformation.model.Application;
import com.example.diego.appsinformation.model.Entry;
import com.example.diego.appsinformation.model.Example;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    public static final String ALL_CATEGORIES = "All Apps";

    IAppsInformationService mIService;
    Example mModel;
    ArrayList<Entry> entries;
    ArrayList<Application> mAplicaciones;
    ArrayList<String> mCategories;
    GridView gv;
    AplicationsAdapter mAdapter;
    CategoriesAdapter mCategoriesAdapter;
    private CoordinatorLayout coordinatorLayout;
    Spinner spCategories;
    ImageView imgSync;
    Animation animationRotate;
    Animation animationTouchApp;
    Animation animationAppImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        View mActionBarView = getLayoutInflater().inflate(R.layout.action_bar, null);
        actionBar.setCustomView(mActionBarView);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        gv = (GridView) findViewById(R.id.gridView);
        imgSync = (ImageView) findViewById(R.id.imgSync);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        spCategories = (Spinner) findViewById(R.id.spCategories);

        //animations
        animationRotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        animationTouchApp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.touchapp);
        animationAppImg = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        animationRotate.setAnimationListener(this);
        animationTouchApp.setAnimationListener(this);
        animationAppImg.setAnimationListener(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.URL_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mIService = retrofit.create(IAppsInformationService.class);
        callService(mIService);

        spCategories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String category = mCategoriesAdapter.getItem(position).toString();
                getData(category);
                loadGrid();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {
                final ImageView imgAppGrid = (ImageView)view.findViewById(R.id.imgApp);
                imgAppGrid.startAnimation(animationTouchApp);

                final Handler handler = new Handler();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Application app = (Application) mAdapter.getItem(position);
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        LayoutInflater inflater = getLayoutInflater();
                        final View inflator = inflater.inflate(R.layout.application_summary, null);

                        TextView tvAppTitle = (TextView) inflator.findViewById(R.id.tvAppTitle);
                        TextView tvAppSummary = (TextView) inflator.findViewById(R.id.tvAppSummary);
                        tvAppSummary.setMovementMethod(new ScrollingMovementMethod());
                        TextView tvArtist = (TextView) inflator.findViewById(R.id.tvArtistValue);
                        TextView tvCategory = (TextView) inflator.findViewById(R.id.tvCategoryValue);
                        TextView tvRelease = (TextView) inflator.findViewById(R.id.tvReleaseValue);
                        ImageView imgApp = (ImageView) inflator.findViewById(R.id.imgApp);

                        tvAppTitle.setText(app.getTitle());
                        tvAppSummary.setText(app.getSummary());
                        tvArtist.setText(app.getArtist());
                        tvCategory.setText(app.getCategory());
                        tvRelease.setText(app.getRelease());
                        Picasso.with(getApplicationContext()).load(app.getImg75()).into(imgApp);
                        imgApp.startAnimation(animationAppImg);
                        builder.setView(inflator);
                        builder.show();
                        imgAppGrid.clearAnimation();
                    }
                }, 800);
            }
        });

        imgSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callService(mIService);
                imgSync.startAnimation(animationRotate);
            }
        });
    }

    private void saveData(ArrayList<Entry> entries) {
        Application.deleteAll(Application.class);
        for (Entry entry : entries) {
            Application app = new Application(Long.parseLong(entry.getId().getAttributes().getImId()), entry.getImName().getLabel(), entry.getImImage().get(0).getLabel(),
                    entry.getImImage().get(1).getLabel(), entry.getImImage().get(2).getLabel(),
                    entry.getSummary().getLabel(), entry.getImPrice().getLabel(), entry.getTitle().getLabel(),
                    entry.getImArtist().getLabel(), entry.getCategory().getAttributes().getLabel(), entry.getImReleaseDate().getAttributes().getLabel());
            app.save();
        }
    }

    private ArrayList<Application> getData(String category) {
        if (TextUtils.isEmpty(category) || category.equals(ALL_CATEGORIES)) {
            mAplicaciones = (ArrayList) Application.listAll(Application.class);
        } else {
            mAplicaciones = (ArrayList) Application.findWithQuery(Application.class, "Select * from Application where category = ?", category);
        }
        return mAplicaciones;
    }

    private void loadGrid() {
        mAdapter = new AplicationsAdapter(getApplicationContext(), mAplicaciones);
        gv.setAdapter(mAdapter);
        findViewById(R.id.loadingPanel).setVisibility(View.GONE);
    }

    private ArrayList<String> getCategories() {
        mCategories = new ArrayList<>();
        for (Application aplication : mAplicaciones) {
            mCategories.add(aplication.getCategory());
        }
        //para quitar duplicados
        Set<String> s = new LinkedHashSet<>(mCategories);
        mCategories.clear();
        mCategories.add(ALL_CATEGORIES);
        mCategories.addAll(s);
        return mCategories;
    }

    private void loadCategories() {
        mCategoriesAdapter = new CategoriesAdapter(getApplicationContext(), mCategories);
        spCategories.setAdapter(mCategoriesAdapter);
    }

    private void initData() {
        getData(ALL_CATEGORIES);
        getCategories();
        loadGrid();
        loadCategories();
    }

    private void callService(IAppsInformationService mIService) {
        Call<Example> call = mIService.getAppsInformation();
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.isSuccessful()) {
                    mModel = response.body();
                    entries = mModel.getFeed().getEntry();
                    saveData(entries);
                    initData();

                    Snackbar snackbar = Snackbar
                            .make(coordinatorLayout, R.string.sync_success, Snackbar.LENGTH_LONG);
                    View sbView = snackbar.getView();
                    TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setTextColor(getResources().getColor(R.color.colorAccent));
                    snackbar.show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                initData();
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, R.string.no_internet, Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
                snackbar.show();
            }
        });
    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onAnimationStart(Animation animation) {
        // TODO Auto-generated method stub

    }
}
