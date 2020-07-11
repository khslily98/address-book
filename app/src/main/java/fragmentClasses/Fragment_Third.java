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
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.myapplication.Alarm_Receiver;
import com.example.myapplication.R;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

public class Fragment_Third extends Fragment {
    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    Context context;
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
        context = getActivity();

        // 알람매니저 설정
        alarm_manager = (AlarmManager) getActivity().getSystemService(ALARM_SERVICE);

        // 타임피커 설정
        alarm_timepicker = view.findViewById(R.id.time_picker);

        // Calendar 객체 생성
        final Calendar calendar = Calendar.getInstance();

        // 알람리시버 intent 생성
        final Intent my_intent = new Intent(context, Alarm_Receiver.class);

        // 알람 시작 버튼
        Button alarm_on = (Button) view.findViewById(R.id.btn_start);
        alarm_on.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                // calendar에 시간 셋팅
                System.out.println("this is debugging starts");
                System.out.println(alarm_timepicker.getHour());
                calendar.set(Calendar.HOUR_OF_DAY, alarm_timepicker.getHour());
                calendar.set(Calendar.MINUTE, alarm_timepicker.getMinute());

                // 시간 가져옴
                int hour = alarm_timepicker.getHour();
                int minute = alarm_timepicker.getMinute();
                Toast.makeText(getActivity(),"Alarm 예정 " + hour + "시 " + minute + "분",Toast.LENGTH_SHORT).show();

                // reveiver에 string 값 넘겨주기
                my_intent.putExtra("state","alarm on");

                pendingIntent = PendingIntent.getBroadcast(getActivity(), 0, my_intent,
                        PendingIntent.FLAG_UPDATE_CURRENT);

                // 알람셋팅
                alarm_manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                        pendingIntent);
            }
        });

        // 알람 정지 버튼
        Button alarm_off = (Button) view.findViewById(R.id.btn_stop);
        alarm_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Alarm 종료",Toast.LENGTH_SHORT).show();
                // 알람매니저 취소
                alarm_manager.cancel(pendingIntent);

                my_intent.putExtra("state","alarm off");

                // 알람취소
                context.sendBroadcast(my_intent);
            }
        });

        return view;
    }

}