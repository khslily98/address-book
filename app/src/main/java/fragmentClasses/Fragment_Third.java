package fragmentClasses;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.myapplication.Alarm_Receiver;
import com.example.myapplication.R;

import java.util.Calendar;
import java.util.Random;

import static android.content.Context.ALARM_SERVICE;

public class Fragment_Third extends Fragment {
    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    PendingIntent pendingIntent;
    public Fragment_Third(){
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_third,container,false);

        // 알람매니저 설정
        alarm_manager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);

        // 타임피커 설정
        alarm_timepicker = view.findViewById(R.id.timePicker);

        // Calendar 객체 생성
        final Calendar calendar = Calendar.getInstance();

        // 알람리시버 intent 생성
        final Intent my_intent = new Intent( getActivity(), Alarm_Receiver.class);

        // 알람 시작 버튼
        Button alarm_on = view.findViewById(R.id.button);
        alarm_on.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                // calendar에 시간 셋팅
                calendar.set(Calendar.HOUR_OF_DAY, alarm_timepicker.getHour());
                calendar.set(Calendar.MINUTE, alarm_timepicker.getMinute());

                // 시간 가져옴
                int hour = alarm_timepicker.getHour();
                int minute = alarm_timepicker.getMinute();
                Toast.makeText(getActivity(),"Alarm 예정 " + hour + "시 " + minute + "분",Toast.LENGTH_SHORT).show();

                // receiver에 string 값 넘겨주기
                my_intent.putExtra("state","alarm on");
                pendingIntent = PendingIntent.getBroadcast( getActivity(), 0, new Intent(),
                        PendingIntent.FLAG_UPDATE_CURRENT);
                System.out.println(pendingIntent);
                System.out.println("Here the alarm sets.");
                // 알람셋팅
                alarm_manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
            }
        });
        // 알람 정지 버튼
        Button alarm_off = view.findViewById(R.id.btn_stop);
        final TextView text_pwhint = (TextView) view.findViewById(R.id.passwordhint);
        text_pwhint.setText(randomAlphaNumeric(1));
        alarm_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText text_pw = (EditText) view.findViewById(R.id.password);
                String pw = text_pw.getText().toString();

                String pw_hint = text_pwhint.getText().toString();
                System.out.println(pw_hint);

                if (pendingIntent == null){
                    Toast.makeText(getActivity(), "No alarm has been set", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (pw.equals(pw_hint)) {
                    Toast.makeText(getActivity(), "Password correct! Alarm Off", Toast.LENGTH_SHORT).show();
                    alarm_manager.cancel(pendingIntent);
                    my_intent.putExtra("state", "alarm off");
                    getActivity().sendBroadcast(my_intent);
                    }
                    else {
                    Toast.makeText(getActivity(), "password wrong try again!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return view;
    }
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789~!@#$%^&**()_+=-;/?<>,.{}[]";
    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
}