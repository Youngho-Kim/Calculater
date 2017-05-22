package com.android.kwave.calculater;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int number = 0;
    Button b_num1,b_num2,b_num3,b_num4,b_num5,b_num6,b_num7,b_num8,b_num9,b_num0,b_clean,b_result,b_multiply,b_divide,b_plus,b_minus;
    TextView equal;
    EditText modify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b_num0 = (Button) findViewById(R.id.b_num0);
        b_num1 = (Button) findViewById(R.id.b_num1);
        b_num2 = (Button) findViewById(R.id.b_num2);
        b_num3 = (Button) findViewById(R.id.b_num3);
        b_num4 = (Button) findViewById(R.id.b_num4);
        b_num5 = (Button) findViewById(R.id.b_num5);
        b_num6 = (Button) findViewById(R.id.b_num6);
        b_num7 = (Button) findViewById(R.id.b_num7);
        b_num8 = (Button) findViewById(R.id.b_num8);
        b_num9 = (Button) findViewById(R.id.b_num9);
        b_clean = (Button) findViewById(R.id.b_clean);
        b_result = (Button) findViewById(R.id.b_result);
        b_divide = (Button) findViewById(R.id.b_divide);
        b_multiply = (Button) findViewById(R.id.b_multiply);
        b_plus = (Button) findViewById(R.id.b_plus);
        b_minus = (Button) findViewById(R.id.b_minus);

        equal = (TextView) findViewById(R.id.equal);
        modify = (EditText) findViewById(R.id.modify);

        b_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modify.getText().append((modified(v.getId())));
//                num1 =edit1.getText().toString();
//                num2 =equal.getText().toString();
//                if(num2.equals("") ||num1.equals(""))
//                {
//                    Toast.makeText(getApplicationContext(),"숫자를 입력하세요.",Toast.LENGTH_SHORT).show();
//                }else {
//                    result = Double.parseDouble(num1)+Double.parseDouble(num2);
//                    equal.setText("결과 : "+result.toString());
//                }


            }
        });
        b_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modify.getText().append((modified(v.getId())));
//                num1 =edit1.getText().toString();
//                num2 =equal.getText().toString();
//                if(num2.equals("") ||num1.equals(""))
//                {
//                    Toast.makeText(getApplicationContext(),"숫자를 입력하세요.",Toast.LENGTH_SHORT).show();
//                }else {
//                    result = Double.parseDouble(num1)-Double.parseDouble(num2);
//                    equal.setText("결과 : "+result.toString());
//                }


            }
        });
        b_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modify.getText().append((modified(v.getId())));
//                num1 =edit1.getText().toString();
//                num2 =equal.getText().toString();
//                if(num2.equals("") ||num1.equals(""))
//                {
//                    Toast.makeText(getApplicationContext(),"숫자를 입력하세요.",Toast.LENGTH_SHORT).show();
//                }else {
//                    result = Double.parseDouble(num1)*Double.parseDouble(num2);
//                    equal.setText("결과 : "+result.toString());
//                }


            }
        });
        b_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modify.getText().append((modified(v.getId())));
//                num1 =edit1.getText().toString();
//                num2 =equal.getText().toString();
//                if(num2.equals("") ||num1.equals(""))
//                {
//                    Toast.makeText(getApplicationContext(),"숫자를 입력하세요.",Toast.LENGTH_SHORT).show();
//                }else {
//                    result = Double.parseDouble(num1)/Double.parseDouble(num2);
//                    equal.setText("결과 : "+result.toString());
//                }


            }
        });

//        b_minus.setOnClickListener(this);
//        b_multiply.setOnClickListener(this);
//        b_divide.setOnClickListener(this);
        b_clean.setOnClickListener(this);
        b_result.setOnClickListener(this);
        b_num0.setOnClickListener(this);
        b_num1.setOnClickListener(this);
        b_num2.setOnClickListener(this);
        b_num3.setOnClickListener(this);
        b_num4.setOnClickListener(this);
        b_num5.setOnClickListener(this);
        b_num6.setOnClickListener(this);
        b_num7.setOnClickListener(this);
        b_num8.setOnClickListener(this);
        b_num9.setOnClickListener(this);



    }
        @Override
        public void onClick(View v){

            switch (v.getId()){
                case R.id.b_clean :
                    equal.setText("0");
                    modify.getText().clear();
                    break;
                case R.id.b_result :
                    result();
                    break;
//                case R.id.b_plus :
//                case R.id.b_minus :
//                case R.id.b_multiply :
//                case R.id.b_divide :
//                    modify.getText().append((modified(v.getId())));
//                    break;
                case R.id.b_num0 :
                case R.id.b_num1 :
                case R.id.b_num2 :
                case R.id.b_num3 :
                case R.id.b_num4 :
                case R.id.b_num5 :
                case R.id.b_num6 :
                case R.id.b_num7 :
                case R.id.b_num8 :
                case R.id.b_num9 :
                    modify.getText().append((passNumber(v.getId())));
//                    edit1.getText().append((passNumber(v.getId())));
//                    edit2.getText().append((passNumber(v.getId())));

                    break;

            }

    }

    private void result(){
        String result = modify.getText().toString();
        equal.setText(calculate(result));
        modify.getText().clear();
    }
