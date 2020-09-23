package ir.smartdevelop.eram.showcaseview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import smartdevelop.ir.eram.showcaseviewlib.GuideView;
import smartdevelop.ir.eram.showcaseviewlib.config.DismissType;
import smartdevelop.ir.eram.showcaseviewlib.config.Gravity;
import smartdevelop.ir.eram.showcaseviewlib.listener.GuideListener;

public class MainActivity extends AppCompatActivity {

    View view1;
    View view2;
    View view3;
    View view4;
    View view5;
    private GuideView mGuideView;
    private GuideView.Builder builder;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        view3 = findViewById(R.id.view3);
        view4 = findViewById(R.id.view4);
        view5 = findViewById(R.id.view5);

        builder = new GuideView.Builder(this)
//                .setTitle("Guide Title Text")
                .setContentText("Keep track of your loved one’s whereabouts using a real-time location tracker")
                .setContentTextSize(20)
                .setGravity(Gravity.center)
                .setDismissType(DismissType.anywhere)
                .setNextText("Next")
                .setCloseText("Close")
                .setNextBtnIcon(R.drawable.ic_launcher_background)
                .setCloseBtnIcon(R.drawable.ic_launcher_background)
                .setNextBtnTextSize(22)
                .setCloseBtnTextSize(22)
                .setNextBtnColor(Color.BLACK)
                .setCloseBtnColor(Color.BLACK)
                .setNextBtnListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "next", Toast.LENGTH_SHORT).show();
                        mGuideView.dismiss();
                    }
                })
                .setCloseBtnListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "close", Toast.LENGTH_SHORT).show();
                    }
                })
                .setCloseBtnTextTypeFace(Typeface.DEFAULT_BOLD)
                .setNextBtnTextTypeFace(Typeface.DEFAULT_BOLD)
                .setTargetView(view1)
                .setGuideListener(new GuideListener() {
                    @Override
                    public void onDismiss(View view) {
                        switch (view.getId()) {
                            case R.id.view1:
                                builder.setTargetView(view2).build();
                                break;
                            case R.id.view2:
                                builder.setTargetView(view3).build();
                                break;
                            case R.id.view3:
                                builder.setTargetView(view4).build();
                                break;
                            case R.id.view4:
                                builder.setTargetView(view5).build();
                                break;
                            case R.id.view5:
                                return;
                        }
                        mGuideView = builder.build();
                        mGuideView.show();
                    }
                });

        mGuideView = builder.build();
        mGuideView.show();

        updatingForDynamicLocationViews();
    }

    private void updatingForDynamicLocationViews() {
        view4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                mGuideView.updateGuideViewLocation();
            }
        });
    }

}
