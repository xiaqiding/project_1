package com.bwie.ioread;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView showTextView;

    private String fileName = "xiaqiding.txt";
    private TextView local;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取页面中的组件
        editText = (EditText) findViewById(R.id.addText);
        showTextView = (TextView) findViewById(R.id.showText);
        local = (TextView) findViewById(R.id.localtext);
        Button addButton = (Button) this.findViewById(R.id.addButton);
        Button showButton = (Button) this.findViewById(R.id.showButton);
        Button readlocal= (Button) this.findViewById(R.id.readlocal);

        // 监听单击事件
        addButton.setOnClickListener(listener);
        showButton.setOnClickListener(listener);
        readlocal.setOnClickListener(listener);
    }
    // 声明监听器
    private View.OnClickListener listener = new View.OnClickListener() {
        public void onClick(View v) {
            Button view = (Button) v;
            switch (view.getId()) {
                case R.id.addButton:
                    save();
                    break;
                case R.id.showButton:
                    read();
                    break;
                case R.id.readlocal:
                    local();
                    break;
            }

        }


        private void local() {
            try {
                InputStream stream=getResources().getAssets().open("test.txt");
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(stream));
                String text="";
                String mimeTypeLine = null ;
                while ((mimeTypeLine=bufferedReader.readLine())!=null){
                    text=text+mimeTypeLine;
                }
                local.setText(text);
            } catch (Exception e)  {
                e.printStackTrace();
            }
        }
    };
    private void read() {

        try {
            FileInputStream inputStream=MainActivity.this.openFileInput(fileName);
            byte[] bytes=new byte[1024];
            ByteArrayOutputStream arrayOutputStream=new ByteArrayOutputStream();
            while (inputStream.read(bytes)!=-1){
                arrayOutputStream.write(bytes,0,bytes.length);
            }
            //关流
            inputStream.close();
            arrayOutputStream.close();
            String content=new String(arrayOutputStream.toByteArray());
            showTextView.setText(content);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void save() {
        String content=editText.getText().toString();

        try {
            /* 第一个参数，代表文件名称，注意这里的文件名称不能包括任何的/或者/这种分隔符，只能是文件名
                    *          该文件会被保存在/data/data/应用名称/files/xiaqiding.txt
                    * 第二个参数，代表文件的操作模式
                    *          MODE_PRIVATE 私有（只能创建它的应用访问） 重复写入时会文件覆盖
                    *          MODE_APPEND  私有   重复写入时会在文件的末尾进行追加，而不是覆盖掉原来的文件
                    *          MODE_WORLD_READABLE 公用  可读
            *          MODE_WORLD_WRITEABLE 公用 可读写
                    *  */
            FileOutputStream outputStream=openFileOutput(fileName, Activity.MODE_APPEND);
            outputStream.write(content.getBytes());
            outputStream.flush();
            outputStream.close();
            //Toast.makeText(MainActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