//    public String getCalculate(String num){
//        return  num;
//        }
private String calculate(String preview){
    String result = "";


    // TODO 문자열을 쪼갠후 우선순위에 따라 연산하시오
    // 1. 문자열을 정규식으로 * / + - 을 이용해서 배열로 자른다
    String splitted[] = preview.split("(?<=[*/+-])|(?=[*/+-])");

// 배열을 중간에 삭제하기 위해서 컬렉션을 사용한다.
    ArrayList<String> list = new ArrayList<>();
    for(String temp : splitted){
        list.add(temp);     // list에 splitted[]를 넣는다.
    }
    // 반복문이 splitted 을 돌면서 * 와 / 만 먼저 연산해준다
      for(int i=0;i<list.size();i++){
          String temp = list.get(i);    // temp에 list 값을 넣어줌
          int resultTemp =0;            // 결과값을 가지고 있을 변수
          if(temp.equals("*")|| temp.equals("/")) {
              int start = Integer.parseInt(list.get(i-1));      // i가 0을 가질때 start는 splitted[-1]이 되기 때문에 이곳으로 썼다.
              int end = Integer.parseInt(list.get(i+1));
              if (temp.equals("*")) {
                  resultTemp = start * end;
              } else {
                  resultTemp = start / end;
              }
              // 결과값 저장
              list.set(i, resultTemp+"");   // i번째 있는 값을 resultTemp+""로 덮어쓰기
//              list.add(splitted[i]);
              // 배열값 삭제
              list.remove(i+1);   // 쓰지 않을 배열값 삭제
              list.remove(i-1);   // 쓰지 않을 배열값 삭제
              i--;                          // 배열 값 맞추기 위해 인덱스 한개 줄임
          }
      }
    // 반복문이 splitted 을 돌면서 +와 -를 연산해준다
    for(int i=0;i<list.size();i++){
        String temp = list.get(i);
        int resultTemp =0;
        if(temp.equals("+")|| temp.equals("-")){
            int start = Integer.parseInt(list.get(i-1));      // i가 0을 가질때 start는 splitted[-1]이 되기 때문에 이곳으로 썼다.
            int end = Integer.parseInt(list.get(i+1));
            if (temp.equals("+")) {
                resultTemp = start + end;
            } else {
                resultTemp = start - end;
            }
            splitted[i] = resultTemp+"";
            // 결과값 저장
                list.set(i, resultTemp+"");   // i번째 있는 값을 resultTemp+""로 덮어쓰기
//              list.add(splitted[i]);
            // 배열값 삭제
            list.remove(i+1);   // 쓰지 않을 배열값 삭제
            list.remove(i-1);   // 쓰지 않을 배열값 삭제
            i--;
        }
    }


    return list.get(0);
}

    public String passNumber(int id){

            switch (id){
                case R.id.b_num0 :
                    number = 0;

                    break;
                case R.id.b_num1 :
                    number = 1;

                    break;
                case R.id.b_num2 :
                    number = 2;

                    break;
                case R.id.b_num3 :
                    number = 3;

                    break;
                case R.id.b_num4 :
                    number = 4;

                    break;
                case R.id.b_num5 :
                    number = 5;

                    break;
                case R.id.b_num6 :
                    number = 6;

                    break;
                case R.id.b_num7 :
                    number = 7;

                    break;
                case R.id.b_num8 :
                    number = 8;

                    break;
                case R.id.b_num9 :
                    number = 9;

                    break;
            }
            return number+"";
        }
    public String modified(int id) {
        String modified = null;
        switch (id) {
            case R.id.b_plus:
                modified = "+";
                break;
            case R.id.b_minus:
                modified = "-";
                break;
            case R.id.b_multiply:
                modified = "*";
                break;
            case R.id.b_divide:
                modified = "/";
                break;
        }
        return modified;
    }
}
