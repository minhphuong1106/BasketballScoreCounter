package com.example.basketballscorecounter;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnIncrementPoint1A;
    private Button btnIncrementPoint2A;
    private Button btnIncrementPoint3A;
    private Button btnIncrementPoint1B;
    private Button btnIncrementPoint2B;
    private Button btnIncrementPoint3B;
    private Button btnReset;
    private BasketBallCounterBusiness teamA;
    private BasketBallCounterBusiness teamB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapIdToViews();
        teamA = new BasketBallCounterBusiness(R.id.btnIncrementPoint1A, R.id.btnIncrementPoint2A,
                R.id.btnIncrementPoint3A, R.id.tvTeamACounter);
        teamB = new BasketBallCounterBusiness(R.id.btnIncrementPoint1B, R.id.btnIncrementPoint2B,
                R.id.btnIncrementPoint3B, R.id.tvTeamBCounter);
        btnIncrementPoint1A.setOnClickListener(this);
        btnIncrementPoint2A.setOnClickListener(this);
        btnIncrementPoint3A.setOnClickListener(this);
        btnIncrementPoint1B.setOnClickListener(this);
        btnIncrementPoint2B.setOnClickListener(this);
        btnIncrementPoint3B.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }

    private void mapIdToViews(){
        btnIncrementPoint1A = findViewById(R.id.btnIncrementPoint1A);
        btnIncrementPoint2A = findViewById(R.id.btnIncrementPoint2A);
        btnIncrementPoint3A = findViewById(R.id.btnIncrementPoint3A);
        btnIncrementPoint1B = findViewById(R.id.btnIncrementPoint1B);
        btnIncrementPoint2B = findViewById(R.id.btnIncrementPoint2B);
        btnIncrementPoint3B = findViewById(R.id.btnIncrementPoint3B);
        btnReset = findViewById(R.id.btnReset);
    }

    private void setDisplayResult(BasketBallCounterBusiness team){
        TextView displayCtrl = findViewById(team.get_DisplayCtrlId());
        displayCtrl.setText(String.valueOf(team.get_Counter()));
    }

    @Override
    public void onClick(View v) {
        int incrementTypeId = v.getId();
        switch (incrementTypeId) {
            case R.id.btnIncrementPoint1A:
            case R.id.btnIncrementPoint2A:
            case R.id.btnIncrementPoint3A:
                teamA.incrementCounter(incrementTypeId);
                setDisplayResult(teamA);
                break;
            case R.id.btnIncrementPoint1B:
            case R.id.btnIncrementPoint2B:
            case R.id.btnIncrementPoint3B:
                teamB.incrementCounter(incrementTypeId);
                setDisplayResult(teamB);
                break;
            default: // Reset button
                teamA.resetCounter();
                teamB.resetCounter();
                setDisplayResult(teamA);
                setDisplayResult(teamB);
        }
    }
}

